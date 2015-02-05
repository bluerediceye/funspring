package com.tutorial.application;

import com.codahale.metrics.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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


    private static MetricRegistry metrics = new MetricRegistry();

    private Counter counter = metrics.counter("counters");

    private Meter meter = metrics.meter("requests");

    private Timer timer = metrics.timer("timer");

    static {
        metrics.register("guages", new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return 8;
            }
        });

        final JmxReporter reporter = JmxReporter
                .forRegistry(metrics)
                .inDomain("tutorial")
                .build();
        reporter.start();
    }


    @Autowired
    private PerformanceMonitor monitor;

    @Pointcut("@target(com.tutorial.application.Auditable)")
    public void auditable() {
    }

    @Around("auditable()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        counter.inc();
        meter.mark();
        Timer.Context context = timer.time();

        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch

        context.stop();
        return retVal;
    }
}
