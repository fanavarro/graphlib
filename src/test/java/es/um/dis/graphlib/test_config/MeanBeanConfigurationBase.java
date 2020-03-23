package es.um.dis.graphlib.test_config;

import org.meanbean.test.ConfigurationBuilder;

/**
 * The Class MeanBeanConfigurationBase.
 */
public class MeanBeanConfigurationBase {

	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 */
	public static final ConfigurationBuilder getConfigurationBuilderBase() {
		return new ConfigurationBuilder().overrideFactory("graph", new GraphTestFactory());
	}

}
