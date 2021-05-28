/*
 * Interface DrawOperation
 *
 * This is the interface, which is created for the command pattern.
 *
 * @version 1.0 May 02, 2021
 * @author Seilbahn
 */
package base;

import javafx.scene.canvas.GraphicsContext;

public interface DrawOperation {
    void draw(GraphicsContext gc);
}