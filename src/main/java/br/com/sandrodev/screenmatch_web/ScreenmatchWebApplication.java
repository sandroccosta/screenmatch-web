package br.com.sandrodev.screenmatch_web;

import br.com.sandrodev.screenmatch_web.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Principal principal = new Principal();
		principal.exibirMenu();




	}
}
