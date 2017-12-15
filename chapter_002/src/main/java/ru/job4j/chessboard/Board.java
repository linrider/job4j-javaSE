package ru.job4j.chessboard;

public class Board {
    public Figure[][] figures = new Figure[8][8];

    public boolean move(Cell source, Cell destination) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean invalid = false;

        if (figures[source.posX][source.posY] == null) {
            throw new FigureNotFoundException("Figure doesn't exist!");
        }

        Cell[] figureWay = figures[source.posX][source.posY].way(destination);
        for (Figure[] x : figures) {
            for (Figure y : x) {

            }
        }
//        Figure currentFigure = null;
//        for (Figure figure : figures) {
//            if (source.equals(figure.position)) {
//                currentFigure = figure;
//            }
//        }
//        if (currentFigure == null) {
//            throw new FigureNotFoundException("Figure doesn't exist!");
//        } else {
//
//            for (Cell step : currentFigure.way(destination)) {
//                for (Figure figure : figures) {
//                    if (step.equals(figure.position)) {
//                        throw new OccupiedWayException("This figure's way is occupied!");
//                    } else {
//                        invalid = true;
//                        figure.clone(destination);
//                    }
//                }
//            }
//        }
        return invalid;
    }

}
