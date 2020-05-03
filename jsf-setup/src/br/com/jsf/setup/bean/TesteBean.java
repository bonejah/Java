package br.com.jsf.setup.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsf.setup.dao.DAO;
import br.com.jsf.setup.model.Projeto;

@Named
@ViewScoped
public class TesteBean implements Serializable{

	@Inject
	private DAO<Projeto> dao;
	
	public void init() {
		System.out.println("TestBean - metodo init()");
		System.out.println("Criando um projeto....");
		System.out.println("Salvando um projeto....");
		Projeto projeto = new Projeto();
		projeto.setNome("PROJETO JSF");
		dao.save(projeto);
		System.out.println("Projeto salvo com sucesso!");
	}
}
