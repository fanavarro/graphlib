package es.um.dis.graphlib.algorithms.least_common_node;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class LeastCommonNodeInputTest {

	@Test
	public void test() {
		Configuration configuration = new ConfigurationBuilder().ignoreProperty("graph").build();
		new BeanTester().testBean(LeastCommonNodeInput.class, configuration);
	}

}
