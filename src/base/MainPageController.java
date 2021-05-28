/*
 * Class MainPageController
 *
 * This is the controller-class for the MainPage.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MainPageController implements Initializable {
    @FXML
    public Canvas canvas1;
    @FXML
    public Label labelSbSStatus;
    @FXML
    public Label labelSbSPoints;
    @FXML
    public Label labelManyPointsStatus;
    @FXML
    public Label labelManyPointsPoints;
    @FXML
    public Label labelPointSize;
    @FXML
    public Label labelInnerPointColor;
    @FXML
    public Label labelOuterPointColor;
    @FXML
    public Label labelObjectColor;
    @FXML
    public Label labelObjectHover;
    @FXML
    public Label labelObjectShow;
    @FXML
    public Label labelObjectOpacity;
    @FXML
    public Label labelHoverOpacity;
    @FXML
    public Label labelActiveOpacity;
    @FXML
    public Label labelEnteringPointsCoordinates;
    @FXML
    public Button buttonSbSSettingModeTurnOn;
    @FXML
    public Button buttonSbSSettingModeTurnOff;
    @FXML
    public Button buttonEnteringPointsAdd;
    @FXML
    public Button buttonEnteringPointsDelete;
    @FXML
    public Button buttonAddObject;
    @FXML
    public Button buttonManyPointsSettingModeTurnOn;
    @FXML
    public Button buttonManyPointsSettingModeTurnOff;
    @FXML
    public Button buttonCreatedObjectsDel;
    @FXML
    public Button buttonCreatedObjectsUp;
    @FXML
    public Button buttonCreatedObjectsDown;
    @FXML
    public TextField textFieldEnteringPointsX;
    @FXML
    public TextField textFieldEnteringPointsY;
    @FXML
    public TextField textFieldTitleText;
    @FXML
    public TextField textFieldObjectOpacity;
    @FXML
    public TextField textFieldHoverOpacity;
    @FXML
    public TextField textFieldActiveOpacity;
    @FXML
    public TextArea textAreaDescription;
    @FXML
    public TextArea textAreaHTML;
    @FXML
    public TextArea textAreaCSS;
    @FXML
    public TextArea textAreaJS;
    @FXML
    public ListView<String> listViewPoints;
    @FXML
    public ListView<String> listViewPoints1;
    @FXML
    public ListView<String> listViewPoints2;
    @FXML
    public Menu menuFile;
    @FXML
    public Menu menuEdit;
    @FXML
    public Menu menuProject;
    @FXML
    public MenuItem menuItemNew;
    @FXML
    public MenuItem menuItemClose;
    @FXML
    public MenuItem menuItemUndo;
    @FXML
    public MenuItem menuItemRedo;
    @FXML
    public MenuItem menuItemInformation;
    @FXML
    public ColorPicker colorPickerInnerPointColor;
    @FXML
    public ColorPicker colorPickerOuterPointColor;
    @FXML
    public ColorPicker colorPickerObjectColor;
    @FXML
    public ColorPicker colorPickerObjectHover;
    @FXML
    public ColorPicker colorPickerObjectShow;
    @FXML
    public Slider sliderPointSize;
    @FXML
    public WebView webViewBrowser;
    @FXML
    public TableView<WebPageObject> tableViewCreatedObjects;
    @FXML
    public TableColumn<WebPageObject, Integer> tableColumnObjectId;
    @FXML
    public TableColumn<WebPageObject, String> tableColumnObjectTitle;
    @FXML
    public TableColumn<WebPageObject, String> tableColumnObjectDescription;
    @FXML
    public TitledPane titledPaneGeneralSettings;
    @FXML
    public TitledPane titledPaneObjectsPoints;
    @FXML
    public TitledPane titledPaneTextSetting;
    @FXML
    public TitledPane titledPaneAddingObject;
    @FXML
    public TitledPane titledPaneCreatedObjects;
    @FXML
    public TitledPane titledPaneSbSSettingMode;
    @FXML
    public TitledPane titledPaneManyPointsSettingMode;
    @FXML
    public TitledPane titledPaneEnteringPointsSettingMode;
    @FXML
    public Tab tabHTML;
    @FXML
    public Tab tabCSS;
    @FXML
    public Tab tabJS;
    @FXML
    public Tab tabBrowser;

    GraphicsContext gc;
    DrawBoard drawBoard;
    ArrayList<Integer> pointsListX = new ArrayList<>();
    ArrayList<Integer> pointsListY = new ArrayList<>();
    ArrayList<WebPageObject> webPageObjectArrayList = new ArrayList<>();
    ObservableList<String> pointsList = FXCollections.observableArrayList();
    boolean stepByStepPointsSettingMode = false;
    boolean manyPointsSettingMode = false;
    int objectCounter = 1;
    Color colorPointInner = Color.RED;
    Color colorPointOuter = Color.WHITE;
    int pointWidthOuter = 10;
    int currentId = 0;
    int tempX;
    int tempY;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            beforeStartMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
        colorPickerInnerPointColor.setOnAction(event -> colorPointInner = colorPickerInnerPointColor.getValue());
        colorPickerOuterPointColor.setOnAction(event -> colorPointOuter = colorPickerOuterPointColor.getValue());
        sliderPointSize.valueProperty().addListener((Observable, oldValue, newValue) -> pointWidthOuter = (int) sliderPointSize.getValue());
        TableView.TableViewSelectionModel<WebPageObject> selectionModel = tableViewCreatedObjects.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                currentId = newValue.getObjectId();
            }
        });
        textAreaHTML.textProperty().addListener((Observable, oldValue, newValue) -> {
            try {
                Files.write(Paths.get(GlobalSources.CURRENT_PATH + "/index.html"), textAreaHTML.getText().getBytes());
                WebEngine webEngine = webViewBrowser.getEngine();
                webEngine.load("file:///" + GlobalSources.CURRENT_PATH + "/index.html");
                webEngine.reload();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        textAreaCSS.textProperty().addListener((Observable, oldValue, newValue) -> {
            try {
                Files.write(Paths.get(GlobalSources.CURRENT_PATH + "/style.css"), textAreaCSS.getText().getBytes());
                WebEngine webEngine = webViewBrowser.getEngine();
                webEngine.load("file:///" + GlobalSources.CURRENT_PATH + "/index.html");
                webEngine.reload();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        textAreaJS.textProperty().addListener((Observable, oldValue, newValue) -> {
            try {
                Files.write(Paths.get(GlobalSources.CURRENT_PATH + "/script.js"), textAreaJS.getText().getBytes());
                WebEngine webEngine = webViewBrowser.getEngine();
                webEngine.load("file:///" + GlobalSources.CURRENT_PATH + "/index.html");
                webEngine.reload();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        textFieldEnteringPointsX.textProperty().addListener((Observable, oldValue, newValue) -> {
            textFieldEnteringPointsX.setText(textFieldEnteringPointsX.getText().replaceAll("[^\\d]", ""));
            textFieldEnteringPointsY.setText(textFieldEnteringPointsY.getText().replaceAll("[^\\d]", ""));
            if (Integer.parseInt(textFieldEnteringPointsX.getText()) > GlobalSources.CANVAS_WIDTH) {
                textFieldEnteringPointsX.setText(Integer.toString(GlobalSources.CANVAS_WIDTH));
            }
            if (Integer.parseInt(textFieldEnteringPointsX.getText()) < 0) {
                textFieldEnteringPointsX.setText(Integer.toString(0));
            }
            buttonEnteringPointsAdd.setDisable(!enteringPointsDataChecking());
        });
        textFieldEnteringPointsY.textProperty().addListener((Observable, oldValue, newValue) -> {
            textFieldEnteringPointsY.setText(textFieldEnteringPointsY.getText().replaceAll("[^\\d]", ""));
            if (Integer.parseInt(textFieldEnteringPointsY.getText()) > GlobalSources.CANVAS_HEIGHT) {
                textFieldEnteringPointsY.setText(Integer.toString(GlobalSources.CANVAS_HEIGHT));
            }
            if (Integer.parseInt(textFieldEnteringPointsY.getText()) < 0) {
                textFieldEnteringPointsY.setText(Integer.toString(0));
            }
            buttonEnteringPointsAdd.setDisable(!enteringPointsDataChecking());
        });
    }

    public void anchorPaneOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.isShortcutDown() && keyEvent.getCode() == KeyCode.Z) {
            undo();
        }
        if (keyEvent.isShortcutDown() && keyEvent.getCode() == KeyCode.Y) {
            redo();
        }
        if (keyEvent.isShortcutDown() && keyEvent.getCode() == KeyCode.Q) {
            pointsListX.clear();
            pointsListY.clear();
            pointsList.clear();
            manyPointsSettingMode = true;
            labelManyPointsStatus.setText("status: on");
        }
        if (keyEvent.isShortcutDown() && keyEvent.getCode() == KeyCode.W) {
            manyPointsSettingMode = false;
            labelManyPointsStatus.setText("status: off");
        }
    }

    public void menuItemNewOnAction(ActionEvent actionEvent) throws IOException {
        Stages.mainPageClose();
        Stages.startPageOpen();
    }

    public void menuItemCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void menuItemUndoOnAction(ActionEvent actionEvent) {
        undo();
    }

    public void menuItemRedoOnAction(ActionEvent actionEvent) {
        redo();
    }

    public void menuItemInformationOnAction(ActionEvent actionEvent) throws IOException {
        Stages.informationPageOpen();
    }

    public void buttonSbSSettingModeTurnOnOnAction(ActionEvent actionEvent) {
        stepByStepPointsSettingMode = true;
        labelSbSStatus.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_ON);
    }

    public void buttonSbSSettingModeTurnOffOnAction(ActionEvent actionEvent) {
        stepByStepPointsSettingMode = false;
        labelSbSStatus.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_OFF);
    }

    public void buttonManyPointsSettingModeTurnOnOnAction(ActionEvent actionEvent) {
        manyPointsSettingMode = true;
        labelManyPointsStatus.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_ON);
    }

    public void buttonManyPointsSettingModeTurnOffOnAction(ActionEvent actionEvent) {
        manyPointsSettingMode = false;
        labelManyPointsStatus.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_OFF);
    }

    public void buttonEnteringPointsAddOnAction(ActionEvent actionEvent) {
        xySetting(Integer.parseInt(textFieldEnteringPointsX.getText()),
                Integer.parseInt(textFieldEnteringPointsY.getText()));
        textFieldEnteringPointsX.clear();
        textFieldEnteringPointsY.clear();
        buttonEnteringPointsAdd.setDisable(true);
        buttonEnteringPointsDelete.setDisable(false);
    }

    public void buttonEnteringPointsDeleteOnAction(ActionEvent actionEvent) {
        undo();
    }

    public void buttonAddObjectOnAction(ActionEvent actionEvent) throws IOException, TemplateException {
        if (pointsListX.isEmpty() || pointsListY.isEmpty()) {
            return;
        }
        WebPageObject webPageObject = new WebPageObject(objectCounter, pointsListX, pointsListY,
                textFieldTitleText.getText(),
                textAreaDescription.getText(),
                colorPickerObjectColor.getValue().toString().substring(2),
                colorPickerObjectHover.getValue().toString().substring(2),
                colorPickerObjectShow.getValue().toString().substring(2),
                textFieldObjectOpacity.getText(),
                textFieldActiveOpacity.getText(),
                textFieldHoverOpacity.getText(),
                new Font("Verdana", 14.0),
                new Font("Verdana", 12.0));
        webPageObjectArrayList.add(webPageObject);
        htmlFileCreate();
        cssFileCreate(webPageObject);
        preparingNewObject();
        listingsMaking();
        addingWebPageObjectToTableView();
    }

    public void buttonCreatedObjectsDelOnAction(ActionEvent actionEvent) throws TemplateException, IOException {
        int current = 0;
        for (WebPageObject webPageObject : webPageObjectArrayList) {
            if (webPageObject.getObjectId() == currentId) {
                current = webPageObjectArrayList.lastIndexOf(webPageObject);
            }
        }
        webPageObjectArrayList.remove(current);
        htmlFileCreate();
        listingsMaking();
        addingWebPageObjectToTableView();
    }

    public void buttonCreatedObjectsDownOnAction(ActionEvent actionEvent) {
        tableViewCreatedObjects.getSelectionModel().selectBelowCell();
    }

    public void buttonCreatedObjectsUpOnAction(ActionEvent actionEvent) {
        tableViewCreatedObjects.getSelectionModel().selectAboveCell();
    }

    public void canvas1OnMouseClicked(MouseEvent mouseEvent) {
        if (stepByStepPointsSettingMode) {
            xySetting((int) mouseEvent.getX(), (int) mouseEvent.getY());
        }
    }

    public void canvas1OnMouseMoved(MouseEvent mouseEvent) {
        labelEnteringPointsCoordinates.setText("X: " + mouseEvent.getX() + " Y: " + mouseEvent.getY());
        if (manyPointsSettingMode) {
            xySetting((int) mouseEvent.getX(), (int) mouseEvent.getY());
        }
    }

    private void beforeStartMethod() throws IOException {
        jsFileExistenceChecking();
        textSetting();
        Image bgImage = new Image(GlobalSources.CURRENT_IMAGE_PATH);
        GlobalSources.CANVAS_WIDTH = (int) bgImage.getWidth();
        GlobalSources.CANVAS_HEIGHT = (int) bgImage.getHeight();
        canvas1.setWidth(GlobalSources.CANVAS_WIDTH);
        canvas1.setHeight(GlobalSources.CANVAS_HEIGHT);
        gc = canvas1.getGraphicsContext2D();
        drawBoard = new DrawBoard(canvas1.getGraphicsContext2D());
        drawBoard.addDrawOperation(new SetImageOperation(bgImage, 0, 0));
        gc.drawImage(bgImage, 0, 0);
    }

    private void htmlFileCreate(WebPageObject webPageObject) throws IOException, TemplateException {
        String title = TextSources.MAIN_PAGE_TITLE;
        String image = GlobalSources.CURRENT_IMAGE_PATH;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File("./src/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> root = new HashMap<>();
        root.put("webPageObjectArrayList", webPageObjectArrayList);
        root.put("webPageObject", webPageObject);
        root.put("title", title);
        root.put("image", image);
        Template temp = cfg.getTemplate("HTMLPageTemplate.ftlh");
        FileWriter fileWriter = new FileWriter(GlobalSources.CURRENT_PATH + "/index.html");
        BufferedWriter out1 = new BufferedWriter(fileWriter);
        out1.write("");
        out1.close();
        Writer out = new OutputStreamWriter(new FileOutputStream(new File(GlobalSources.CURRENT_PATH + "/index.html")));
        temp.process(root, out);
        out.close();
    }

    private void htmlFileCreate() throws IOException, TemplateException {
        String title = TextSources.MAIN_PAGE_TITLE;
        String image = GlobalSources.CURRENT_IMAGE_PATH;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File("./src/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> root = new HashMap<>();
        root.put("webPageObjectArrayList", webPageObjectArrayList);
        root.put("title", title);
        root.put("image", image);
        Template temp = cfg.getTemplate("HTMLPageTemplate.ftlh");
        FileWriter fileWriter = new FileWriter(GlobalSources.CURRENT_PATH + "/index.html");
        BufferedWriter out1 = new BufferedWriter(fileWriter);
        out1.write("");
        out1.close();
        Writer out = new OutputStreamWriter(new FileOutputStream(new File(GlobalSources.CURRENT_PATH + "/index.html")));
        temp.process(root, out);
        out.close();
    }

    private void cssFileCreate(WebPageObject webPageObject) throws IOException, TemplateException {
        String height = Integer.toString(GlobalSources.CANVAS_HEIGHT);
        String width = Integer.toString(GlobalSources.CANVAS_WIDTH);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File("./src/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> root = new HashMap<>();
        root.put("webPageObjectArrayList", webPageObjectArrayList);
        root.put("webPageObject", webPageObject);
        root.put("height", height);
        root.put("width", width);
        Template temp = cfg.getTemplate("CSSTemplate.ftlh");
        FileWriter fileWriter = new FileWriter(GlobalSources.CURRENT_PATH + "/style.css");
        BufferedWriter out1 = new BufferedWriter(fileWriter);
        out1.write("");
        out1.close();
        Writer out = new OutputStreamWriter(new FileOutputStream(new File(GlobalSources.CURRENT_PATH + "/style.css")));
        temp.process(root, out);
        out.close();
    }

    private void preparingNewObject() {
        pointsListX.clear();
        pointsListY.clear();
        pointsList.clear();
        listViewPoints.refresh();
        listViewPoints1.refresh();
        listViewPoints2.refresh();
        Image bgImage = new Image(GlobalSources.CURRENT_IMAGE_PATH);
        GlobalSources.CANVAS_WIDTH = (int) bgImage.getWidth();
        GlobalSources.CANVAS_HEIGHT = (int) bgImage.getHeight();
        canvas1.setWidth(GlobalSources.CANVAS_WIDTH);
        canvas1.setHeight(GlobalSources.CANVAS_HEIGHT);
        gc = canvas1.getGraphicsContext2D();
        drawBoard = new DrawBoard(canvas1.getGraphicsContext2D());
        drawBoard.addDrawOperation(new SetImageOperation(bgImage, 0, 0));
        gc.drawImage(bgImage, 0, 0);
        objectCounter++;
    }

    private void listingsMaking() throws FileNotFoundException {
        StringBuilder htmlText = new StringBuilder();
        StringBuilder cssText = new StringBuilder();
        StringBuilder jsText = new StringBuilder();
        Scanner in = new Scanner(new File(GlobalSources.CURRENT_PATH + "/index.html"));
        while (in.hasNext())
            htmlText.append(in.nextLine()).append("\r\n");
        textAreaHTML.setText(htmlText.toString());
        in = new Scanner(new File(GlobalSources.CURRENT_PATH + "/style.css"));
        while (in.hasNext())
            cssText.append(in.nextLine()).append("\r\n");
        textAreaCSS.setText(cssText.toString());
        in = new Scanner(new File(GlobalSources.CURRENT_PATH + "/script.js"));
        while (in.hasNext())
            jsText.append(in.nextLine()).append("\r\n");
        textAreaJS.setText(jsText.toString());
        in.close();
        WebEngine webEngine = webViewBrowser.getEngine();
        webEngine.load("file:///" + GlobalSources.CURRENT_PATH + "/index.html");
        webEngine.reload();
    }

    private void addingWebPageObjectToTableView() {
        ObservableList<WebPageObject> list = FXCollections.observableArrayList();
        list.addAll(webPageObjectArrayList);
        tableViewCreatedObjects.setItems(list);
        tableColumnObjectId.setCellValueFactory(new PropertyValueFactory<>("_id"));
        tableColumnObjectTitle.setCellValueFactory(new PropertyValueFactory<>("_title"));
        tableColumnObjectDescription.setCellValueFactory(new PropertyValueFactory<>("_description"));
        tableViewCreatedObjects.refresh();
    }

    private void jsFileExistenceChecking() throws IOException {
        File file = new File(GlobalSources.CURRENT_PATH + "/" + "script.js");
        if (!file.exists()) {
            File source = new File("src/files/script.js");
            File destination = new File(GlobalSources.CURRENT_PATH + "/" + "script."
                    + SampleProjectPageController.getFileExtension(source));
            SampleProjectPageController.copyFileUsingStream(source, destination);
        }
        file = new File(GlobalSources.CURRENT_PATH + "/" + "jquery-3.6.0.min.js");
        if (!file.exists()) {
            File source = new File("src/files/jquery-3.6.0.min.js");
            File destination = new File(GlobalSources.CURRENT_PATH + "/" + "jquery-3.6.0.min."
                    + SampleProjectPageController.getFileExtension(source));
            SampleProjectPageController.copyFileUsingStream(source, destination);
        }
    }

    private void textSetting() {
        menuFile.setText(TextSources.MAIN_PAGE_MENU_FILE);
        menuItemNew.setText(TextSources.MAIN_PAGE_MENU_ITEM_NEW);
        menuItemClose.setText(TextSources.MAIN_PAGE_MENU_ITEM_CLOSE);
        menuEdit.setText(TextSources.MAIN_PAGE_MENU_EDIT);
        menuItemUndo.setText(TextSources.MAIN_PAGE_MENU_ITEM_UNDO);
        menuItemRedo.setText(TextSources.MAIN_PAGE_MENU_ITEM_REDO);
        menuProject.setText(TextSources.MAIN_PAGE_MENU_PROJECT);
        menuItemInformation.setText(TextSources.MAIN_PAGE_MENU_ITEM_INFORMATION);

        titledPaneGeneralSettings.setText(TextSources.MAIN_PAGE_TITLED_PANE_GENERAL_SETTINGS);
        titledPaneObjectsPoints.setText(TextSources.MAIN_PAGE_TITLED_PANE_OBJECTS_POINTS);
        titledPaneTextSetting.setText(TextSources.MAIN_PAGE_TITLED_PANE_TEXT_SETTING);
        titledPaneAddingObject.setText(TextSources.MAIN_PAGE_TITLED_PANE_ADDING_OBJECT);
        titledPaneCreatedObjects.setText(TextSources.MAIN_PAGE_TITLED_PANE_CREATED_OBJECTS);

        labelPointSize.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_POINT_SIZE);
        labelInnerPointColor.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_INNER_POINT_COLOR);
        labelOuterPointColor.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_OUTER_POINT_COLOR);
        labelObjectColor.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_OBJECT_COLOR);
        labelObjectHover.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_OBJECT_HOVER_COLOR);
        labelObjectShow.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_OBJECT_SHOW_COLOR);
        labelObjectOpacity.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_OBJECT_OPACITY);
        labelHoverOpacity.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_HOVER_OPACITY);
        labelActiveOpacity.setText(TextSources.MAIN_PAGE_GENERAL_SETTINGS_ACTIVE_OPACITY);

        titledPaneSbSSettingMode.setText(TextSources.MAIN_PAGE_TITLED_PAGE_SBS_SETTING_MODE);
        titledPaneManyPointsSettingMode.setText(TextSources.MAIN_PAGE_TITLED_PAGE_MANY_POINTS_SETTING_MODE);
        titledPaneEnteringPointsSettingMode.setText(TextSources.MAIN_PAGE_TITLED_PAGE_ENTERING_POINTS_SETTING_MODE);

        buttonSbSSettingModeTurnOn.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_ON);
        buttonSbSSettingModeTurnOff.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_OFF);
        labelSbSStatus.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS);
        labelSbSPoints.setText(TextSources.MAIN_PAGE_SBS_SETTING_MODE_LABEL_POINTS);

        buttonManyPointsSettingModeTurnOn.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_ON);
        buttonManyPointsSettingModeTurnOff.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_OFF);
        labelManyPointsStatus.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS);
        labelManyPointsPoints.setText(TextSources.MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_POINTS);

        buttonEnteringPointsAdd.setText(TextSources.MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_ADD);
        buttonEnteringPointsDelete.setText(TextSources.MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_DELETE);

        textFieldTitleText.setText(TextSources.MAIN_PAGE_TEXT_SETTING_TITLE_TEXT);
        textFieldTitleText.setPromptText(TextSources.MAIN_PAGE_TEXT_SETTING_TITLE_TEXT);
        textAreaDescription.setText(TextSources.MAIN_PAGE_TEXT_SETTING_DESCRIPTION);
        textAreaDescription.setPromptText(TextSources.MAIN_PAGE_TEXT_SETTING_DESCRIPTION);

        buttonAddObject.setText(TextSources.MAIN_PAGE_ADDING_OBJECT_BUTTON_ADD);

        tableColumnObjectId.setText(TextSources.MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_OBJECT_ID);
        tableColumnObjectTitle.setText(TextSources.MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_TITLE);
        tableColumnObjectDescription.setText(TextSources.MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_DESCRIPTION);

        tabHTML.setText(TextSources.MAIN_PAGE_TAB_HTML);
        tabCSS.setText(TextSources.MAIN_PAGE_TAB_CSS);
        tabJS.setText(TextSources.MAIN_PAGE_TAB_JS);
        tabBrowser.setText(TextSources.MAIN_PAGE_TAB_BROWSER);
    }

    private void undo() {
        drawBoard.undo();
        pointsListX.remove(pointsListX.size() - 1);
        pointsListY.remove(pointsListX.size() - 1);
    }

    private void redo() {
        drawBoard.redo();
        pointsListX.add(tempX);
        pointsListY.add(tempY);
    }

    private void xySetting(int x, int y) {
        gc = canvas1.getGraphicsContext2D();
        tempX = x;
        tempY = y;
        pointsListX.add(x);
        pointsListY.add(y);
        pointsList.add("X: " + x + " Y: " + y);
        listViewPoints.setItems(pointsList);
        listViewPoints1.setItems(pointsList);
        listViewPoints2.setItems(pointsList);
        listViewPoints.refresh();
        listViewPoints1.refresh();
        listViewPoints2.refresh();
        drawBoard.addDrawOperation(new PointDrawOperation(x - (pointWidthOuter >> 1),
                y - (pointWidthOuter >> 1),
                pointWidthOuter,
                pointWidthOuter,
                colorPointOuter,
                colorPointInner));
    }

    private boolean enteringPointsDataChecking() {
        return Integer.parseInt(textFieldEnteringPointsX.getText()) >= 0
                && Integer.parseInt(textFieldEnteringPointsX.getText()) <= GlobalSources.CANVAS_WIDTH
                && Integer.parseInt(textFieldEnteringPointsY.getText()) >= 0
                && Integer.parseInt(textFieldEnteringPointsY.getText()) <= GlobalSources.CANVAS_HEIGHT;
    }
}