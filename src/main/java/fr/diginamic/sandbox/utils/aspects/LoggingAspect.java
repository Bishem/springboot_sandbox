package fr.diginamic.sandbox.utils.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* fr.diginamic.sandbox..*.*(..))")
	public void logBeforeMethodExecution(final JoinPoint joinPoint) {
		final var signature = joinPoint.getSignature();
		final var method = signature.getName();
		final var clazz = signature.getDeclaringTypeName();
		log.info("i was in {} method in {} class", method, clazz);
	}
}
