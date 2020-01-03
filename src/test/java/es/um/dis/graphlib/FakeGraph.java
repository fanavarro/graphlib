package es.um.dis.graphlib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FakeGraph extends Graph<String, String> {

	@Override
	public Map<String, Set<String>> getAdjacentNodes(String node) {
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
		}
		return adjacentNodes;
	}

	@Override
	public Set<String> getSourceNodesFromEdge(String edge) {
		Set<String> nodes = new HashSet<String>();
		if ("1".equals(edge)) {
			nodes.add("A");
		} else if ("2".equals(edge)) {
			nodes.add("B");
		} else if ("3".equals(edge)) {
			nodes.add("B");
		} else if ("4".equals(edge)) {
			nodes.add("D");
		} else if ("5".equals(edge)) {
			nodes.add("E");
		} else if ("6".equals(edge)) {
			nodes.add("E");
		} else if ("7".equals(edge)) {
			nodes.add("E");
		} else if ("8".equals(edge)) {
			nodes.add("C");
		}
		return nodes;
	}

}
