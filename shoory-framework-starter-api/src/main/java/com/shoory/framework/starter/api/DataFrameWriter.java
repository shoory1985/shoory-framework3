package com.shoory.framework.starter.api;

import java.io.DataOutputStream;
import java.io.IOException;

@FunctionalInterface
public interface DataFrameWriter {
	void write(DataOutputStream dos) throws IOException;
}
