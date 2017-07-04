/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

/**
 *
 */
public interface Citation
{
	/**
	 * @return a long-form citation
	 */
	String longCite();

	/**
	 * @return a short-form citation
	 */
	String shortCite();
}
