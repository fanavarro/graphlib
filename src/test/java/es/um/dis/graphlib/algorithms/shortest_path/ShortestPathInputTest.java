package es.um.dis.graphlib.algorithms.shortest_path;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class ShortestPathInputTest {

	@Test
	public void test() {

		Configuration configuration = new ConfigurationBuilder().ignoreProperty("graph").build();
		new BeanTester().testBean(ShortestPathInput.class, configuration);
	}

}
