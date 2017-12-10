package com.amall.core.bean;

public class WapAdvertPositionWithBLOBs extends WapAdvertPosition
{

	private static final long serialVersionUID = -6568158630971597128L;

	private String apCode;

	private String apContent;

	public String getApCode ( )
		{
			return apCode;
		}

	public void setApCode (String apCode)
		{
			this.apCode = apCode == null ? null : apCode.trim ();
		}

	public String getApContent ( )
		{
			return apContent;
		}

	public void setApContent (String apContent)
		{
			this.apContent = apContent == null ? null : apContent.trim ();
		}
}