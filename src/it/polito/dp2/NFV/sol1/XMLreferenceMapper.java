package it.polito.dp2.NFV.sol1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.dp2.NFV.sol1.jaxb.ConnectionType;
import it.polito.dp2.NFV.sol1.jaxb.FunctionType;
import it.polito.dp2.NFV.sol1.jaxb.HostType;
import it.polito.dp2.NFV.sol1.jaxb.NFV;
import it.polito.dp2.NFV.sol1.jaxb.NffgType;
import it.polito.dp2.NFV.sol1.jaxb.NodeType;

class XMLreferenceMapper {

	// HashMaps declaration
	private Map<String, NodeType> nodeMap = new HashMap<String, NodeType> ();
	private Map<String, FunctionType> VNFmap = new HashMap<String, FunctionType> ();
	private Map<String, NffgType> nffgMap = new HashMap<String, NffgType> ();
	private Map<String, HostType> hostMap = new HashMap<String, HostType> ();
	
	// HashMap with two keys
	private Map<StringPair, ConnectionType> connMap = new HashMap<StringPair, ConnectionType> ();
	private Map<StringPair, NodeType> nodeNffgMap = new HashMap<StringPair, NodeType> ();
	
	// NFV reference
	private NFV newNFV;
	
	protected XMLreferenceMapper(NFV newNFV) {
		this.newNFV = newNFV;									// get the NFV unmarshalled object and create a reference table
		
		// load the data in the hashMaps
		loadNffg();
		loadHost();
		loadVNF();
		loadConnection();
		
		// hashMap assertions
		assert nodeMap.isEmpty() : "node map is empty";
		assert VNFmap.isEmpty() : "VNF map is empty";
		assert nffgMap.isEmpty() : "nffg map is empty";
		assert hostMap.isEmpty() : "host map is empty";
		assert connMap.isEmpty() : "connection map is empty";
	}
	
	// method for the node search inside the hashmap
	protected NodeType getNode(String nodeName) {					
		return nodeMap.get(nodeName);
	}
	
	// method for the nffg search inside the hashmap
	protected NffgType getGraph(String graphName) {					
		return nffgMap.get(graphName);
	}
	
	// method for the VNF search inside the hashmap
	protected FunctionType getVNF(String functionName) {			
		return VNFmap.get(functionName);
	}
	
	// method for the host search inside the hasmap
	protected HostType getHost(String hostName) {					
		return hostMap.get(hostName);
	}
	
	// method for the connection searh inside the hashmap
	protected ConnectionType getConnection(String hostname1, String hostname2) {	
		StringPair hostPair = new StringPair(hostname1, hostname2);
		return connMap.get(hostPair);
	}
	
	// return the null if not exist a pair nodeName graphname inside the HashMap
	protected NodeType getNodeInsideNffg(String nodeName, String graphName) {
		StringPair nodeNffgPair = new StringPair(nodeName, graphName);
		return nodeNffgMap.get(nodeNffgPair);
	}
	
	private void loadNffg() {											// this method load nodes and nffgs
		List<NffgType> graphList = newNFV.getNfFg();					// get the list of nffg and load it into the hashMap
		
		for (NffgType nffgElement: graphList) {
			nffgMap.put(nffgElement.getName(), nffgElement);			// put all the nffg element into the hashmap
			
			// begin to load the node
			loadNode(nffgElement);										
		}
	}
	
	private void loadHost() {
		List<HostType> hostList = newNFV.getInfNet().getHostGroup().getHost();		// get the list of host 
		
		// load the hostList into the the hashMap
		for (HostType hostElement: hostList) {																
			hostMap.put(hostElement.getHostname(), hostElement);					// put the element into the hashmap
		}
	}
	
	private void loadNode(NffgType graph) {
		List<NodeType> nodeList = graph.getNode();					// get the list of node and load it into the hashMap
		
		for (NodeType nodeElement: nodeList) {
			// insert the single node inside the map 
			nodeMap.put(nodeElement.getName(), nodeElement);
			
			// insert the node graph pair inside the map
			StringPair node_nffg = new StringPair(nodeElement.getName(), graph.getName());
			nodeNffgMap.put(node_nffg, nodeElement);
		}
	}
	
	private void loadVNF() {
		List<FunctionType> functionList = newNFV.getCatalog().getFunction();		// get the list of function 
		
		// load the function List into the hashMap
		for (FunctionType f: functionList) {
			VNFmap.put(f.getName(), f);
		}
	}
	
	private void loadConnection() {
		List<ConnectionType> connList = newNFV.getInfNet().getConnections().getConnection();
		
		// load the connection performance into the hashmap
		for (ConnectionType c: connList) {
			StringPair hostPair = new StringPair(c.getHostname1(), c.getHostname2());
			connMap.put(hostPair, c);
		}
		
	}
	
}