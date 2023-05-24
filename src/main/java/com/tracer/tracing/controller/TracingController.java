package com.tracer.tracing.controller;

import brave.Tracer;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TracingController {

 @Autowired
 ObservationRegistry observationRegistry;

 @Autowired
 Tracer tracer;


//    public TracingController(ObservationRegistry observationRegistry, Tracer tracer) {
//        this.observationRegistry = observationRegistry;
//        this.tracer = tracer;
//    }

    @GetMapping("/test")
    public String  test() {
        log.info("inside");


        Observation.createNotStarted("pets-job", observationRegistry).observe(() -> {
            log.info("Started the job");

            log.info("Finished the job");
        });

//     Mono.deferContextual(contextView -> {
//         try(ContextSnapshot.Scope scope= ContextSnapshot.setThreadLocalsFrom(
//                 contextView,
//                 ObservationThreadLocalAccessor.KEY)) {
//             log.info("testing");
//             return Mono.just("context returning");
//         }
//     }).block();

        return "testing";
    }


}
