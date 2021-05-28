/*
 * Class SetImageOperation
 *
 * This is the class, which is created for the command pattern.
 * The current class is made for the image setting.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class SetImageOperation implements DrawOperation {

    private final Image image;
    private final double x;
    private final double y;

    public SetImageOperation(Image image, double x, double y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
}