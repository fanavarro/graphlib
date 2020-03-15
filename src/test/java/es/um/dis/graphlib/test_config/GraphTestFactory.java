package es.um.dis.graphlib.test_config;

import org.meanbean.lang.Factory;

import es.um.dis.graphlib.FakeGraph;
import es.um.dis.graphlib.Graph;


// TODO: Auto-generated Javadoc
/**
 * A factory for creating GraphTest objects.
 */
public class GraphTestFactory implements Factory<Graph<String, String>>{

	/* (non-Javadoc)
	 * @see org.meanbean.lang.Factory#create()
	 */
	@Override
	public Graph<String, String> create() {
		return new FakeGraph();
	}

}
