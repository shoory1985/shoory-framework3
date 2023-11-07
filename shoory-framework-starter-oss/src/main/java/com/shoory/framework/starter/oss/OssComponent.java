package com.shoory.framework.starter.oss;

import java.io.InputStream;

public interface OssComponent {
	String upload(String resourcePath, String mimeType, InputStream is);
	InputStream download(String resourcePath);
	void delete(String resourcePath);
	boolean isExisted(String resourcePath);
}
