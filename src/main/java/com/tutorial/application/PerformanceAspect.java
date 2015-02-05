package com.tutorial.application;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 04/02/15
 *
 * @author Ming Li
 */

@Aspect
@Component
public class PerformanceAspect {

    @Autowired
    private PerformanceMonitor monitor;

    @Around(value = "@annotation(auditable)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp, Auditable auditable) throws Throwable {

        Object context = monitor.time(auditable.value());
        try {
            return pjp.proceed();
        } finally {
            monitor.stop(context);
        }
    }
}