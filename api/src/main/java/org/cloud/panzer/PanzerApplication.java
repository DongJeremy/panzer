package org.cloud.panzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PanzerApplication {

    private static Logger logger = LoggerFactory.getLogger(PanzerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PanzerApplication.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }

}
