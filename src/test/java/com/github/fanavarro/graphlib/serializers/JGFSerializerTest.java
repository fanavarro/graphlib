package com.github.fanavarro.graphlib.serializers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import com.github.fanavarro.graphlib.FakeGraph;
import com.github.fanavarro.graphlib.Graph;

public class JGFSerializerTest {

	@Test
	public void testSerialize() {
		Graph <String, String> graph = new FakeGraph();
		JGFSerializer<String, String> serializer = new JGFSerializer<>();
		assertNotNull(serializer.getMapper());
		
		String serialization = serializer.serialize(graph, "Fake Graph");
		assertNotNull(serialization);
		assertTrue(!serialization.isEmpty());
		
		//JSONObject jsonSchema = new JSONObject(new JSONTokener(JGFSerializerTest.class.getResourceAsStream("/jsonValidationSchemas/JGFSchema.json")));
		JSONObject jsonInput = new JSONObject(serialization);
		JSONSerializerValidator.validateJGF(jsonInput);
	}

}
