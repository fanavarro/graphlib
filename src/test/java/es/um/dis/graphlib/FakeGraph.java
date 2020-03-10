package es.um.dis.graphlib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * The Class FakeGraph.
 */
public class FakeGraph extends AbstractGraph<String, String> {

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.AbstractGraph#getAdjacentNodesWithEdges(java.lang.Object)
	 */
	@Override
	public Map<String, Set<String>> getAdjacentNodesWithEdges(String node) {
		Map<String, Set<String>> adjacentNodes = new HashMap<String, Set<String>>();
		if ("A".equals(node)) {
			adjacentNodes.put("1", new HashSet<String>(Arrays.asList("B")));
		} else if ("B".equals(node)) {
			adjacentNodes.put("2", new HashSet<String>(Arrays.asList("C")));
			adjacentNodes.put("3", new HashSet<String>(Arrays.asList("D")));
		} else if ("C".equals(node)) {
			adjacentNodes.put("8", new HashSet<String>(Arrays.asList("B")));
		} else if ("D".equals(node)) {
			adjacentNodes.put("4", new HashSet<String>(Arrays.asList("E")));
		} else if ("E".equals(node)) {
			adjacentNodes.put("5", new HashSet<String>(Arrays.asList("F")));
			adjacentNodes.put("6", new HashSet<String>(Arrays.asList("F")));
			adjacentNodes.put("7", new HashSet<String>(Arrays.asList("C")));
		} else if ("F".equals(node)) {
			// no edges
		} else if ("G".equals(node)){
			adjacentNodes.put("9", new HashSet<String>(Arrays.asList("I")));
			adjacentNodes.put("10", new HashSet<String>(Arrays.asList("J")));
		} else if ("H".equals(node)){
			adjacentNodes.put("11", new HashSet<String>(Arrays.asList("I")));
			adjacentNodes.put("12", new HashSet<String>(Arrays.asList("J")));
		} else if ("I".equals(node)) {
			// no edges
		} else if ("J".equals(node)) {
			// no edges
		}
		return adjacentNodes;
	}

	/* (non-Javadoc)
	 * @see es.um.dis.graphlib.AbstractGraph#getNodes()
	 */
	@Override
	public Set<String> getNodes() {
		return new HashSet<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
	}
}
