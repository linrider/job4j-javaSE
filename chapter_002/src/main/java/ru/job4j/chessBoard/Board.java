package ru.job4j.chessBoard;

public class Board {
    public Figure[] figures = new Figure[32];
    private  int position = 0;

    public void  addFigure(Figure figure) {
        figures[position++] = figure;
    }

    boolean move(Cell source, Cell destination) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        
        return false;
    }

}
