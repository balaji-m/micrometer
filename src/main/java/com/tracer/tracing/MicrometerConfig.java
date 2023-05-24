package com.tracer.tracing;


import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {

    @Bean
    public LoggingMeterRegistry loggingRegistry() {
//        LoggingRegistryFactory loggingRegistryFactory = LoggingMeterRegistryFactory
//                .from(LoggingSystem.STANDARD);
//
//        // Customize the logging format here
//        LoggingRegistry loggingRegistry = loggingRegistryFactory.create("json");
//        loggingRegistry.start();
        LoggingMeterRegistry loggingRegistry = new LoggingMeterRegistry();
        return loggingRegistry;
    }
}
