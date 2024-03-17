package com.tribe.task;

import com.tribe.task.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfig.class})
public class TestTaskTribeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskTribeApplication.class, args);
    }
}
