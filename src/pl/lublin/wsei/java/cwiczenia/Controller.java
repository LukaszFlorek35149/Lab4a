package pl.lublin.wsei.java.cwiczenia;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.application.HostServices;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    public Label IbFile;
    public ListView lstInfografiki;
    public ImageView imgMiniaturka;
    public Button btnPokazInfografike;
    public TextField txtAdresStrony;
    public Button btnPrzejdzDoStrony;
    private Infografika selInfografika;
    private HostServices hostServices;
    private Stage stage;


    public void setStage(Stage stage)
    {
        this.stage=stage;
    }

    public void setHostServices(HostServices hostServices)
    {
        this.hostServices = hostServices;
    }


    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*.xml)","*.xml");

    ObservableList<String> tytuly = FXCollections.observableArrayList();
    GusInfoGraphicList igList;

    @FXML
    public void initialize()
    {
        fileChooser.getExtensionFilters().add(xmlFilter);

        lstInfografiki.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number old_val, Number new_val) {
                      int index = new_val.intValue();
                      if(index != -1)
                      {
                          selInfografika = igList.infografiki.get(index);
                          txtAdresStrony.setText(igList.infografiki.get(index).adresStrony);
                          Image image = new Image(igList.infografiki.get(index).adresMiniaturki);
                          imgMiniaturka.setImage(image);
                      }
                      else
                      {
                          txtAdresStrony.setText("");
                          imgMiniaturka.setImage(null);
                          selInfografika = null;
                      }
                    }
                }
        );

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

    public void btnZaladujStrone(ActionEvent actionEvent) {
        if(selInfografika != null)
        {
            hostServices.showDocument(selInfografika.adresStrony);
        }

    }

    //
    public void btnPokazOnAction(ActionEvent actionEvent) {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ImgViewer.fxml"));
            Parent root = loader.load();
            ImgViewer viewer = loader.getController();
            if(selInfografika != null)
            {
                Image img = new Image(selInfografika.adresGrafiki);
                viewer.imgView.setFitWidth(img.getWidth());
                viewer.imgView.setFitHeight(img.getHeight());
                viewer.imgView.setImage(img);

            }
            Stage stage =  new Stage();
            stage.setTitle("Podgląd infografiki");
            stage.setScene(new Scene(root, 900, 800));
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //

}
