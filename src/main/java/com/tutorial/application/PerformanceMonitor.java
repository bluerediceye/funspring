package com.tutorial.application;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 04/02/15
 *
 * @author Ming Li
 */
@Component
@ManagedResource
public class PerformanceMonitor {

    @Autowired
    private MetricRegistry metrics;

    @PostConstruct
    private void startReport() {
        final JmxReporter reporter = JmxReporter
                .forRegistry(metrics)
                .inDomain("tutorial")
                .build();
        reporter.start();
    }

    public Object time(String name) {
        Timer timer = metrics.timer(name);
        return timer.time();
    }

    public Long stop(Object context) {
        Timer.Context ctx = (Timer.Context) context;
        return ctx.stop();
    }
}
