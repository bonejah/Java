package br.com.deitel.cap.twenty.seven;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadServerFile extends JFrame {
	private JTextField enterField; // JTextField para inserir o nome do site
	private JEditorPane contentArea; // para exibir o site Web

	public ReadServerFile() {
		super("Simple Web Browser");

		// Cria o enterField e registra o seu ouvinte
		enterField = new JTextField("Enter file URL here");
		enterField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getThePage(e.getActionCommand());
			}
		});

		add(enterField, BorderLayout.NORTH);

		contentArea = new JEditorPane();
		contentArea.setEditable(false);
		contentArea.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
					getThePage(e.getURL().toString());
			}
		});

		add(new JScrollPane(contentArea), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
	}

	private void getThePage(String location) {
		// carrega o documento e exibe a localizacao
		try {
			contentArea.setPage(location);
			enterField.setText(location);
		} catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error retrieving specified URL", "BAD URL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
