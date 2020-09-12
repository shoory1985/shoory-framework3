package com.shoory.framework.starter.db;


public interface Updatable {
	public void setVersion();
	public long getVersion();
	
	public void setUpdatedTime();
	public long getUpdatedTime();
}
