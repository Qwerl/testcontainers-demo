package com.technokratos.demo.job;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "scheduling.enabled", havingValue = "true")
public class ConsoleSpammer {

    @Scheduled(fixedDelay = 1000)
    void spam() {
        System.out.println("ZDAROVA");
    }

}
