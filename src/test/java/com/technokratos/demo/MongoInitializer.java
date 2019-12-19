package com.technokratos.demo;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

public class MongoInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String MONGO_CONTAINER = "mongo";
    private static final Integer MONGO_PORT = 27017;
    private static final String BIND_IP = "--bind_ip_all";
    private final GenericContainer mongo = new GenericContainer(MONGO_CONTAINER)
        .waitingFor(Wait.defaultWaitStrategy())
        .withExposedPorts(MONGO_PORT)
        .withCommand(BIND_IP);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        mongo.start();

        TestPropertyValues.of(String.format(
            "spring.data.mongodb.host=%s:%d", mongo.getContainerIpAddress(), mongo.getMappedPort(MONGO_PORT)),
            "spring.data.mongodb.database=test")
            .applyTo(applicationContext.getEnvironment());
    }
}
