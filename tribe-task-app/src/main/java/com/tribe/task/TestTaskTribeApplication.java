package com.tribe.task;

import com.tribe.task.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SwaggerConfig.class})
public class TestTaskTribeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskTribeApplication.class, args);
    }

}
