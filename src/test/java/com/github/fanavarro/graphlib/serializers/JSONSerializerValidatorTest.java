package com.github.fanavarro.graphlib.serializers;


import org.everit.json.schema.ValidationException;
import org.junit.Test;

/**
 * The Class JSONSerializerValidatorTest.
 */
public class JSONSerializerValidatorTest {

	/**
	 * Test validate JGF valid string.
	 */
	@Test
	public void testValidateJGFValidString() {
		String jgf = this.getValidJGF();
		JSONSerializerValidator.validateJGF(jgf);
	}
	
	/**
	 * Test validate JGF invalid string.
	 */
	@Test(expected = ValidationException.class)
	public void testValidateJGFInvalidString() {
		String jgf = this.getInvalidJGF();
		JSONSerializerValidator.validateJGF(jgf);
	}
	
	/**
	 * Gets the valid JGF.
	 *
	 * @return the valid JGF
	 */
	private String getValidJGF(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("  \"graph\" : {");
		sb.append("    \"label\" : \"Test Graph\",");
		sb.append("    \"directed\" : true,");
		sb.append("    \"nodes\" : [ {");
		sb.append("      \"id\" : \"A\",");
		sb.append("      \"label\" : \"A\"");
		sb.append("    }, {");
		sb.append("      \"id\" : \"B\",");
		sb.append("      \"label\" : \"B\"");
		sb.append("    }],");
		sb.append("    \"edges\" : [ {");
		sb.append("      \"source\" : \"A\",");
		sb.append("      \"target\" : \"B\",");
		sb.append("      \"relation\" : \"1\",");
		sb.append("      \"label\" : \"1\"");
		sb.append("    } ]");
		sb.append("  }");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Gets the invalid JGF.
	 *
	 * @return the invalid JGF
	 */
	private String getInvalidJGF(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("  \"graphic\" : {");
		sb.append("    \"label\" : \"Test Graph\",");
		sb.append("    \"directed\" : true,");
		sb.append("    \"nodes\" : [ {");
		sb.append("      \"id\" : \"A\",");
		sb.append("      \"label\" : \"A\"");
		sb.append("    }, {");
		sb.append("      \"id\" : \"B\",");
		sb.append("      \"label\" : \"B\"");
		sb.append("    }],");
		sb.append("    \"edges\" : [ {");
		sb.append("      \"source\" : \"A\",");
		sb.append("      \"target\" : \"B\",");
		sb.append("      \"relation\" : \"1\",");
		sb.append("      \"label\" : \"1\"");
		sb.append("    } ]");
		sb.append("  }");
		sb.append("}");
		return sb.toString();
	}
}
