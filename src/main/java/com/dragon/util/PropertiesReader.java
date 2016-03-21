package com.dragon.util;

//
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesReader {

	private static final String PROP_CONFIG_XML = "constantConfig.xml";
	public static boolean INIT_FLAG = false;

	private static PropertyConfigurer configuer;

	public void setConfiguer(PropertyConfigurer configuer) {
		PropertiesReader.configuer = configuer;
		mapConf = configuer.getConfigs();
	}

	public static PropertyConfigurer getConfiguer() {
		return configuer;
	}

	// Store all configuration value
	private static Map<ConfigEnum, String> mapConf = new HashMap<ConfigEnum, String>(
			ConfigEnum.values().length);
	public static Map<String, String> data = new HashMap<String, String>();

	public PropertiesReader() {
		// INIT_FLAG = true;
	}

	public static void init() {
		try {
			@SuppressWarnings("resource")
			BeanFactory factory = new ClassPathXmlApplicationContext(
					PROP_CONFIG_XML);
			PropertyConfigurer configuer = (PropertyConfigurer) factory
					.getBean("corePropertyConfigurerBean");
			mapConf = configuer.getConfigs();
		} catch (Exception ex) {
			System.err.println("Can not read configuation propeties file["
					+ PROP_CONFIG_XML + "]. Message: " + ex.getMessage());
		}
	}

	/**
	 * Return configuration value of specific item.
	 * 
	 * @param configName
	 *            item to get value
	 * @return String value of setting item
	 */
	public static String getValue(ConfigEnum configName) {
		String obj = mapConf.get(configName);
		String result = null;
		if (obj != null) {
			result = obj.trim();
		}
		return result;
	}

	/**
	 * Return configuration value of specific item.
	 * 
	 * @param configName
	 *            item to get value
	 * @return String value of setting item
	 */
	public static int getValueInt(ConfigEnum configName) {
		String stsVal = mapConf.get(configName);
		return Integer.parseInt(stsVal);
	}

	// public static Float getValueFloat(ConfigEnum configName) {
	// String stsVal = mapConf.get(configName);
	// return Float.parseFloat(stsVal);
	// }

	@SuppressWarnings("unchecked")
	public static String getMessage(String key) {
		String string = "";
		Properties prop = new Properties();
		try {
			prop.load(PropertiesReader.class
					.getResourceAsStream(("/application_fr.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			data.put(name, prop.getProperty(name));
		}

		if (data.containsKey(key)) {
			string = data.get(key);
		}
		return string;
	}

}
