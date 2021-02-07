package us.hyalen.initial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import us.hyalen.initial.entity.Joke;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class InitialApplication {
	private static final Logger log = LoggerFactory.getLogger(InitialApplication.class);

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			var joke = restTemplate.getForObject(
//					"https://official-joke-api.appspot.com/random_joke", Joke.class);
//
//			log.info(joke.toString());
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(InitialApplication.class, args);
	}

}
