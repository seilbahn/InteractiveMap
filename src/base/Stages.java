/*
 * Class Stages
 *
 * This is the class for the application's stages.
 * There is methods for the opening and the closing these stages.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */

package base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Stages {
    static Stage startPage = new Stage();
    static Stage sampleProjectPage = new Stage();
    static Stage mainPage = new Stage();
    static Stage informationPage = new Stage();

    public static void startPageOpen() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Stages.class.getResource("StartPage.fxml")));
        Scene scene = new Scene(root, 447, 106);
        startPage.getIcons().add(new Image(Objects.requireNonNull(Stages.class.getResourceAsStream("/img/icon.png"))));
        startPage.setTitle(TextSources.START_PAGE_TITLE);
        startPage.setScene(scene);
        startPage.setResizable(false);
        startPage.show();
    }

    public static void startPageClose() {
        startPage.close();
    }

    public static void sampleProjectPageOpen() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Stages.class.getResource("SampleProjectPage.fxml")));
        Scene scene = new Scene(root, 390, 77);
        sampleProjectPage.getIcons().add(new Image(Objects.requireNonNull(Stages.class.getResourceAsStream("/img/icon.png"))));
        sampleProjectPage.setTitle(TextSources.SAMPLE_PROJECT_PAGE_TITLE);
        sampleProjectPage.setScene(scene);
        sampleProjectPage.setResizable(false);
        sampleProjectPage.show();
    }

    public static void sampleProjectPageClose() {
        sampleProjectPage.close();
    }

    public static void mainPageOpen() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Stages.class.getResource("MainPage.fxml")));
        Scene scene = new Scene(root, 1280, 800);
        mainPage.getIcons().add(new Image(Objects.requireNonNull(Stages.class.getResourceAsStream("/img/icon.png"))));
        mainPage.setTitle(TextSources.MAIN_PAGE_TITLE);
        mainPage.setScene(scene);
        mainPage.setMaximized(true);
        mainPage.show();
    }

    public static void mainPageClose() throws IOException {
        mainPage.close();
    }

    public static void informationPageOpen() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Stages.class.getResource("InformationPage.fxml")));
        Scene scene = new Scene(root, 604, 89);
        informationPage.getIcons().add(new Image(Objects.requireNonNull(Stages.class.getResourceAsStream("/img/icon.png"))));
        informationPage.setTitle(TextSources.INFORMATION_PAGE_TITLE);
        informationPage.setScene(scene);
        informationPage.setResizable(false);
        informationPage.show();
    }

    public static void informationPageClose() {
        informationPage.close();
    }
}