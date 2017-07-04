
/**
 * @author David E. Blau, Esq.
 */

/**
 * <p>
 * Legal citations.
 * </p>
 * <p>
 * Lawyers engage in what Aristotle termed "forensic rhetoric": determination of the factual (or counterfactual) nature
 * of past events. Such arguments are highly logical in nature, and often rely on appeals to authority of various kinds,
 * such as laws, regulations, and judicial decisions. The formalism for making such reliance is by citation to a legal
 * publication, and of course citations to greater authority are the most prized.
 * </p>
 * <p>
 * Most users of the classes in this package should begin by locating an appropriate {@link legalutils.cite.Jurisdiction
 * Jursidiction}, then retrieve one or more {@link legalutils.cite.BasicReporter Reporter}s of an appropriate type. Each
 * <code>Reporter</code> defines a particular {@link legalutils.cite.CitationFormat CitationFormat}.
 * <code>Reporter</code>s provide {@link legalutils.cite.Authority Authority} instances, each of which represents a
 * complete legal authority (e.g. a law or a judicial opinion), and which may be configured to provide pinpoint
 * {@link legalutils.cite.Citation Citation}s in either full or shortened forms.
 * </p>
 */
package org.flickboy.legal.cite;
