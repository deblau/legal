/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

/**
 * A basic {@link Reporter}, with major / minor numbers that refer to collections of reports and individual reports,
 * respectively.
 */
public interface BasicReporter extends Reporter
{
	/**
	 * Citeable units of publication size.
	 */
	enum PubUnit
	{
		VOLUME, PAGE, TITLE, CHAPTER, SUBCHAPTER, PART, SUBPART, SECTION, SUBSECTION,
	}

	/**
	 * @return the {@link PubUnit} of collected {@link Content}s
	 */
	PubUnit getMajorPubUnit();

	/**
	 * @return the {@link PubUnit} used to cite individual {@link Content}
	 */
	PubUnit getMinorPubUnit();
}
