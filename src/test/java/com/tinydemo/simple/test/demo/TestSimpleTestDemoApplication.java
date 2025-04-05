package com.tinydemo.simple.test.demo;

import org.springframework.boot.SpringApplication;

public class TestSimpleTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(SimpleTestDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
