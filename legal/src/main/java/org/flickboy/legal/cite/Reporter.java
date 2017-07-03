/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import java.util.Set;

/**
 * A representation of an official, legal publication.
 */
public interface Reporter
{
	/**
	 * Branches of government to which this publication may refer.
	 */
	enum BranchOfGov
	{
		LEGISLATIVE, EXECUTIVE, JUDICIAL
	}

	/**
	 * Types of reported content.
	 */
	enum Content
	{
		/**
		 * Official work product of a deliberative body (e.g. a bill or ordinance).
		 */
		ACT,

		/**
		 * An extract of another legal document.
		 */
		EXTRACT,

		/**
		 * An issue of a regular, official publication.
		 */
		GAZETTE,

		/**
		 * A judicial opinion or precedent.
		 */
		JUDGMENT,

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
	 * @param <T>
	 *            data required to be provided when creating an {@link Authority}
	 * @param <U>
	 *            an implementation of {@link AuthorityInfo} that stores these data
	 * @param AuthorityInfo
	 *            information needed to build an {@link Authority} for this {@link Reporter}
	 * @return the new {@link Authority}
	 */
	<T, U extends AuthorityInfo<T>> Authority buildAuthority(U info);
}
