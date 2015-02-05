package com.tutorial.application;

import com.codahale.metrics.*;
import org.springframework.stereotype.Component;

/**
 * Created on 04/02/15
 *
 * @author Ming Li
 */
@Component
public class PerformanceMonitor {

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
}
