/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import java.io.File;
import java.util.Properties;

import org.flickboy.legal.Config;
import org.flickboy.legal.Configured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A factory for producing {@link Reporter}s.
 */
public final class Jurisdiction implements Configured
{
	// Data
	private static final Logger			logger	= LoggerFactory.getLogger(Jurisdiction.class);
	private static final Jurisdiction	world	= new Jurisdiction();
	private final Jurisdiction			parent;
	private final String				path;
	private final String				shortName;
	private final String				longName;
	private final Properties			children;
	private final Properties			reporters;

	/**
	 * @return
	 * @see java.util.Hashtable#toString()
	 */
	@Override public String toString()
	{
		return longName;
	}

	/**
	 * @return the worldwide {@link Jurisdiction}
	 */
	public static Jurisdiction getWorld()
	{
		return world;
	}

	/**
	 * @return the parent {@link Jurisdiction}
	 */
	public Jurisdiction getParent()
	{
		return parent;
	}

	/**
	 * @return the short name
	 */
	public String getShortName()
	{
		return shortName;
	}

	/**
	 * @return the long name
	 */
	public String getLongName()
	{
		return longName;
	}

	/**
	 * @return the children {@link Jurisdiction}s
	 */
	public Properties getChildren()
	{
		return children;
	}

	/**
	 * @param child
	 *            a child {@link Jurisdiction}
	 * @return whether {@link Reporter}s have been installed for that child
	 */
	public boolean isChildInstalled(String child)
	{
		String pfx = "src/main/resources/";
		String sfx = path + "/" + child + "/" + child + ".properties";
		String file1 = pfx + "jx" + sfx;
		String file2 = pfx + "rpt" + sfx;
		return new File(file1).isFile() && new File(file2).isFile();
	}

	/**
	 * @param child
	 *            a key for a child {@link Jurisdiction}
	 * @return the child {@link Jurisdiction}
	 */
	public Jurisdiction getChild(String child)
	{
		// Check for valid child key
		if (!children.containsKey(child))
		{
			logger.warn("Jurisdiction {} has no child {}", path, child);
			return null;
		}

		// Check for valid install
		if (!isChildInstalled(child))
		{
			logger.warn("Jurisdiction {} is not installed", path + "/" + child);
			return null;
		}

		// We're good
		return new Jurisdiction(this, child);
	}

	/**
	 * @return the {@link Reporter}s for this {@link Jurisdiction}
	 */
	public Properties getReporters()
	{
		return reporters;
	}

	private Jurisdiction()
	{
		parent = null;
		path = "";
		shortName = "World";
		longName = "The World";
		children = Config.load("jx/World");
		reporters = Config.load("rpt/World");
	}

	private Jurisdiction(Jurisdiction parent, String path)
	{
		this.parent = parent;
		this.path = parent.path + "/" + path;
		this.shortName = path;
		this.longName = parent.children.getProperty(path);
		this.children = Config.load("jx" + this.path + "/" + path);
		this.reporters = Config.load("rpt" + this.path + "/" + path);
	}

	public static void main(String[] args)
	{
		Jurisdiction world = Jurisdiction.getWorld();
		Jurisdiction usa = world.getChild("USA");
		System.out.println(usa.getReporters());
	}
}
