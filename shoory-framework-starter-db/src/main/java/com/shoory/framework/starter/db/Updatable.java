package com.shoory.framework.starter.db;


public interface Updatable {
	void setVersion(long version);
	long getVersion();
	
	void setUpdatedTime(long updatedTime);
	long getUpdatedTime();
}
