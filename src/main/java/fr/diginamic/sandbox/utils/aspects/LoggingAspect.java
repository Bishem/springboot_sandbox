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

	@Before("execution(* *(..))")
	public void logBeforeMethodExecution(final JoinPoint joinPoint) {
		final var surrentMethod = joinPoint.getSignature().getName();
		final var currentClass = joinPoint.getClass().getSimpleName();
		log.info("i was in {0} method in {1} class", surrentMethod, currentClass);
	}

//	@Around("(public *(..))")
//	public void checkPerformance() {
//
//		final Object executionTime = null;
//		log.debug("i took {} to finish", executionTime);
//	}
}
