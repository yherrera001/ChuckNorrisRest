package com.FirstJawnByMyself.anotherdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
public class AnotherdemoApplication {
	private static final Logger log = LoggerFactory.getLogger(AnotherdemoApplication.class);

	@Resource
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AnotherdemoApplication.class, args);
	}

	@Scheduled(fixedDelay = 5000)
	public void getJokes(){
//		RestTemplate restTemplate = new RestTemplateBuilder()
//				.defaultHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
//				.build();
		log.info(restTemplate+""); //
		Joke quote = getJokeFromApi(restTemplate);
		log.info(quote.toString());
	}



	//fetching
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.defaultHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
				.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Joke quote = getJokeFromApi(restTemplate);
			log.info(quote.toString());
		};
	}

	private Joke getJokeFromApi(RestTemplate restTemplate) {
		return restTemplate.getForObject(
				"https://api.chucknorris.io/jokes/random", Joke.class);
	}
}
