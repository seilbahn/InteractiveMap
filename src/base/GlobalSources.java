/*
 * Class GlobalSources
 *
 * This class contains intel about the global settings of this application.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javax.swing.JFileChooser;

public class GlobalSources {
    public static String CURRENT_LANGUAGE = "English";
    public static String CURRENT_PATH = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\project4";
    public static String CURRENT_IMAGE_PATH = "file:///" + CURRENT_PATH.replace("\\", "/") + "/image.png";
    public static int CANVAS_WIDTH = 800;
    public static int CANVAS_HEIGHT = 600;
}