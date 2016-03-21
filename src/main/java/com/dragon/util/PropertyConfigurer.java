package com.dragon.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	private Map<ConfigEnum, String> mapConf;
	private Map<String, String> resolvedProps;
	private static final Logger LOG = LoggerFactory
			.getLogger(PropertyConfigurer.class);

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		mapConf = new HashMap<ConfigEnum, String>(ConfigEnum.values().length);
		for (ConfigEnum en : ConfigEnum.values()) {
			String value = null;
			try {
				if (props.containsKey(en.toString())) {
					value = parseStringValue(props.getProperty(en.toString()),
							props, new HashSet());
				} else {
					value = en.getDef();
				}
			} catch (MissingResourceException mre) {
				value = en.getDef();
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			mapConf.put(en, value);
		}
		// get all props
		resolvedProps = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			resolvedProps.put(
					keyStr,
					parseStringValue(props.getProperty(keyStr), props,
							new HashSet()));
		}
	}

	public String getString(String key) {
		return resolvedProps.get(key);
	}

	public Map<ConfigEnum, String> getConfigs() {
		return mapConf;
	}
	
	
}
