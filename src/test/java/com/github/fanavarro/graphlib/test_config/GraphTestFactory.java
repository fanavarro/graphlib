package com.github.fanavarro.graphlib.test_config;

import org.meanbean.lang.Factory;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;

/**
 * A factory for creating GraphTest objects.
 */
public class GraphTestFactory implements Factory<Graph<String, String>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.meanbean.lang.Factory#create()
	 */
	@Override
	public Graph<String, String> create() {
		return new FakeGraph();
	}

}
