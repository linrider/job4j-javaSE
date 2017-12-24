package ru.job4j.chessboard;

public class Board {
    public Figure[][] figures = new Figure[8][8];

    public void addFigure(Figure figure) {
        figures[figure.position.posX][figure.position.posY] = figure;
    }
    public boolean move(Cell source, Cell destination) throws OccupiedWayException, FigureNotFoundException, CloneNotSupportedException {

        if (figures[source.posX][source.posY] == null) {
            throw new FigureNotFoundException("Figure doesn't exist!");
        }

        Cell[] figureWay = figures[source.posX][source.posY].way(destination);
        for (Cell step : figureWay) {
            if (figures[step.posX][step.posY] != null) throw new OccupiedWayException("This figure's way is occupied!");
        }

        figures[destination.posX][destination.posY].copy(destination);
        figures[source.posX][source.posY] = null;
        return true;
    }

}
