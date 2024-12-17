package sg.edu.ntu.bus_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(BusApiApplication.class);
	public static void main(String[] args) {
		logger.info("🟡🟡🟡 Starting BusApiApplication");
		SpringApplication.run(BusApiApplication.class, args);
	}

}
