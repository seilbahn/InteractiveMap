/*
 * Class Main
 *
 * This is the main class in the application
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage startPage) throws Exception {
        Stages.startPageOpen();
        //Stages.sampleProjectPageOpen();
        //Stages.mainPageOpen();
    }

    public static void main(String[] args) {
        // Creating a non-use object of the class TextSources for the language setting
        TextSources textSources = new TextSources(GlobalSources.CURRENT_LANGUAGE);
        launch(args);
    }
}