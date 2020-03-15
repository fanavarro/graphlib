package es.um.dis.graphlib.test_config;

import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class MeanBeanConfigurationBase{

	public static final Configuration getConfiguration(){
		return new ConfigurationBuilder().overrideFactory("graph", new GraphTestFactory()).build();
	}

}
