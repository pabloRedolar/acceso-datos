package org.iesch.ad.appConsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppConsumeApplication implements CommandLineRunner {

	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AppConsumeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String resultado = getDataFromApi();
		System.out.println(resultado);
	}

	public String getDataFromApi() {
		String url = "http://localhost:8080/api/saluda";
		return restTemplate.getForObject(url, String.class);
	}
}
