/*
 * Class EllipseDrawOperation
 *
 * This is the class, which is created for the command pattern.
 * The current class is made for the ellipse drawing.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

class EllipseDrawOperation implements DrawOperation {

    private final double minX;
    private final double minY;
    private final double width;
    private final double height;
    private final Paint stroke;

    public EllipseDrawOperation(double minX, double minY, double width, double height, Paint stroke) {
        this.minX = minX;
        this.minY = minY;
        this.width = width;
        this.height = height;
        this.stroke = stroke;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(stroke);
        gc.strokeOval(minX, minY, width, height);
    }
}