package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import bean.Artist;
import bean.Country;
import bean.Elenco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SampleController {
	
	private Model m = new Model();
	
	public void setModel(Model m){
		this.m=m;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Country> comboNazione;

    @FXML
    private Button btnUtenti;

    @FXML
    private Button btnConnettivita;

    @FXML
    private TextArea txtResult;

    @FXML
    void doConnettivita(ActionEvent event) {
    	Country c = comboNazione.getValue();
//    	
//    	m.buildGraph(c.getId());
//    	int numeroComponentiConnesse = m.getComponentiConnesse(c.getId());
//    	  
//    	if(numeroComponentiConnesse==1){
//    		     txtResult.appendText("Il grafo è connesso!\n");
//    		     return;
//    	}
//    	 
//    	if(numeroComponentiConnesse> 1){
//    		     txtResult.appendText("Il grafo non è connesso!\n");
//    		     return;
//    	}
//    	   
//    	Artist start = m.getVertex(c.getId());
//    	List<Artist> elencoVisita = m.getComponenteConnessa(start); 
//    	txtResult.appendText(elencoVisita.toString());
//    	   
    }

    @FXML
    void doUtenti(ActionEvent event) {
    	txtResult.clear();
    	Country c = comboNazione.getValue();
    	if(c==null){
    		txtResult.appendText("Seleziona una nazione!\n");
    		return;
    	}
    	
    	List<Elenco> elenco = m.getElenco(c.getId());
    	if(elenco.isEmpty()){
    		txtResult.appendText("L elenco è vuoto!\n");
    		return;
    	}
    	for(Elenco s : elenco){
    	txtResult.appendText(s+" \n");
    	}
    	btnConnettivita.setDisable(false);
    }

    @FXML
    void initialize() {
        assert comboNazione != null : "fx:id=\"comboNazione\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnUtenti != null : "fx:id=\"btnUtenti\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnConnettivita != null : "fx:id=\"btnConnettivita\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Sample.fxml'.";

          comboNazione.getItems().addAll(m.getNaz());
          btnConnettivita.setDisable(true);
    }
}
