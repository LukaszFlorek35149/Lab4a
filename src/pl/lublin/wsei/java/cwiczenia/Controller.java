package pl.lublin.wsei.java.cwiczenia;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public Label IbFile;
    public ListView lstInfografiki;

    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)","*.xml");

    ObservableList<String> tytuly = FXCollections.observableArrayList();
    GusInfoGraphicList igList;

    @FXML
    public void initialize()
    {
        fileChooser.getExtensionFilters().add(xmlFilter);
    }


    public void btnOpenFileAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
        {
            igList = new GusInfoGraphicList(file.getAbsolutePath());
            IbFile.setText(file.getAbsolutePath());
            for (Infografika ig: igList.infografiki) tytuly.add(ig.tytul);
            lstInfografiki.setItems(tytuly);
        }
        else{
            IbFile.setText("Proszę wczytać plik");
        }
    }
}
