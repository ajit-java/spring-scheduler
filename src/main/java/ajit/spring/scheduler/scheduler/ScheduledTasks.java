package ajit.spring.scheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.val;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(cron = "0 0 * * * MON-FRI")
	//@Scheduled(fixedRate = 5000)
	public void hourlyBackup() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		String command = "./backup.sh true";


		log.info(command);

		String output = executeCommand(command);
		log.info("Output: " + output);
	}

    @Scheduled(fixedDelay = 1)
    @Async
    public void run2() throws Exception {
        val longRunningTaskTime = new Random().nextInt(2, 6);
		log.info("Task {} {}", longRunningTaskTime, dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(longRunningTaskTime);
    }

	@Scheduled(cron = "0 0 10 * * SAT")
	public void weeklyFullBackup() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		String command = "lss -l /";
		String output = executeCommand(command);
		log.info("Output: " + output);
	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			log.error(e.toString());//report to victor ops
			return e.getMessage();
		}

		return output.toString();

	}

}
