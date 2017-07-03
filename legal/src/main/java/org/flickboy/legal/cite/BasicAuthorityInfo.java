/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import org.flickboy.legal.cite.Reporter.Content;

/**
 * Information needed to build a {@link BasicReporter}.
 */
class BasicAuthorityInfo extends AuthorityInfo<Integer[]>
{
	public BasicAuthorityInfo(Content content, Integer[] data)
	{
		super(content, data);
	}
}
