package ru.job4j.strategy;
/**
 * Triangle.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 05.10.17
 */
public class Triangle implements Shape {

    /**
     * pic.
     * @return String.
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append(System.getProperty("line.separator"));
        pic.append("  + +  ");
        pic.append(System.getProperty("line.separator"));
        pic.append(" +   + ");
        pic.append(System.getProperty("line.separator"));
        pic.append("+++++++");
        return pic.toString();
    }
}
