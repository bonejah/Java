package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {
	
	private int contador = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");

		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		botaoDecremento.setOnAction(e -> {
			contador--;
			labelNumero.setText(Integer.toString(contador));
			atualizaLabelNumero(labelNumero);
		});

		Button botaoIncremento = new Button("+");
		botaoIncremento .getStyleClass().add("botoes");
		botaoIncremento.setOnAction(e -> {
			contador++;
			labelNumero.setText(Integer.toString(contador));
			atualizaLabelNumero(labelNumero);
		});
		
		HBox boxBotoes = new HBox();
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		boxBotoes.setAlignment(Pos.CENTER);
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setSpacing(10);
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		
		String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();

		Scene scene = new Scene(boxConteudo, 400, 400);
		scene.getStylesheets().add(caminhoDoCss);
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void atualizaLabelNumero(Label label) {
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		
		if (contador > 0) {
			label.getStyleClass().add("verde");
		} else if (contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}
	
}
