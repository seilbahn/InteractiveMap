/*
 * Class PointDrawOperation
 *
 * This is the class, which is created for the command pattern.
 * The current class is made for the point drawing.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

class PointDrawOperation implements DrawOperation {

    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private final Paint stroke;
    private final Paint stroke2;

    public PointDrawOperation(double x, double y, double width, double height, Paint stroke, Paint stroke2) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.stroke = stroke;
        this.stroke2 = stroke2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(stroke);
        gc.fillOval(x, y, width, height);
        gc.setFill(stroke2);
        gc.fillOval(x + 0.125 * width, y + 0.125 * height, width * 0.75, height * 0.75);
    }
}