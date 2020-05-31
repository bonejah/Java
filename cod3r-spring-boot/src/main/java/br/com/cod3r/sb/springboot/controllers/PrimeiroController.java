package br.com.cod3r.sb.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = { "/ola", "/ola2" })
	public String ola() {
		return "Ola Spring Boot";
	}

	@PostMapping(path = { "/saudacao" })
	public String saudacao() {
		return "Seja bem-vindo!";
	}

}
