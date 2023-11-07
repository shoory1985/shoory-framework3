package com.shoory.framework.starter.api;

import java.io.DataInputStream;
import java.io.IOException;

@FunctionalInterface
public interface DataFrameReader {
	void read(DataInputStream dis) throws IOException;
}
