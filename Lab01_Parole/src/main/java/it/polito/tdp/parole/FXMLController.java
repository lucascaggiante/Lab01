package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button idCancella;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	double inizio = System.nanoTime();
    	this.elenco.addParola(txtParola.getText());
    	double fine = System.nanoTime();
    	this.elenco.getElenco();
    	this.txtParola.setText("");
    	
    	String risultato = "";
    	for (String s : elenco.getElenco()) {
    		risultato += s + "\n";
    	}
    	this.txtResult.setText(risultato);
    	this.txtTime.setText("Tempo impiegato per l'operazione: " + (fine-inizio) + "  ns");
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	double inizio = System.nanoTime();
    	this.elenco.reset();
    	double fine = System.nanoTime();
    	txtResult.setText(elenco.toString());
    	
    	this.txtTime.setText("Tempo impiegato per l'operazione: " + (fine-inizio) + "  ns");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	double inizio = System.nanoTime();
    	this.elenco.cancellaParola(txtResult.getSelectedText());
    	double fine = System.nanoTime();
    	this.txtResult.clear();
    	String risultato = "";
    	for(String s : elenco.getElenco()) {
    		risultato += s + "\n";
    	}
    	this.txtResult.setText(risultato);
    	
    	this.txtTime.setText("Tempo impiegato per l'operazione: " + (fine-inizio) + "  ns");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
