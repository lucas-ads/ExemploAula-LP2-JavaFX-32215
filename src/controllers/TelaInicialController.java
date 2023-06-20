package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao.DaoUsuario;
import entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaInicialController implements Initializable{

	@FXML
	private BorderPane telaInicial;

	@FXML
	private TableView<Usuario> tabelaUsuarios;
	
	@FXML
	private TableColumn<Usuario, Integer> colunaID;
	
	@FXML
	private TableColumn<Usuario, String> colunaEmail;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colunaID.setCellValueFactory( new PropertyValueFactory<>("id") );
		colunaEmail.setCellValueFactory( new PropertyValueFactory<>("email") );
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		try {
			List<Usuario> users = daoUsuario.buscarUsuarios();
			
			tabelaUsuarios.setItems( FXCollections.observableArrayList( users ) );
		
		} catch (SQLException e) {
			
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Atenção!");
			a.setContentText("Erro ao carregar usuários: " + e.getMessage());
			
			a.show();
			
		}
		
		
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
