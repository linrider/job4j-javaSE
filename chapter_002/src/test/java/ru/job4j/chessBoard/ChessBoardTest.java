package ru.job4j.chessBoard;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChessBoardTest {
    @Test
    public void WhenBishopMoveOnFreeBoard() throws OccupiedWayException {
        Board chessBoard = new Board();
        Bishop whiteBishop = new Bishop(true, 2, 1);
        chessBoard.addFigure(whiteBishop);
        boolean result = chessBoard.move(4, 3, whiteBishop);
        assertThat(result, is(true));

    }

}
