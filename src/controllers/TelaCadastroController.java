package controllers;

import java.io.IOException;

import dao.DaoTarefa;
import dao.DaoUsuario;
import entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaCadastroController {
	
	@FXML
	private BorderPane telaCadastroRoot;
	
	@FXML
	private TextField textFieldEmail;
	
	@FXML
	private PasswordField textFieldSenha;
	
	@FXML
	private TextField textFieldIdade;
	
	public void cadastrar() {
		String email = textFieldEmail.getText().trim();
		String senha = textFieldSenha.getText();
		int idade = Integer.parseInt( textFieldIdade.getText().trim() );
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		DaoUsuario daoUsuario = new DaoUsuario();
		try {			
			daoUsuario.cadastrar(usuario);
			
			voltarTelaInicial();
			
		}catch(Exception e) {	
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Atenção!");
			a.setContentText("Houve um erro ao cadastrar o usuário: " + e.getMessage());
			
			a.show();
		}
	}
	
	public void clickCancelar() throws IOException  {
		voltarTelaInicial();
	}
	
	public void voltarTelaInicial() throws IOException {
		Stage stage = (Stage) this.telaCadastroRoot.getScene().getWindow();
		
		BorderPane bp = new FXMLLoader(getClass().getResource("/views/TelaInicial.fxml")).load();
		
		Scene cena = new Scene(bp); 
		
		stage.setScene(cena);
		stage.show();
	}
	
}
