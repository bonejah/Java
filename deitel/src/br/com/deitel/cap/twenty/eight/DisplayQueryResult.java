package br.com.deitel.cap.twenty.eight;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DisplayQueryResult extends JFrame {
	// URL de banco de dados, usuario e senha
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	static final String USERNAME = "deitel";
	static final String PASSWORD = "deitel";

	// a consulta padrao recupera todos os dados da tabela Authors
	static final String DEFAULT_QUERY = "SELECT * FROM Authors";

	private ResultSetTableModel tableModel;
	private JTextArea queryArea;

	// cria o ResultSetTableModel e GUI

	public DisplayQueryResult() {
		super("Displaying Query Results");

		try {
			// cria o TableModel para resultados da consulta SELECT * FROM
			// Authors
			tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

			// configura JTextArea em que o usuario digita consultas
			queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);

			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// configura o JButton para enviar a consulta
			JButton submitButton = new JButton("Submit Query");
			
			// cria o Box para gerenciar o posicionamento da queryArea e d osubmitButton na GUI
			Box boxNorth = Box.createHorizontalBox();
			boxNorth.add(scrollPane);
			boxNorth.add(submitButton);
			
			// cria JTable com base no tableModel
			JTable resultTable = new JTable(tableModel);
			
			JLabel filterJLabel = new JLabel("Filter:");
			JTextField filterText = new JTextField();
			JButton filterButton = new JButton("Apply Filter");
			Box boxSouth = Box.createHorizontalBox();
			
			boxSouth.add(filterJLabel);
			boxSouth.add(filterText);
			boxSouth.add(filterButton);
			
			// posiciona os componentes GUI no painel de conteudo
			add(boxNorth, BorderLayout.NORTH);
			add(new JScrollPane(resultTable), BorderLayout.CENTER);
			add(boxSouth, BorderLayout.SOUTH);
			
			// cria evento ouvinte para submitButton			
			submitButton.addActionListener(new ActionListener(){ 
				@Override
				public void actionPerformed(ActionEvent e) {
					// realiza uma nova consulta
					try {
						tableModel.setQuery(queryArea.getText());
					} catch (SQLException sqlException) {
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// tenta recuperar a partir da consulta de usuario invalida executando a consulta padrao
						try {
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch (SQLException sqlException2) {
							JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
							
							// assegura que a conexao de banco de dados esta fechada
							tableModel.disconnectFromDatabase();
							System.exit(1);
						}
					}
					
				}
			});
			
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			
			setSize(500,250);
			setVisible(true);
			
			// cria o ouvinte filterButton
			filterButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String text = filterText.getText();
					
					if(text.length() == 0) 
						sorter.setRowFilter(null);
					else {
						try {
							sorter.setRowFilter(RowFilter.regexFilter(text));
						} catch (PatternSyntaxException patternSyntaxException) {
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			// desconecta-se do banco de dados e sai quando a janela for fechada
			@Override
			public void windowClosed(WindowEvent event) {
				tableModel.disconnectFromDatabase();
				System.exit(1);
			}
		});
	}
	
	public static void main(String args[]) {
		new DisplayQueryResult();
	}
	
}
