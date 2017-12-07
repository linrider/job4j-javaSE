package ru.job4j.chessboard;

public class Board {
    public Figure[] figures = new Figure[32];
    private  int index = 0;

    public void  addFigure(Figure figure) {
        figure.index = index;
        figures[index++] = figure;

    }

    public boolean move(Cell source, Cell destination) throws OccupiedWayException, FigureNotFoundException {
        boolean invalid = false;
        Figure currentFigure = null;
        for (Figure figure : figures) {
            if (source.equals(figure.position)) {
                currentFigure = figure;
            }
        }
        if (currentFigure == null) {
            throw new FigureNotFoundException("Figure doesn't exist!");
        } else {

            for (Cell step : currentFigure.way(destination)) {
                for (Figure figure : figures) {
                    if (step.equals(figure.position)) {
                        throw new OccupiedWayException("This figure's way is occupied!");
                    } else {
                        invalid = true;
                        figure.clone(destination);
                    }
                }
            }
        }
        return invalid;
    }

}
