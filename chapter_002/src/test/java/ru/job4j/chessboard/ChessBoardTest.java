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
    public void whenBishopMoveOnFreeBoard() throws OccupiedWayException, CloneNotSupportedException {
        Board chessBoard = new Board();
        Cell source = new Cell(2, 1);
        Cell dest = new Cell(4, 3);
        Bishop whiteBishop = new Bishop(source);
        chessBoard.addFigure(whiteBishop);

        boolean result = chessBoard.move(source, dest);
        assertThat(result, is(true));

    }

}
