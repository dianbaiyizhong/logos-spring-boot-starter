package com.github.nntk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LogosApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogosApplication.class, args);

//        while (true) {
//            log.info("_____");
//            log.warn("_____");
//            log.error("_____");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
