/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Config extends Properties
{
	private static final long				serialVersionUID	= -3995805005796450271L;

	// Data
	private static Logger					logger				= LoggerFactory.getLogger(Config.class);
	private static Map<String, Properties>	propsCache			= new HashMap<>();

	// Singleton pattern
	private Config()
	{}

	/**
	 * @param path
	 *            the path to a configuration file (minus the trailing "properties")
	 * @return a {@link Properties} object populated from the file
	 */
	public static final Properties load(String path)
	{
		// First check the cache
		if (propsCache.containsKey(path))
			return propsCache.get(path);

		// Nope, populate from the file
		Properties props = new Properties();
		File file = new File("src/main/resources/" + path + ".properties");
		try
		{
			// Load the default properties
			FileInputStream fis = new FileInputStream(file);
			props.load(fis);
			fis.close();
		}
		catch (FileNotFoundException e)
		{
			logger.warn("Configuration file {} not found", path);
			return null;
		}
		catch (IOException e)
		{
			logger.error("Fatal: cannot load properties from file {}", path);
			e.printStackTrace();
			System.exit(1);
		}
		propsCache.put(path, props);
		return props;
	}
}