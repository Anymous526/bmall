package com.amall.core.bean;

import java.io.Serializable;

public class RefundItem implements Serializable
{

	private static final long serialVersionUID = 1514632411184137237L;

	private Long id;

	private String name;


	public Long getId ( )
		{
			return id;
		}


	public void setId (	Long id)
		{
			this.id = id;
		}


	public String getName ( )
		{
			return name;
		}


	public void setName (	String name)
		{
			this.name = name == null ? null : name.trim ();
		}
}