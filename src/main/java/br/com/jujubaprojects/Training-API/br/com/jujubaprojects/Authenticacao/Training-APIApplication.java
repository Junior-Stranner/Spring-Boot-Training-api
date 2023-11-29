package br.com.jujubaprojects.Authenticacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AuthenticacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticacaoApplication.class, args);
	}

	@RestController
	class httpController{
		@GetMapping("/public")
		String publicRoute(){
			return "<h1>Public route, feel to look around ! :lock </h1>";
		}

		@GetMapping("/private")
		String privateRoute(){
			return "<h1>Private route , only authorize personal ! close-lock </h1>";
		}
	}

}
