package ru.job4j.chessboard;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessBoardTest {
    /**
     * whenBishopMoveOnFreeBoard.
     * @throws OccupiedWayException
     */
    @Test
    public void whenBishopMoveOnFreeBoard() throws OccupiedWayException {
        Board chessBoard = new Board();
        Cell source = new Cell(2, 1);
        Cell dest = new Cell(4, 3);
        Bishop whiteBishop = new Bishop(source);
        chessBoard.addFigure(whiteBishop);

        boolean result = false;
        try {
            result = chessBoard.move(source, dest);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assertThat(result, is(true));

    }

}
