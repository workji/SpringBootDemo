package org.example;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    @Bean
    public Redisson redisson() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);

        return (Redisson) Redisson.create(config);
    }


}
