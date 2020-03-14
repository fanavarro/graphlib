package es.um.dis.graphlib.algorithms.subtree;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class SubtreeInputTest {

	@Test
	public void test() {
		Configuration configuration = new ConfigurationBuilder().ignoreProperty("graph").build();
		new BeanTester().testBean(SubtreeInput.class, configuration);
	}

}
