package com.eventum.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
		private Logger myLog=Logger.getLogger(getClass().getName());
		
		@Pointcut("execution(* com.eventum.controller.*.*(..))")
		public void forControllerPackage() {};
		
		@Pointcut("execution(* com.eventum.service.*.*(..))")
		public void forSERVICEPackage() {};
		
		
		@Pointcut("execution(* com.eventum.dao.*.*(..))")
		public void forDAOPackage() {};
		
		
		@Pointcut("forControllerPackage() || forSERVICEPackage()  || forDAOPackage()")
		public void forappflow() {};
		
		
		@Before("forappflow()")
		public void beforeAdvice(JoinPoint joinpoint) {
			myLog.info("in before ===> calling method "+joinpoint.getSignature().toString());
			
			Object[] args=joinpoint.getArgs();
			for(Object i:args) {
				myLog.info("====>> argument: "+i.toString());
			}
			
		}
		
		@AfterReturning(pointcut="forappflow()",returning = "result")
		public void afterRunningAdvice(JoinPoint joinpoint,Object result) {
			myLog.info("in after running ===> calling method "+joinpoint.getSignature().toString());
			
			
				try {
					myLog.info("====>> result: "+result.toString());
				} catch (Exception e) {
					myLog.info("in catch block , exception message: "+e.getMessage());
				}
			
		}
}
