package com.example.controle;

import com.example.controle.repository.Livrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleApplication {

	public ControleApplication(Livrepo livrepo) {
		this.livrepo = livrepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);


	}
	 @Autowired
	private Livrepo livrepo;

}
