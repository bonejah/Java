package br.com.cod3r.sb.springboot.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cod3r.sb.springboot.model.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
