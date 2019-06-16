package ru.job4j.start;
/**
 * StunInput.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$2. Реализовать класс Tracker [#396]
 * @since 24.09.17
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    /**
     * StubInput's constructor.
     * @param answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * ask.
     * @param question - String.
     * @return String.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * ask.
     * @param question -String.
     * @param range - int[].
     * @return int.
     */
    @Override
    public int ask(String question, int[] range) {

        return  Integer.valueOf(this.ask(question));
    }
}
