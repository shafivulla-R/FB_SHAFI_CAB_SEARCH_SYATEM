package org.codejudge.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan({ "org.codejudge.sb" })
// @Slf4j
public class CabSearchSystemApplication {

	private static final Logger log = LoggerFactory.getLogger(CabSearchSystemApplication.class);

	public static void main(String[] args) {
		log.info("Starting Application...!!");
		SpringApplication.run(CabSearchSystemApplication.class, args);
		log.info("Ended Application...");
	}

}
