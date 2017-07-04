/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import java.util.Set;

import org.flickboy.legal.cite.Reporter.BranchOfGov;
import org.flickboy.legal.cite.Reporter.Content;

/**
 * A legal authority, such as a law, regulation, or judicial opinion.
 */
public interface Authority
{
	/**
	 * @return the {@link Jurisdiction} that provided this {@link Authority}
	 */
	default Jurisdiction getJurisdiction()
	{
		return getReporters().iterator().next().getJurisdiction();
	}

	/**
	 * @return the {@link BranchOfGov} responsible for providing this {@link Authority}
	 */
	default BasicReporter.BranchOfGov getBranchOfGov()
	{
		return getReporters().iterator().next().getBranchOfGov();
	}

	/**
	 * @return the {@link Content} type of this {@link Authority}
	 */
	Content getContent();

	/**
	 * @return all parallel {@link Reporter}s that have reported this {@link Authority}
	 */
	Set<BasicReporter> getReporters();

	/**
	 * @return a {@link Citation} for this {@link Authority}
	 */
	Citation getCite();
}
