package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observador {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Observador");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(600, 200);
		janela.setLayout(new FlowLayout());
		janela.setLocationRelativeTo(null); // centraliza na tela do pc
		
		JButton botao = new JButton("Clicar!");
		janela.add(botao);
		janela.setVisible(true);
		
//		botao.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Evento: " + e.getActionCommand());
//				System.out.println("Evento: " + e.getSource());
//				System.out.println("Evento: " + e.getID());			}
//		});
		
		botao.addActionListener(e -> {
			System.out.println("Evento: " + e.getActionCommand());
		});
	}
	
}
