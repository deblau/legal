package org.flickboy.legal.cite;

public class NumberedCollectionInfo extends SearchInfo
{
	private final int collNum;
	private final int reportNum;

	public NumberedCollectionInfo(int collNum, int reportNum)
	{
		this.collNum = collNum;
		this.reportNum = reportNum;
	}

	public int getCollectionNum()
	{
		return collNum;
	}

	public int getReportNum()
	{
		return reportNum;
	}
}
