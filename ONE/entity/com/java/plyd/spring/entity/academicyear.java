package com.java.plyd.spring.entity;

public class academicyear 
{
	private int id;
	
	
	private int total;
	private int ofitem;
	private String invoicename;
	

	
	public academicyear()
	{
		
	}
	
	
	public academicyear(int id,int total,int ofitem,String invoicename) 
	{
		super();
		this.id=id;
		this.total=total;
		this.ofitem=ofitem;
		this.invoicename = invoicename;
		
		
	}

		
	
	public int getid()
	{
		return id;
	}
	public void setid(int id) 
	{
		this.id = id;
	}
	
	public int gettotal()
	{
		
		return total;
	}
	public void settotal(int total) 
	{
		this.total = total;
	}
	
	public int getofitem()
	{
		return ofitem;
	}
	public void setofitem(int ofitem) 
	{
		this.ofitem = ofitem;
	}
	
	public void setinvoicename(String invoicename) 
	{
		this.invoicename = invoicename;
	}
	public String getinvoicename() 
	{
		// TODO Auto-generated method stub
		return invoicename;
	}
	
	
	
	
	
}
