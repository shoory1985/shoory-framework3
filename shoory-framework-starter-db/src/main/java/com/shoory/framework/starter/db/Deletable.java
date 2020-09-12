package com.shoory.framework.starter.db;


public interface Deletable {
	public void setDeletedTime(long deletedTime);
	public long getDeletedTime();
}
