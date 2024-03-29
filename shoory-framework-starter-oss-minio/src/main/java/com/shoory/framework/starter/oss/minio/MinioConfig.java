package com.shoory.framework.starter.oss.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
	@Value("${oss.minio.bucket.accessKey}")
	public String accessKey;
	@Value("${oss.minio.bucket.secretKey}")
	public String secretKey;
	@Value("${oss.minio.bucket.region}")
	public String region;
	@Value("${oss.minio.bucket.port}")
	public int port;
	@Value("${oss.minio.bucket.secure:false}")
	public boolean secure;
	

	@Bean
	MinioClient getMinioClient() {
		try {
			return new MinioClient(this.region, this.port, this.accessKey, this.secretKey, this.secure);
		} catch (InvalidEndpointException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
