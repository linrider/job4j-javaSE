package ru.job4j.iteratorofiterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Converter for task "5.1.4. Создать convert(Iterator<Iterator>)".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 07.05.18
 */
public class Converter {

    /**
     * @param its - Iterator<Iterator<Integer>>.
     * @return Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            private Iterator<Integer> current  = its.next();

            /**
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                boolean result = current.hasNext();
                if (!result) {
                    while (its.hasNext()) {
                        current = its.next();
                        result = current.hasNext();
                        if (result) {
                            break;
                        }
                    }
                }
                return result;
            }

            /**
             * @return Integer.
             */
            @Override
            public Integer next() {
                if (!current.hasNext()) {
                    if (its.hasNext()) {
                        current = its.next();
                    } else  {
                        throw  new NoSuchElementException();
                    }
                }

                return current.next();
            }
        };
    }
}