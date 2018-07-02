package com.learn.mastering.spring.zipkintracingserver.bean;

import brave.Span;
import brave.Tracer;

public class MyTracer {
    private final Tracer tracer;

    // Tracer will be autowired
    MyTracer(Tracer tracer) {
        this.tracer = tracer;
    }

    void doSth() {
        Span span = tracer.newTrace().name("encode").start();
        // ...
    }
}
