/*
 * Class SampleProjectPageController
 *
 * This is the controller-class for the SampleProjectPage.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SampleProjectPageController implements Initializable {
    @FXML
    public TextField textField1;
    @FXML
    public Button button1;
    @FXML
    public Button button2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button1.setText(TextSources.SAMPLE_PROJECT_BUTTON_ADD);
        button2.setText(TextSources.SAMPLE_PROJECT_BUTTON_BEGIN);
        textField1.setPromptText(TextSources.SAMPLE_PROJECT_TEXT_FIELD);
        textField1.textProperty().addListener((Observable, oldValue, newValue) -> {
            checkFile();
        });
    }

    public void button1Click(ActionEvent actionEvent) {
        FileChooser dialog = new FileChooser();
        dialog.setTitle(TextSources.START_PAGE_DIALOG_CHOOSER);
        dialog.setInitialDirectory(new File(new JFileChooser().getFileSystemView().getDefaultDirectory().toString()));
        dialog.setInitialDirectory(new JFileChooser().getFileSystemView().getDefaultDirectory());
        dialog.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("jpg-файлы", "*.jpg"),
                new FileChooser.ExtensionFilter("png-файлы", "*.png"));
        File result = dialog.showOpenDialog(new Stage());
        textField1.setText(result.toString());
        checkFile();
    }

    public void button2Click(ActionEvent actionEvent) throws IOException {
        String path = textField1.getText();
        File source = new File(path);
        File destination = new File(GlobalSources.CURRENT_PATH + "/" + "image." + getFileExtension(source));
        copyFileUsingStream(source, destination);
        GlobalSources.CURRENT_IMAGE_PATH = "file:///" + GlobalSources.CURRENT_PATH.replace("\\", "/") + "/" + "image." + getFileExtension(source);
        Stages.sampleProjectPageClose();
        Stages.mainPageOpen();
    }

    private void checkFile() {
        button2.setDisable(!new File(textField1.getText()).exists());
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }
}