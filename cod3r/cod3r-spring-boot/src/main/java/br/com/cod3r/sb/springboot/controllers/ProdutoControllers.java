package br.com.cod3r.sb.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.sb.springboot.model.entities.Produto;
import br.com.cod3r.sb.springboot.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControllers {
	
	@Autowired
	private ProdutoRepository repository;

//	@PostMapping
//	public @ResponseBody Produto novoProduto(
//			@RequestParam String nome,
//			@RequestParam Double preco,
//			@RequestParam Double desconto) {
//		Produto produto = new Produto(nome, preco, desconto);
//		repository.save(produto);
//		return produto;
//	}
	
	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		repository.save(produto);
		return produto;
	}

}
