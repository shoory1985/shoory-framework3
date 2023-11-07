package com.shoory.framework.starter.db;


public interface Deletable {
	void setDeletedTime(long deletedTime);
	long getDeletedTime();
}
