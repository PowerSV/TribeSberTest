package com.tribe.task.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.MeterBinder;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebConfig {
    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Факториал микросервис")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("Ballo Alexey")
                                .email("ballo.aleksej@gmail.com")));
    }

    @Bean
    MeterBinder meterBinder() {
        return meterRegistry -> {
            Counter
                    .builder("factorial_count")
                    .description("Количество обращений")
                    .register(meterRegistry);

            Timer
                    .builder("factorial_timer")
                    .publishPercentiles(0.60, 0.95, 0.99)
                    .publishPercentileHistogram()
                    .minimumExpectedValue(Duration.ofNanos(500))
                    .maximumExpectedValue(Duration.ofMillis(500))
                    .register(meterRegistry);
        };
    }
}
