package com.flexionmobile.codingchallenge.funflowers;

import com.flexionmobile.codingchallenge.integration.Purchase;

public class Bill implements Purchase
{
	private String id;
	private String itemId;
	private boolean consumed;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getItemId()
	{
		return itemId;
	}
	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}
	public boolean getConsumed()
	{
		return consumed;
	}
	public void setConsumed(boolean consumed)
	{
		this.consumed = consumed;
	}
	

}
