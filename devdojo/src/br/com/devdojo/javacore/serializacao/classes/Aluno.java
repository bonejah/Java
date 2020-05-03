package br.com.devdojo.javacore.serializacao.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aluno implements Serializable {
	private static final long serialVersionUID = 5773561339674708445L;
	private Long id;
	private String nome;
	private transient String password;
	private static String nomeEscola = "devdojo";
	private transient Turma turma;

	public Aluno(Long id, String nome, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.password = password;
	}
	
	private void writeObject(ObjectOutputStream oos) {
		try {
			oos.defaultWriteObject();
			oos.writeUTF(turma.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream ois) {
		try {
			ois.defaultReadObject();
			turma = new Turma(ois.readUTF());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", password=" + password + ", nomeEscola=" + nomeEscola
				+ ", turma=" + turma + "]";
	}

}
