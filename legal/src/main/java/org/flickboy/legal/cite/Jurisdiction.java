/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import java.util.Set;

/**
 * A factory for producing {@link BasicReporter}s according to a {@link CitationFormat} that varies between jurisdictions.
 */
public interface Jurisdiction
{
	/**
	 * @return the installed {@link Jurisdiction}s
	 */
	static Set<Jurisdiction> getJurisdictions()
	{
		// TODO
		return null;
	}

	/**
	 * @return all {@link BasicReporter}s for this jurisdiction
	 */
	Set<BasicReporter> getAllReporters();

	/**
	 * @param branch
	 *            a {@link BasicReporter.BranchOfGov branch of government}
	 * @return the {@link BasicReporter}s for this branch of government in this jurisdiction
	 */
	Set<BasicReporter> getReporters(BasicReporter.BranchOfGov branch);

	/**
	 * @param basicReporter
	 *            a {@link BasicReporter} for a particular branch of government
	 * @return a complete set of {@link BasicReporter}s for the branch of government
	 */
	Set<BasicReporter> getParallelReporters(BasicReporter basicReporter);

	/**
	 * @param authority
	 *            an {@link Authority}
	 * @return the {@link BasicReporter}s for that authority
	 */
	Set<BasicReporter> getReportersbyAuthority(Authority authority);

	/**
	 * @param cite
	 *            a {@link Citation}
	 * @return the {@link BasicReporter} for that citation
	 */
	BasicReporter getReporterByCite(Citation cite);
}
