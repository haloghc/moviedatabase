package eu.ibacz.moviedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class MoviedatabaseApplication {

	public static void main(String[] args) {
		ReactorDebugAgent.init();
		SpringApplication.run(MoviedatabaseApplication.class, args);
	}

}
