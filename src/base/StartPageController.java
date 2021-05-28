/*
 * Class StartPageController
 *
 * This is the controller-class for the StartPage.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public TextField textField1;
    @FXML
    public MenuBar menuBar1;
    @FXML
    public Menu menu1;
    @FXML
    public Menu menu2;
    @FXML
    public RadioMenuItem radioMenuItem1;
    @FXML
    public RadioMenuItem radioMenuItem2;

    private void checkFolderExists(Path path) {
        button2.setDisable(!Files.exists(path));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField1.textProperty().addListener((Observable, oldValue, newValue) -> {
            if (!textField1.getText().isEmpty()) {
                checkFolderExists(Paths.get(textField1.getText()));
            }
        });
    }

    @FXML
    public void initialize() {
        TextSources textSources = new TextSources(GlobalSources.CURRENT_LANGUAGE);
        button1.setText(TextSources.START_PAGE_BUTTON);
        button2.setText(TextSources.START_PAGE_BUTTON_BEGIN);
        menu1.setText(TextSources.START_PAGE_MENU_SETTINGS);
        menu2.setText(TextSources.START_PAGE_MENU_LANGUAGE);
        radioMenuItem1.setText(TextSources.START_PAGE_RADIO_MENU_LANGUAGE_EN);
        radioMenuItem2.setText(TextSources.START_PAGE_RADIO_MENU_LANGUAGE_RU);
        textField1.setPromptText(TextSources.START_PAGE_TEXT_FIELD);
    }

    public void button1Click(ActionEvent actionEvent) {
        DirectoryChooser dialog = new DirectoryChooser();
        dialog.setTitle(TextSources.START_PAGE_DIALOG_CHOOSER);
        dialog.setInitialDirectory(new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString()));
        File result = dialog.showDialog(new Stage());
        if (result != null) {
            GlobalSources.CURRENT_PATH = result.toString();
            textField1.setText(GlobalSources.CURRENT_PATH);
            Path path = Paths.get(GlobalSources.CURRENT_PATH);
            checkFolderExists(path);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(TextSources.START_PAGE_ALERT_ERROR_TITLE);
            alert.setHeaderText(null);
            alert.setContentText(TextSources.START_PAGE_ALERT_ERROR_CONTENT_TEXT);
            alert.showAndWait();
        }
    }

    public void radioMenuItem1OnActon(ActionEvent actionEvent) {
        radioMenuItem1.setSelected(true);
        radioMenuItem2.setSelected(false);
        setLanguage();
    }

    public void radioMenuItem2OnActon(ActionEvent actionEvent) {
        radioMenuItem2.setSelected(true);
        radioMenuItem1.setSelected(false);
        setLanguage();
    }

    private void setLanguage() {
        if (radioMenuItem1.isSelected()) {
            GlobalSources.CURRENT_LANGUAGE = "English";
        }
        if (radioMenuItem2.isSelected()) {
            GlobalSources.CURRENT_LANGUAGE = "Russian";
        }
        initialize();
    }

    public void button2Click(ActionEvent actionEvent) throws Exception {
        Stages.startPageClose();
        Stages.sampleProjectPageOpen();
    }

    public void button3Click(ActionEvent actionEvent) {
        File folder = new File(textField1.getText());
        try {
            folder.mkdir();
            GlobalSources.CURRENT_PATH = textField1.getText();
            button2.setDisable(false);
        } catch (Throwable ex) {
            button2.setDisable(true);
        }
    }
}
