package com.technokratos.demo;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.OutputFrame;

import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class GenericContainerTest {

    private static GenericContainer container = new GenericContainer("pepega")
        .withLogConsumer(getConsumer());

    @NotNull
    private static Consumer<OutputFrame> getConsumer() {
        return outputFrame -> System.out.println(outputFrame.getUtf8String());
    }

    @BeforeAll
    public static void setup() {
        container.start();
    }

    @Test
    public void waittt() throws InterruptedException {
        sleep(50000);
    }

}
