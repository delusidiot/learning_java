package com.example.springtutorial;

import com.example.springtutorial.trace.logtrace.LogTrace;
import com.example.springtutorial.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author       : delusidiot
 * date         : 2022-07-11
 */

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
