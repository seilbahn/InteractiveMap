/*
 * Class WebPageObject
 *
 * This class contains the variables and the methods for the webpage objects (polygons, points, colors, etc.).
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class WebPageObject {
    private int objectId;
    private final IntegerProperty _id;
    private ArrayList<Integer> coordinatesX;
    private ArrayList<Integer> coordinatesY;
    private String title;
    private final StringProperty _title;
    private String description;
    private final StringProperty _description;
    private String objectColor;
    private String objectActiveColor;
    private String objectHoverColor;
    private String objectOpacity;
    private String objectActiveOpacity;
    private String objectHoverOpacity;
    private Font titleFont;
    private Font descriptionFont;
    private String points;
    private int topPoint;
    private int leftPoint;

    public WebPageObject(int id, ArrayList<Integer> x, ArrayList<Integer> y, String title, String description,
                         String objectColor, String objectActiveColor, String objectHoverColor,
                         String objectOpacity, String objectActiveOpacity, String objectHoverOpacity,
                         Font titleFont, Font descriptionFont) {
        this.objectId = id;
        this._id = new SimpleIntegerProperty(this, "id", id);
        this.coordinatesX = x;
        this.coordinatesY = y;
        this.title = title;
        this._title = new SimpleStringProperty(this, "_title", title);
        this.description = description;
        this._description = new SimpleStringProperty(this, "_description", description);
        this.objectColor = objectColor;
        this.objectActiveColor = objectActiveColor;
        this.objectHoverColor = objectHoverColor;
        this.objectOpacity = objectOpacity;
        this.objectActiveOpacity = objectActiveOpacity;
        this.objectHoverOpacity = objectHoverOpacity;
        this.titleFont = titleFont;
        this.descriptionFont = descriptionFont;
        this.points = getPointsFromLists();
        this.topPoint = getTopPoint(x);
        this.leftPoint = getLeftPoint(y);
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int get_id() {
        return _id.get();
    }

    public void set_id(int _id) {
        this._id.set(_id);
    }

    public ArrayList<Integer> getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(ArrayList<Integer> coordinateX) {
        this.coordinatesX = coordinateX;
    }

    public ArrayList<Integer> getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(ArrayList<Integer> coordinateY) {
        this.coordinatesY = coordinateY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_title() {
        return _title.get();
    }

    public void set_title(String _title) {
        this._title.set(_title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String get_description() {
        return _description.get();
    }

    public void set_description(String _description) {
        this._description.set(_description);
    }

    public String getObjectColor() {
        return objectColor;
    }

    public void setObjectColor(String objectColor) {
        this.objectColor = objectColor;
    }

    public String getObjectActiveColor() {
        return objectActiveColor;
    }

    public void setObjectActiveColor(String objectActiveColor) {
        this.objectActiveColor = objectActiveColor;
    }

    public String getObjectHoverColor() {
        return objectHoverColor;
    }

    public void setObjectHoverColor(String objectHoverColor) {
        this.objectHoverColor = objectHoverColor;
    }

    public String getObjectOpacity() {
        return objectOpacity;
    }

    public void setObjectOpacity(String objectOpacity) {
        this.objectOpacity = objectOpacity;
    }

    public String getObjectActiveOpacity() {
        return objectActiveOpacity;
    }

    public void setObjectActiveOpacity(String objectActiveOpacity) {
        this.objectActiveOpacity = objectActiveOpacity;
    }

    public String getObjectHoverOpacity() {
        return objectHoverOpacity;
    }

    public void setObjectHoverOpacity(String objectHoverOpacity) {
        this.objectHoverOpacity = objectHoverOpacity;
    }

    public Font getTitleFont() {
        return titleFont;
    }

    public void setTitleFont(Font titleFont) {
        this.titleFont = titleFont;
    }

    public Font getDescriptionFont() {
        return descriptionFont;
    }

    public void setDescriptionFont(Font descriptionFont) {
        this.descriptionFont = descriptionFont;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(int topPoint) {
        this.topPoint = topPoint;
    }

    public int getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(int leftPoint) {
        this.leftPoint = leftPoint;
    }

    private String getPointsFromLists() {
        StringBuilder points = new StringBuilder();
        for (int i = 0, j = 0; i < coordinatesX.size(); i++, j++) {
            points.append(coordinatesX.get(i)).append(",").append(coordinatesY.get(i));
            if (j != coordinatesX.size() - 1) {
                points.append(" ");
            }
        }
        return points.toString();
    }

    private int getTopPoint(ArrayList<Integer> coordinatesX) {
        int a = 0;
        for (Integer x : coordinatesX) {
            a += x;
        }
        a /= coordinatesX.size();
        return a;
    }

    private int getLeftPoint(ArrayList<Integer> coordinatesY) {
        int a = 0;
        for (Integer x : coordinatesY) {
            a += x;
        }
        a /= coordinatesY.size();
        return a;
    }
}