package com.github.fanavarro.graphlib.serializers;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Class for validating json files.
 * @author fabad
 *
 */
public class JSONSerializerValidator {
	
	/** The jgf schema resource. */
	private static String JGF_SCHEMA_RESOURCE = "/jsonValidationSchemas/JGFSchema.json";
	
	/**
	 * Validate inputJson according schemaJson. A ValidationException is thrown if the schema is not being followed.
	 * @param schemaJson JSONObject with the schema.
	 * @param inputJson JSONObject with the JSON to be validated.
	 */
	public static void validateJSON(JSONObject schemaJson, JSONObject inputJson){
		Schema schema = SchemaLoader.load(schemaJson);
		schema.validate(inputJson);
	}
	
	/**
	 * Check if the inputJson is compliant with JSON Graph Format Schema.
	 * @param inputJson The json to check.
	 */
	public static void validateJGF(JSONObject inputJson){
		JSONObject schemaJson = new JSONObject(new JSONTokener(JSONSerializerValidator.class.getResourceAsStream(JGF_SCHEMA_RESOURCE)));
		validateJSON(schemaJson, inputJson);
	}
	
	/**
	 * Check if the inputJson is compliant with JSON Graph Format Schema.
	 *
	 * @param inputString the input string
	 */
	public static void validateJGF(String inputString){
		JSONObject inputJson = new JSONObject(inputString);
		validateJGF(inputJson);
	}

}
