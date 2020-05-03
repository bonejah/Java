package br.com.devdojo.javacore.io.teste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamsTest {

	public static void main(String[] args) {
		gravador();
		gravadorTunado();
		leitor();
		leitorTunado();
	}

	private static void gravador() {
		byte[] dados = { 65, 66, 67, 68, 69, 70 };
		try (FileOutputStream gravador = new FileOutputStream("folder/stream.txt")) {
			gravador.write(dados);
			gravador.flush();
			System.out.println("Dados gravados com sucesso");
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

	private static void gravadorTunado() {
		byte[] dados = { 65, 66, 67, 68, 69, 70 };
		try (BufferedOutputStream gravadorBuffer = new BufferedOutputStream(
				new FileOutputStream("folder/stream_tunado.txt"))) {
			gravadorBuffer.write(dados);
			gravadorBuffer.flush();
			System.out.println("Dados gravados com sucesso");
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

	private static void leitor() {
		try (FileInputStream leitor = new FileInputStream("folder/stream.txt")) {
			int leitura;
			while ((leitura = leitor.read()) != -1) {
				byte b = (byte) leitura;
				System.out.println(" " + b);
			}
			System.out.println("Dados lidos com sucesso");
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

	private static void leitorTunado() {
		try (BufferedInputStream leitorTunado = new BufferedInputStream(
				new FileInputStream("folder/stream_tunado.txt"))) {
			int leitura;
			while ((leitura = leitorTunado.read()) != -1) {
				byte b = (byte) leitura;
				System.out.println(" " + b);
			}
			System.out.println("Dados lidos com sucesso");
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

}
