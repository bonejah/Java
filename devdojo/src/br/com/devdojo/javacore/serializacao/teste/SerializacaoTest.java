package br.com.devdojo.javacore.serializacao.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.devdojo.javacore.serializacao.classes.Aluno;
import br.com.devdojo.javacore.serializacao.classes.Turma;

public class SerializacaoTest {

	public static void main(String[] args) {
		gravadorObjeto();
		leitorObjeto();
	}

	private static void gravadorObjeto() {
		Aluno aluno = new Aluno(1L, "Bruno Lima", "123456");
		Turma turma = new Turma("Java");
		aluno.setTurma(turma);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.serializado"))) {
			oos.writeObject(aluno);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void leitorObjeto() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.serializado"))) {
			Aluno aluno = (Aluno) ois.readObject();
			System.out.println(aluno);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
