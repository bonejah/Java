package br.com.devdojo.javacore.jdbc.classes;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("Comando execute foi executado");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("Linha foi inserida, deleta ou atualizada");
		if (event.getSource() instanceof RowSet) {
			try {
				((RowSet) event.getSource()).execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		System.out.println("Cursor moveu");
	}

}
