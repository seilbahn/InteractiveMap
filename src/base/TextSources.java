/*
 * Class TextSources
 *
 * This is the class for the element's titles.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

public class TextSources {
    // There are below texts for the file StartPage.fxml
    public static String START_PAGE_TITLE;
    public static String START_PAGE_DIALOG_CHOOSER;
    public static String START_PAGE_ALERT_ERROR_TITLE;
    public static String START_PAGE_ALERT_ERROR_CONTENT_TEXT;
    public static String START_PAGE_BUTTON;
    public static String START_PAGE_BUTTON_BEGIN;
    public static String START_PAGE_BUTTON_ADD;
    public static String START_PAGE_MENU_SETTINGS;
    public static String START_PAGE_MENU_LANGUAGE;
    public static String START_PAGE_RADIO_MENU_LANGUAGE_EN;
    public static String START_PAGE_RADIO_MENU_LANGUAGE_RU;
    public static String START_PAGE_TEXT_FIELD;

    // There are below text for the file SampleProjectPageController.fxml
    public static String SAMPLE_PROJECT_PAGE_TITLE;
    public static String SAMPLE_PROJECT_BUTTON_BEGIN;
    public static String SAMPLE_PROJECT_BUTTON_ADD;
    public static String SAMPLE_PROJECT_TEXT_FIELD;

    // There are below text for the file MainPageController.fxml
    public static String MAIN_PAGE_TITLE;
    public static String MAIN_PAGE_MENU_FILE;
    public static String MAIN_PAGE_MENU_EDIT;
    public static String MAIN_PAGE_MENU_PROJECT;
    public static String MAIN_PAGE_MENU_ITEM_NEW;
    public static String MAIN_PAGE_MENU_ITEM_CLOSE;
    public static String MAIN_PAGE_MENU_ITEM_UNDO;
    public static String MAIN_PAGE_MENU_ITEM_REDO;
    public static String MAIN_PAGE_MENU_ITEM_INFORMATION;
    public static String MAIN_PAGE_TITLED_PANE_GENERAL_SETTINGS;
    public static String MAIN_PAGE_TITLED_PANE_OBJECTS_POINTS;
    public static String MAIN_PAGE_TITLED_PANE_TEXT_SETTING;
    public static String MAIN_PAGE_TITLED_PANE_ADDING_OBJECT;
    public static String MAIN_PAGE_TITLED_PANE_CREATED_OBJECTS;
    public static String MAIN_PAGE_GENERAL_SETTINGS_POINT_SIZE;
    public static String MAIN_PAGE_GENERAL_SETTINGS_INNER_POINT_COLOR;
    public static String MAIN_PAGE_GENERAL_SETTINGS_OUTER_POINT_COLOR;
    public static String MAIN_PAGE_GENERAL_SETTINGS_OBJECT_COLOR;
    public static String MAIN_PAGE_GENERAL_SETTINGS_OBJECT_HOVER_COLOR;
    public static String MAIN_PAGE_GENERAL_SETTINGS_OBJECT_SHOW_COLOR;
    public static String MAIN_PAGE_GENERAL_SETTINGS_OBJECT_OPACITY;
    public static String MAIN_PAGE_GENERAL_SETTINGS_HOVER_OPACITY;
    public static String MAIN_PAGE_GENERAL_SETTINGS_ACTIVE_OPACITY;
    public static String MAIN_PAGE_TITLED_PAGE_SBS_SETTING_MODE;
    public static String MAIN_PAGE_TITLED_PAGE_MANY_POINTS_SETTING_MODE;
    public static String MAIN_PAGE_TITLED_PAGE_ENTERING_POINTS_SETTING_MODE;
    public static String MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_ON;
    public static String MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_OFF;
    public static String MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS;
    public static String MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_ON;
    public static String MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_OFF;
    public static String MAIN_PAGE_SBS_SETTING_MODE_LABEL_POINTS;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_ON;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_OFF;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_ON;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_OFF;
    public static String MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_POINTS;
    public static String MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_ADD;
    public static String MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_DELETE;
    public static String MAIN_PAGE_TEXT_SETTING_TITLE_TEXT;
    public static String MAIN_PAGE_TEXT_SETTING_DESCRIPTION;
    public static String MAIN_PAGE_ADDING_OBJECT_BUTTON_ADD;
    public static String MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_OBJECT_ID;
    public static String MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_TITLE;
    public static String MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_DESCRIPTION;
    public static String MAIN_PAGE_TAB_HTML;
    public static String MAIN_PAGE_TAB_CSS;
    public static String MAIN_PAGE_TAB_JS;
    public static String MAIN_PAGE_TAB_BROWSER;


    //There are below text for the file InformationPageController.fxml
    public static String INFORMATION_PAGE_TITLE;


    TextSources(String language) {
        switch (language) {
            case "Russian":
                START_PAGE_TITLE = "Выберите директорию проекта";
                START_PAGE_DIALOG_CHOOSER = "Выберите директорию проекта";
                START_PAGE_ALERT_ERROR_TITLE = "Ошибка!";
                START_PAGE_ALERT_ERROR_CONTENT_TEXT = "Вам следует выбрать директорию проекта";
                START_PAGE_BUTTON = "...";
                START_PAGE_BUTTON_BEGIN = "Следующий шаг";
                START_PAGE_BUTTON_ADD = "+";
                START_PAGE_MENU_SETTINGS = "Настройки";
                START_PAGE_MENU_LANGUAGE = "Язык";
                START_PAGE_RADIO_MENU_LANGUAGE_EN = "По умолчанию (Английский)";
                START_PAGE_RADIO_MENU_LANGUAGE_RU = "Русский";
                START_PAGE_TEXT_FIELD = "Директория проекта";

                SAMPLE_PROJECT_PAGE_TITLE = "Выберите изображение";
                SAMPLE_PROJECT_BUTTON_BEGIN = "Начать работу";
                SAMPLE_PROJECT_BUTTON_ADD = "...";
                SAMPLE_PROJECT_TEXT_FIELD = "Путь к изображению";

                MAIN_PAGE_TITLE = "Проект: ";
                MAIN_PAGE_MENU_FILE = "Файл";
                MAIN_PAGE_MENU_EDIT = "Редактировать";
                MAIN_PAGE_MENU_PROJECT = "Проект";
                MAIN_PAGE_MENU_ITEM_NEW = "Новый проект";
                MAIN_PAGE_MENU_ITEM_CLOSE = "Закрыть приложение";
                MAIN_PAGE_MENU_ITEM_UNDO = "Отменить операцию (Ctrl + Z)";
                MAIN_PAGE_MENU_ITEM_REDO = "Вернуть операцию (Ctrl + Y)";
                MAIN_PAGE_MENU_ITEM_INFORMATION = "Информация";
                MAIN_PAGE_TITLED_PANE_GENERAL_SETTINGS = "Общие настройки";
                MAIN_PAGE_TITLED_PANE_OBJECTS_POINTS = "Точки объекта";
                MAIN_PAGE_TITLED_PANE_TEXT_SETTING = "Задание текстов";
                MAIN_PAGE_TITLED_PANE_ADDING_OBJECT = "Добавление объекта";
                MAIN_PAGE_TITLED_PANE_CREATED_OBJECTS = "Созданные объекты";
                MAIN_PAGE_GENERAL_SETTINGS_POINT_SIZE = "Размер точки";
                MAIN_PAGE_GENERAL_SETTINGS_INNER_POINT_COLOR = "Внутренний цвет";
                MAIN_PAGE_GENERAL_SETTINGS_OUTER_POINT_COLOR = "Внешний цвет";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_COLOR = "Цвет объекта";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_HOVER_COLOR = "Объект (показ)";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_SHOW_COLOR = "Объект (при наведении)";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_OPACITY = "Прозрачность объекта";
                MAIN_PAGE_GENERAL_SETTINGS_HOVER_OPACITY = "Прозрачность при наведении";
                MAIN_PAGE_GENERAL_SETTINGS_ACTIVE_OPACITY = "Прозрачность (показ)";
                MAIN_PAGE_TITLED_PAGE_SBS_SETTING_MODE = "Пошаговый режим ввода точек";
                MAIN_PAGE_TITLED_PAGE_MANY_POINTS_SETTING_MODE = "Свободный режим ввода точек";
                MAIN_PAGE_TITLED_PAGE_ENTERING_POINTS_SETTING_MODE = "Ввод точек";
                MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_ON = "Вкл.";
                MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_OFF = "Откл.";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS = "Статус:";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_ON = "Статус: вкл.";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_OFF = "Статус: откл.";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_POINTS = "Точки:";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_ON = "Вкл. (Ctrl + Q)";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_OFF = "Откл. (Ctrl + W)";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS = "Статус:";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_ON = "Статус: вкл.";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_OFF = "Статус: откл.";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_POINTS = "Точки:";
                MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_ADD = "Добавить точку";
                MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_DELETE = "Удалить предыдущую";
                MAIN_PAGE_TEXT_SETTING_TITLE_TEXT = "Заголовок";
                MAIN_PAGE_TEXT_SETTING_DESCRIPTION = "Описание";
                MAIN_PAGE_ADDING_OBJECT_BUTTON_ADD = "Добавить";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_OBJECT_ID = "Номер объекта";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_TITLE = "Заголовок";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_DESCRIPTION = "Описание";
                MAIN_PAGE_TAB_HTML = "HTML";
                MAIN_PAGE_TAB_CSS = "CSS";
                MAIN_PAGE_TAB_JS = "JS";
                MAIN_PAGE_TAB_BROWSER = "Браузер";

                INFORMATION_PAGE_TITLE = "Данные о проекте";
                break;
            case "English":
            default:
                START_PAGE_TITLE = "Choose the directory path";
                START_PAGE_DIALOG_CHOOSER = "Choose the directory path for the project";
                START_PAGE_ALERT_ERROR_TITLE = "Error!";
                START_PAGE_ALERT_ERROR_CONTENT_TEXT = "You should choose the directory path";
                START_PAGE_BUTTON = "...";
                START_PAGE_BUTTON_BEGIN = "Next step";
                START_PAGE_BUTTON_ADD = "+";
                START_PAGE_MENU_SETTINGS = "Settings";
                START_PAGE_MENU_LANGUAGE = "Language";
                START_PAGE_RADIO_MENU_LANGUAGE_EN = "Default (English)";
                START_PAGE_RADIO_MENU_LANGUAGE_RU = "Russian";
                START_PAGE_TEXT_FIELD = "Directory path";

                SAMPLE_PROJECT_PAGE_TITLE = "Choose the image";
                SAMPLE_PROJECT_BUTTON_BEGIN = "Begin";
                SAMPLE_PROJECT_BUTTON_ADD = "...";
                SAMPLE_PROJECT_TEXT_FIELD = "Image path";

                MAIN_PAGE_TITLE = "Project: ";
                MAIN_PAGE_MENU_FILE = "File";
                MAIN_PAGE_MENU_EDIT = "Edit";
                MAIN_PAGE_MENU_PROJECT = "Project";
                MAIN_PAGE_MENU_ITEM_NEW = "New project";
                MAIN_PAGE_MENU_ITEM_CLOSE = "Close application";
                MAIN_PAGE_MENU_ITEM_UNDO = "Undo (Ctrl + Z)";
                MAIN_PAGE_MENU_ITEM_REDO = "Redo (Ctrl + Y)";
                MAIN_PAGE_MENU_ITEM_INFORMATION = "Information";
                MAIN_PAGE_TITLED_PANE_GENERAL_SETTINGS = "General settings";
                MAIN_PAGE_TITLED_PANE_OBJECTS_POINTS = "Objects points setting";
                MAIN_PAGE_TITLED_PANE_TEXT_SETTING = "Text setting";
                MAIN_PAGE_TITLED_PANE_ADDING_OBJECT = "Adding object";
                MAIN_PAGE_TITLED_PANE_CREATED_OBJECTS = "Created objects";
                MAIN_PAGE_GENERAL_SETTINGS_POINT_SIZE = "Point size";
                MAIN_PAGE_GENERAL_SETTINGS_INNER_POINT_COLOR = "Inner point color";
                MAIN_PAGE_GENERAL_SETTINGS_OUTER_POINT_COLOR = "Outer point color";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_COLOR = "Object color";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_HOVER_COLOR = "Object (hover)";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_SHOW_COLOR = "Object (show)";
                MAIN_PAGE_GENERAL_SETTINGS_OBJECT_OPACITY = "Object opacity";
                MAIN_PAGE_GENERAL_SETTINGS_HOVER_OPACITY = "Hover opacity";
                MAIN_PAGE_GENERAL_SETTINGS_ACTIVE_OPACITY = "Active opacity";
                MAIN_PAGE_TITLED_PAGE_SBS_SETTING_MODE = "Step by step setting mode";
                MAIN_PAGE_TITLED_PAGE_MANY_POINTS_SETTING_MODE = "Many points setting mode";
                MAIN_PAGE_TITLED_PAGE_ENTERING_POINTS_SETTING_MODE = "Entering points setting mode";
                MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_ON = "Turn on";
                MAIN_PAGE_SBS_SETTING_MODE_BUTTON_TURN_OFF = "Turn off";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS = "Status:";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_ON = "Status: ON";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_STATUS_OFF = "Статус: OFF";
                MAIN_PAGE_SBS_SETTING_MODE_LABEL_POINTS = "Points:";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_ON = "Turn on (Ctrl + Q)";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_TURN_OFF = "Turn off (Ctrl + W)";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS = "Status:";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_ON = "Status: ON";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_STATUS_OFF = "Status: OFF";
                MAIN_PAGE_MANY_POINTS_SETTING_MODE_BUTTON_LABEL_POINTS = "Points:";
                MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_ADD = "Add point";
                MAIN_PAGE_ENTERING_POINTS_SETTING_MODE_BUTTON_DELETE = "Delete previous";
                MAIN_PAGE_TEXT_SETTING_TITLE_TEXT = "Title";
                MAIN_PAGE_TEXT_SETTING_DESCRIPTION = "Description";
                MAIN_PAGE_ADDING_OBJECT_BUTTON_ADD = "Add object";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_OBJECT_ID = "Object's id";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_TITLE = "Title";
                MAIN_PAGE_CREATED_OBJECTS_TABLE_COLUMN_DESCRIPTION = "Description";
                MAIN_PAGE_TAB_HTML = "HTML";
                MAIN_PAGE_TAB_CSS = "CSS";
                MAIN_PAGE_TAB_JS = "JS";
                MAIN_PAGE_TAB_BROWSER = "Browser";

                INFORMATION_PAGE_TITLE = "Project information";
                break;
        }
    }
}
