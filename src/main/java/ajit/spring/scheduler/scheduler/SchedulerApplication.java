package ajit.spring.scheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SchedulerApplication {
	private static final Logger log = LoggerFactory.getLogger(SchedulerApplication.class);

	public static void main(String[] args) {
		log.info("-------------------------Starting application -------------------------");
		SpringApplication.run(SchedulerApplication.class, args);
	}

}
