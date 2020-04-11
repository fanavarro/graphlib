package com.github.fanavarro.graphlib.serializers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;

public class JGFSerializerTest {

	@Test
	public void testSerialize() {
		Graph <String, String> graph = new FakeGraph();
		Serializer<String, String> serializer = new JGFSerializer<>();
		String serialization = serializer.serialize(graph, "Fake Graph");
		assertNotNull(serialization);
		assertTrue(!serialization.isEmpty());
		System.out.println(serialization);
	}

}
