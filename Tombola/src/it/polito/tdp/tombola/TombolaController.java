package it.polito.tdp.tombola;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TombolaController {
	
	private boolean partitaIniziata = false;
	private boolean partitaFinita = false;
	
	private List<Integer> estrazioni = new ArrayList<Integer>();
	private List<Integer> ultimiNumeriEstratti = new ArrayList<Integer>();
	private Iterator<Integer> iter;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEstrai;

    @FXML
    private TextField txtUltimiNumeri;

    @FXML
    private Button btnTerminaPartita;

    @FXML
    private Button btnNuovaPartita;

    @FXML
    private TextField txtNumeroEstratto;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	for(int i = 1; i <= 90; i++ ){
			estrazioni.add(i);
		}
    	Collections.shuffle(estrazioni);
    	this.txtNumeroEstratto.setText("");
    	this.txtUltimiNumeri.setText("");
    	
    	this.btnNuovaPartita.setDisable(true);
    	this.btnTerminaPartita.setDisable(false);
    	this.iter=this.estrazioni.iterator();
    }

    @FXML
    void doEstraiNuovoNumero(ActionEvent event) {
    	if (iter.hasNext()){
    		int num = iter.next();
    		this.txtNumeroEstratto.setText(Integer.toString(num));
    		if (this.ultimiNumeriEstratti.size()<5)
    			this.ultimiNumeriEstratti.add(num);
    		else{
    			this.ultimiNumeriEstratti.remove(0);
    			this.ultimiNumeriEstratti.add(num);
    		}
    		this.txtUltimiNumeri.clear();
    		//this.txtUltimiNumeri.setText(this.ultimiNumeriEstratti.toString());
    		String s = new String();
    		for(int j:this.ultimiNumeriEstratti){
    			s+=" "+j;
    		}
    		this.txtUltimiNumeri.setText(s);
    	}
    }

    @FXML
    void doTerminaPartita(ActionEvent event) {
    	this.btnNuovaPartita.setDisable(false);
    	this.txtNumeroEstratto.setText("");
    	this.txtUltimiNumeri.setText("");
    	this.estrazioni.removeAll(estrazioni);
    	this.ultimiNumeriEstratti.removeAll(ultimiNumeriEstratti);
    	this.btnTerminaPartita.setDisable(true);
    }

    @FXML
    void initialize() {
    	
    	this.btnTerminaPartita.setDisable(true);
    	
        assert btnEstrai != null : "fx:id=\"btnEstrai\" was not injected: check your FXML file 'Tombola.fxml'.";
        assert txtUltimiNumeri != null : "fx:id=\"txtUltimiNumeri\" was not injected: check your FXML file 'Tombola.fxml'.";
        assert btnTerminaPartita != null : "fx:id=\"btnTerminaPartita\" was not injected: check your FXML file 'Tombola.fxml'.";
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Tombola.fxml'.";
        assert txtNumeroEstratto != null : "fx:id=\"txtNumeroEstratto\" was not injected: check your FXML file 'Tombola.fxml'.";

    }
}

