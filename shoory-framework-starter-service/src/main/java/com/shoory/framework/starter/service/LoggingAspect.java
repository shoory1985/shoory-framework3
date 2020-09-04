package com.shoory.framework.starter.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.FieldSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.shoory.framework.starter.api.BizException;
import com.shoory.framework.starter.api.annotation.Logging;
import com.shoory.framework.starter.api.annotation.RequirePermission;
import com.shoory.framework.starter.api.request.AuthorizedRequest;
import com.shoory.framework.starter.api.response.AuthorizedResponse;
import com.shoory.framework.starter.api.response.BaseResponse;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * 环绕通知
	 * 
	 * @param joinPoint
	 * @return 返回被切入的方法的返回值
	 * @throws Throwable
	 */
	@Around("@annotation(logging)")
	public Object doAround(ProceedingJoinPoint joinPoint, Logging logging) throws Throwable {

		Object retVal = joinPoint.proceed();// 这个方法会执行被切入的运行时方法，然后获取返回值，所以不会运行两次

		return retVal;
	}
}
