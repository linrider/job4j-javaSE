package ru.job4j.strategy;
/**
 * Paint.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 05.10.17
 */
public class Paint {
    private Shape shape;

    /**
     * Paint constructor.
     * @param shape - Shape.
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * defineShape.
     * @return String.
     */
    public String defineShape() {

        return shape.pic();
    }
}
