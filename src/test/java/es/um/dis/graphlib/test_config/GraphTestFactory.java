package es.um.dis.graphlib.test_config;

import org.meanbean.lang.Factory;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.Graph;

public class GraphTestFactory implements Factory<Graph<String, String>>{

	@Override
	public Graph<String, String> create() {
		return new FakeGraph();
	}

}
