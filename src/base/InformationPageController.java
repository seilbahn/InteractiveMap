/*
 * Class InformationPageController
 *
 * This is the controller-class for the InformationPage.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InformationPageController {
    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label label4;
    @FXML
    public Label label5;

    @FXML
    public void initialize() {
        label1.setText("Current language: " + GlobalSources.CURRENT_LANGUAGE);
        label2.setText("Directory path: " + GlobalSources.CURRENT_PATH);
        label3.setText("Image path: " + GlobalSources.CURRENT_IMAGE_PATH);
        label4.setText("Canvas width: " + GlobalSources.CANVAS_WIDTH);
        label5.setText("Canvas width: " + GlobalSources.CANVAS_HEIGHT);
    }
}