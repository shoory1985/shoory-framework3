package com.shoory.framework.starter.db;


public interface Updatable {
	public void setVersion(long version);
	public long getVersion();
	
	public void setUpdatedTime(long updatedTime);
	public long getUpdatedTime();
}
