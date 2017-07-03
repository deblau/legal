/**
 * @author David E. Blau, Esq.
 */
package org.flickboy.legal.cite;

import org.flickboy.legal.cite.Reporter.Content;

/**
 * Information needed to build an {@link Authority}. Individual {@link BasicReporter} implementations should subclass.
 */
class AuthorityInfo<T>
{
	// Data
	private final Content	content;
	protected final T		data;

	public AuthorityInfo(Content content, T data)
	{
		this.content = content;
		this.data = data;
	}

	/**
	 * @return the {@link Content} type of this {@link Authority}
	 */
	public final Content getContent()
	{
		return content;
	}

	/**
	 * @return {@link BasicReporter}-specific data
	 */
	public final T getData()
	{
		return data;
	}
}
