package br.com.bonejah.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.bonejah.modelo.Memoria;
import br.com.bonejah.modelo.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador {

	private static final long serialVersionUID = -6484953081943057990L;

	private final JLabel label;
	
	public Display() {
		Memoria.getInstancia().adicionarObservador(this);
		
		setBackground(new Color(46, 49, 50));
		this.label = new JLabel(Memoria.getInstancia().getTextoAtual());
		this.label.setForeground(Color.WHITE);
		this.label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		this.label.setText(novoValor); 
	}
	
}
