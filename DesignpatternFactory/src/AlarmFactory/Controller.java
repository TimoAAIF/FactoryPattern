package AlarmFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class Controller implements Initializable {

    @FXML public Button Einbrechen;
    @FXML public Button Alarmerstellen;
    @FXML public Label Meldungen;
    @FXML public TextField Einbruchsbereich;
    @FXML public Button Alarmruecksetzen;
    @FXML private TableView<Alarmanlage> tableView;
    @FXML private TableColumn<Alarmanlage, String> colName;
    @FXML private TableColumn<Alarmanlage, Boolean> colStatus;
    @FXML private TableColumn<Alarmanlage, Boolean> colAlarm;
    @FXML public TextField Alarmbereich;
    AlarmanlagenFabrik alarmFabrik = new AlarmanlagenFabrik();
    ObservableList<Alarmanlage> alarmanlagen = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colAlarm.setCellValueFactory(new PropertyValueFactory<>("Alarm"));
    }

    public void felderleeren(){
        Alarmbereich.clear();
    }

    public void Alarmerstellen(ActionEvent actionEvent) {
        if(!Alarmbereich.getText().isEmpty()){

            String bereich = Alarmbereich.getText();

            //Die Fabrik erstellt mir eine Alarmanlage nach benötigten Bereich
            Alarmanlage alarmanlage = alarmFabrik.macheneueAlarmanlage(bereich);

            if(alarmanlage != null){
                //Alarm der Tabelle hinzufügen
                alarmanlagen.add(alarmanlage);
                tableView.setItems(alarmanlagen);
                tableView.refresh();
                felderleeren();
            }else{
                //Meldung: Dieser Ort kann noch nicht geschützt werden Produkte Folgen.
                Meldungen.setText("Dieser Ort kann noch nicht geschützt werden Produkte Folgen. Bitte anderen Ort angeben. (Obergeschoss, Haustüre, Garten)");
                felderleeren();
            }

        }
    }

    public void Einbrechen(ActionEvent actionEvent) {
        //Es wird eingebrochen wo wird mit einem Random number generator ausgelost

        if(Einbruchsbereich.getText().equals("Obergeschoss")){
            for(Alarmanlage a : alarmanlagen){
                if(a instanceof Obergeschossalarm && a.isStatus()){
                    a.setAlarm(true);
                    Meldungen.setText("Einbruch verhindert");

                    break;
                }else{
                    Meldungen.setText("Einbruch erfolgreich");
                }
            }
        }else if(Einbruchsbereich.getText().equals("Haustüre")){
            for(Alarmanlage a : alarmanlagen){
                if(a instanceof Haustueralarm && a.isStatus()){
                    a.setAlarm(true);
                    Meldungen.setText("Einbruch verhindert");

                    break;
                }else{
                    Meldungen.setText("Einbruch erfolgreich");
                }
            }
        }else if(Einbruchsbereich.getText().equals("Garten")){
            for(Alarmanlage a : alarmanlagen){
                if(a instanceof Gartenalarm && a.isStatus()){
                    a.setAlarm(true);
                    Meldungen.setText("Einbruch verhindert");

                    break;
                }else{
                    Meldungen.setText("Einbruch erfolgreich");
                }
            }
        }else{
            Meldungen.setText("Einbruch nicht gültig");
        }

        tableView.refresh();
    }

    public void Alarmruecksetzen(ActionEvent actionEvent) {
        for(Alarmanlage a : alarmanlagen){
            a.setAlarm(false);
        }

        tableView.refresh();
    }

    public void Alarmausschalten(ActionEvent actionEvent) {
        for(Alarmanlage a : alarmanlagen){
            a.setStatus(false);
        }

        tableView.refresh();
    }

    public void Alarmeinschalten(ActionEvent actionEvent) {
        for(Alarmanlage a : alarmanlagen){
            a.setStatus(true);
        }

        tableView.refresh();
    }
}
