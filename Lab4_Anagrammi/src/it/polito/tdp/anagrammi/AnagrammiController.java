package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.db.ParolaDAO;
import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextFlow txtResult;

    @FXML
    private Button btnReset;
    
    private AnagrammiModel model;
    
    public void setModel(AnagrammiModel model){
    	this.model = model;
    }

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola = txtInput.getText();
    	List<String> listaParole = model.creaAnagrammi(parola);
    	ParolaDAO dao = new ParolaDAO();
    	for(String s : listaParole){
    		Text tempText = new Text(s + "\n");
    		if(dao.checkDizionario(s) == false){
    			tempText.setFill(Color.RED);
    		}
    		txtResult.getChildren().add(tempText);
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtResult.getChildren().clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
