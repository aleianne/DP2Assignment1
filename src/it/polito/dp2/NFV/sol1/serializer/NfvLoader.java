package it.polito.dp2.NFV.sol1.serializer;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import it.polito.dp2.NFV.NffgReader;
import it.polito.dp2.NFV.NfvReader;
import it.polito.dp2.NFV.NfvReaderException;
import it.polito.dp2.NFV.NfvReaderFactory;
import it.polito.dp2.NFV.VNFTypeReader;
import it.polito.dp2.NFV.sol1.jaxb.*;


// this module create the instance of the XML binded class
// starting from the information read from the nfv interface passed in the costructor
public class NfvLoader {
	
	private NfvReader monitor;
	private ObjectFactory objectFactory;
	private NFV newNFV;

	/*public NfvLoader() throws NfvReaderException {
		NfvReaderFactory factory = NfvReaderFactory.newInstance();					// implements a new reader factory
		monitor = factory.newNfvReader();											// implements a new NFV reader factory
		newNFV = new NFV(); 														// implements a new NFV object used for the XML marsahlling
	}*/
	
	public NfvLoader(NfvReader monitor) {
		this.monitor = monitor;

		// create a new object factory and a new NFV object
		objectFactory = new ObjectFactory();
		newNFV = objectFactory.createNFV();
	}
	
	// create an instance of an nffg using the informations contained into the nffgReader interface
	private void mapGraphs() {
		newNFV.setNffgList(new NFV.NffgList());
		List<NffgType> nfvGraphList = newNFV.getNffgList().getNffg();								// get the reference of the Nffg list contained inside the NFV
				
		System.out.println("number of nffg: " + monitor.getNffgs(null).size() + "\n");
		
		for (NffgReader nfgr: monitor.getNffgs(null)) {								// for each element in the reader set create a new Nffg XML element
			NffgLoader gen = new NffgLoader(nfgr, objectFactory);
			nfvGraphList.add(gen.generateGraph());									// add the nffg XML element into the list of nffg element
		}
	}
	
	private void mapInfrastructure() {
		InfrastructureLoader infLoader = new InfrastructureLoader(monitor, objectFactory);
		newNFV.setInfNet(infLoader.generateNetwork());
	}
	
	private void mapCatalog() {
		newNFV.setCatalog(new CatalogType());
		List<FunctionType> functions = newNFV.getCatalog().getFunction();						// get the function list reference							
		
		System.out.println("load the Virtual function...");
		
		for (VNFTypeReader vtr: monitor.getVNFCatalog()) {
			FunctionType newVNF = new FunctionType();											// create a new VNF element
			
			// set the VNF element taking as source the interface data 
			newVNF.setName(vtr.getName());
			newVNF.setRequiredMemory(BigInteger.valueOf(vtr.getRequiredMemory()));
			newVNF.setRequiredStorage(BigInteger.valueOf(vtr.getRequiredStorage()));
			newVNF.setType(FunctionEnumeration.fromValue(vtr.getFunctionalType().value()));
			functions.add(newVNF);
		}

		System.out.println("function loaded correctly!\n");
	}
	
	public NFV getNFV() {
		System.out.println("*** Begin to load the DP2-NFV info into the Java content tree ***");
		mapGraphs();
		mapInfrastructure();
		mapCatalog();
		System.out.println("*** DP2-NFV info loaded correctly! ***\n");	
		return newNFV;
	}
	
	
}
