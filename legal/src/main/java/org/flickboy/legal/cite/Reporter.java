/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import java.util.Set;

import org.flickboy.legal.Configured;

/**
 * A representation of an official, legal publication.
 */
public interface Reporter extends Configured
{
	/**
	 * Branches of government to which this publication may refer.
	 */
	enum BranchOfGov {
		LEGISLATIVE, EXECUTIVE, JUDICIAL
	}

	/**
	 * Types of reported content.
	 */
	enum Content {
		/**
		 * Official work product of a deliberative body (e.g. a bill or ordinance).
		 */
		LAW,

		/**
		 * Official work product of a regulatory body
		 */
		REGULATION,

		/**
		 * A judicial opinion or precedent.
		 */
		JUDGMENT,

		/**
		 * An extract of another legal document.
		 */
		EXTRACT,

		/**
		 * An issue of a regular, official publication.
		 */
		GAZETTE,

		/**
		 * Minutes of a deliberative body.
		 */
		MINUTES,

		/**
		 * A legal document of a parliamentary nature (e.g. bylaws).
		 */
		PARLIAMENTARY,

		/**
		 * A transcript of deliberative or judicial proceedings.
		 */
		TRANSCRIPT,

		/**
		 * An unstructured legal document (e.g. a resolution).
		 */
		UNSTRUCTURED,
	}

	/**
	 * @return the {@link Jurisdiction} that publishes this {@link Reporter}
	 */
	Jurisdiction getJurisdiction();

	/**
	 * @return the {@link BranchOfGov} to which this {@link Reporter} pertains
	 */
	BranchOfGov getBranchOfGov();

	/**
	 * @return the types of {@link Content} that may be reported herein
	 */
	Set<Content> getContentTypes();

	/**
	 * @param info
	 *            information needed to find an {@link Authority} for this {@link Reporter}
	 * @return the {@link Authority}
	 */
	Authority findAuthority(SearchInfo info);
}
