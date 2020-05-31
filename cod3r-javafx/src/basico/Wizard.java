package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Wizard extends Application {
	
	
	private Stage janela;
	private Scene passo1;
	private Scene passo2;
	private Scene passo3;

	@Override
	public void start(Stage primaryStage) throws Exception {
		janela = primaryStage;
		
		criarPasso1();
		criarPasso2();
		criarPasso3();
		
		janela.setScene(passo1);
		janela.setTitle("Wizard");
		janela.show();
	}
	
	private void criarPasso1() {
		Button proximoPasso = new Button("Ir p/passo2 >>>");
		proximoPasso.setOnAction(e -> {
			janela.setScene(passo2);
			janela.setTitle("Wizard: Passo2#");
		});
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(proximoPasso);
		
		passo1 = new Scene(hBox, 400, 400);
	}
	
	private void criarPasso2() {
		Button anteriorPasso = new Button("<< Ir p/passo1");
		anteriorPasso.setOnAction(e ->{
			janela.setScene(passo1);
			janela.setTitle("Wizard: Passo1#");
		});
		
		Button proximoPasso = new Button("Ir p/passo3 >>>");
		proximoPasso.setOnAction(e ->{
			janela.setScene(passo3);
			janela.setTitle("Wizard: Passo3#");
		});
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(anteriorPasso);
		hBox.getChildren().add(proximoPasso);
		
		passo2 = new Scene(hBox, 400, 400);
	}
	
	private void criarPasso3() {
		Button anteriorPasso = new Button("<< Ir p/passo2");
		anteriorPasso.setOnAction(e ->{
			janela.setScene(passo2);
			janela.setTitle("Wizard: Passo2#");
		});
		
		Button proximoPasso = new Button("Finalizar!!");
		proximoPasso.setOnAction(e ->{
			System.exit(0);
		});
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(anteriorPasso);
		hBox.getChildren().add(proximoPasso);
		
		passo3 = new Scene(hBox, 400, 400);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
