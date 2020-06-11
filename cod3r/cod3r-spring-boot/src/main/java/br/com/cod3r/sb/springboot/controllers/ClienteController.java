package br.com.cod3r.sb.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.sb.springboot.model.entities.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(1, "Bruno", "123.456.789.-00");
	}

	@GetMapping("/{id}")
	public Cliente obterClientePorId(@PathVariable int id) {
		return new Cliente(id, "Maria", "987.654.321-00");
	}

	@GetMapping
	public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "7") int id) {
		return new Cliente(id, "João", "987.654.321-00");
	}

}
