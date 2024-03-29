package com.shoory.framework.starter.oss.minio;

import com.shoory.framework.starter.oss.OssComponent;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioComponent implements OssComponent {
	@Value("${oss.minio.bucket.name}")
	public String bucketName;

	@Autowired
	private MinioClient client;

	public String getExtFileName(String mimeType) {
		switch (mimeType.toLowerCase()) {
		case "text/plain":
			return ".txt";
		case "image/jpeg":
		case "image/jpg":
			return ".jpg";
		case "image/png":
			return ".png";
		case "image/gif":
			return ".gif";
		}
		return "";
	}

	public String upload(String path, String mimeType, InputStream is) {
		try {
			client.putObject(this.bucketName, path, is, mimeType);
			return path;
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException
				| NoResponseException | ErrorResponseException | InternalException | InvalidArgumentException
				| IOException | XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public InputStream download(String resourcePath) {
		try {
			return client.getObject(this.bucketName, resourcePath);
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException
				| NoResponseException | ErrorResponseException | InternalException | InvalidArgumentException
				| IOException | XmlPullParserException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}

	public void delete(String resourcePath) {
		// 指定要删除的 bucket 和对象键
		try {
			client.removeObject(this.bucketName, resourcePath);
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException
				| NoResponseException | ErrorResponseException | InternalException | IOException
				| XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isExisted(String resourcePath) {
		// TODO Auto-generated method stub
		try {
			return client.getObject(this.bucketName, resourcePath) != null;
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException
				| NoResponseException | ErrorResponseException | InternalException | InvalidArgumentException
				| IOException | XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
