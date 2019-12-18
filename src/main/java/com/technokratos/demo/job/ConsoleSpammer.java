package com.technokratos.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConsoleSpammer {

    @Scheduled(fixedDelay = 1000)
    void spam() {
        System.out.println("ZDAROVA");
    }

}
