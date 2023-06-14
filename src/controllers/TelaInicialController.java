package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class TelaInicialController implements Initializable{

	@FXML
	private BorderPane telaInicial;
	
	//private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
		
	public void clickCadastrar() throws IOException {
		Stage stage = (Stage) this.telaInicial.getScene().getWindow();
		
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaCadastro.fxml")).load();
		
		Scene cena = new Scene(bp); 
		
		stage.setScene(cena);
		stage.show();
	}
	
	/*public void clickCadastrar() throws IOException {
		if(stage==null || stage.isShowing() == false) {
			System.out.println("Stage nulo, instancionando um novo...");
			
			this.stage = new Stage();
			
			BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaCadastro.fxml")).load();
			
			Scene cena = new Scene(bp); 
			
			stage.setScene(cena);
			stage.setAlwaysOnTop(true);
			stage.show();
		}else {
			stage.setMaximized(true);
		}
	}*/

}
