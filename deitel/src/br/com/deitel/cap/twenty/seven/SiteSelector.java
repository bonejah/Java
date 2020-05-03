package br.com.deitel.cap.twenty.seven;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SiteSelector extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8260140601455298854L;
	private HashMap<String, URL> sites; // nomes e URLs de site
	private ArrayList<String> sitesNames; // nomes de site
	@SuppressWarnings("rawtypes")
	private JList siteChooser; // lista de sites a escolher

	// le os parametros e configura a GUI
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		sites = new HashMap<String, URL>(); // cria HashMap
		sitesNames = new ArrayList<String>(); // cria a ArrayList

		// obtem os parametros do documento XHTML
		getSitesFromHTMLParameters();

		// cria componentes GUI e a interface de layout
		add(new JLabel("Choose a site to browse"), BorderLayout.NORTH);

		siteChooser = new JList(sitesNames.toArray()); // preenche a JList
		siteChooser.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				// obtem o nome do site selecionado
				Object object = siteChooser.getSelectedValue();

				// utiliza o nome do site selecionado para localizar o URL
				// correspondente
				URL newDocument = sites.get(object);

				// obtem container de applets
				AppletContext browser = getAppletContext();

				// instrui o conteiner de applets a mudar as paginas
				browser.showDocument(newDocument);
			}
		});

		add(new JScrollPane(siteChooser));
	}

	private void getSitesFromHTMLParameters() {
		String title; // titulo do site
		String location; // localizacao do site
		URL url; // URL da localizacao
		int counter = 0; // conta numero de sites

		title = getParameter("title" + counter); // obtem o primeiro titulo da
													// lista

		// faz um loop ate que nao haja mais parametros do documento XHTML
		while (title != null) {
			// obtem a localizacao do site
			location = getParameter("location" + counter);

			// coloca titulo URL no HashMao e titulo na ArrayList
			try {
				url = new URL(location); // converte a localiacao em URL
				sites.put(title, url); // coloca titulo URL no HashMap
				sitesNames.add(title); // coloca o titulo na ArrayList
			} catch (MalformedURLException malformedURLException) {
				malformedURLException.printStackTrace();
			}

			++counter;
			title = getParameter("title" + counter); // obtem o proximo titulo
														// do site
		}
	}
}
