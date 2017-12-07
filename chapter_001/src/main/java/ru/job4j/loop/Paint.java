package ru.job4j.loop;

/**
 * Paint. task "4.4. Построить пирамиду в псевдографике. [#4412]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Paint {
    /**
     * piramid.
     * @param h - высота пирамиды.
     */

    public String piramid(int h) {
        StringBuilder pir = new StringBuilder();
        int width = h + (h - 1);
        int hats = 1;
        int blanks;
        for (int i = 1; i <= h; i++) {
            blanks = (width - hats) / 2;
            if (blanks == 0) {
                for (int j = 1; j <= width; j++) {
                    pir.append("^");
                }
            } else {
                for (int j = 1; j <= blanks; j++) {
                    pir.append(" ");
                }
                for (int j = 1; j <= hats; j++) {
                    pir.append("^");
                }
                for (int j = 1; j <= blanks; j++) {
                    pir.append(" ");
                }
            }
            hats += 2;
            if (i != h) {
                pir.append(System.getProperty("line.separator"));
            }
        }
        return pir.toString();
    }
}
