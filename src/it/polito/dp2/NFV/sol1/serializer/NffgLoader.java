package it.polito.dp2.NFV.sol1.serializer;

import java.math.BigInteger;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;

import it.polito.dp2.NFV.*;
import it.polito.dp2.NFV.sol1.CalendarXMLconverter;
import it.polito.dp2.NFV.sol1.jaxb.*;

public class NffgLoader {
	
	private NffgReader nfgr;
	private ObjectFactory objFactory;
	
	protected NffgLoader(NffgReader nfgr, ObjectFactory objFactory) {
		this.nfgr = nfgr;
		this.objFactory = objFactory;
	}
	
	// generate an XML tree that contain the information about the  nffgGraph read from the nfv interface
	protected NffgType generateGraph() {
		NffgType nffgGraph = objFactory.createNffgType();				// create a new nffg instance
		
		System.out.println("begin to create " + nfgr.getName() + " nffg element");
		
		// set the graph deploy date, if is not possible to convert the value set a null value
		try {
			nffgGraph.setNffgName(nfgr.getName());																	
			nffgGraph.setDeployTime(CalendarXMLconverter.toXMLGregorianCalendar(nfgr.getDeployTime()));			
		} catch (DatatypeConfigurationException de) {
			System.out.println("the date cannot be converted into XML gregorian calendar");
			nffgGraph.setDeployTime(null);
		}
		
		// update the nffgGraph with the list of the nodes
		Set<NodeReader> nodeSet = nfgr.getNodes();	
		if(nodeSet.isEmpty()) 
			return nffgGraph;
					
		for(NodeReader nr: nodeSet) {					
			System.out.println("begin to read " + nr.getName() + " node information");
			nffgGraph.getNode().add(generateNode(nr));				
		}
		
		System.out.println("nffg loaded correcly!\n");
		return nffgGraph;
	}
	
	// generate a node element instance, it contains link elements that connect this node with other nodes
	private NodeType generateNode(NodeReader nr) {
		NodeType newNode = objFactory.createNodeType();			// instantiate a new node

		// set Node attributes
		newNode.setName(nr.getName());							
		newNode.setHostname(nr.getHost().getName());
		newNode.setVNF(nr.getFuncType().getName());
		newNode.setNfFg(nr.getNffg().getName());
		
		Set<LinkReader> linkSet = nr.getLinks();				// get the set of link reader from the node reader interface
		if (linkSet.isEmpty()) {
			System.out.println("this node doesn't contain any link");
			return newNode;
		}

		for(LinkReader lr: linkSet) {
			System.out.println("begin to read the link information");
			newNode.getLink().add(generateLink(lr));			// add the linkType instance into node's list of links
		}

		return newNode;
	}
	
	// generate link element starting from the link reader interface
	private LinkType generateLink(LinkReader lr) {
		LinkType newLink = objFactory.createLinkType();
	
		if (lr.getLatency() != 0) {											// if the interface return 0 the latency attribute will not be specified
			newLink.setLatency(BigInteger.valueOf(lr.getLatency()));
		} else {
			newLink.setLatency(null);
		}
		
		if (lr.getThroughput() != 0) {										// if the interface return 0 the throughput attribute will not be specified
			newLink.setThroughput(lr.getThroughput());
		} else {
			newLink.setThroughput(null);
		}
		
		// set the other link information
		newLink.setLinkName(lr.getName());
		newLink.setDestinationNode(lr.getDestinationNode().getName());
		newLink.setSourceNode(lr.getSourceNode().getName());
		
		return newLink;
	}
}
