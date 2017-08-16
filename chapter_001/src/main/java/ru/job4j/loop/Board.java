package ru.job4j.loop;

/**
 * Board.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    public String paint(int width, int height) {
        StringBuilder board = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) board.append("x");
                else board.append(" ");
            }
            board.append(System.getProperty("line.separator"));
        }
        return board.toString();
    }
}
