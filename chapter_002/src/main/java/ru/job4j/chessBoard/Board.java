package ru.job4j.chessBoard;

public class Board {
    public Figure[] figures = new Figure[32];
    private  int index = 0;

    public void  addFigure(Figure figure) {
        figure.index = index;
        figures[index++] = figure;

    }

    public boolean move(int posX, int posY, Figure figure) throws OccupiedWayException, FigureNotFoundException {
        Cell destination = new Cell(posX, posY);
        boolean invalid = false;
        if (figure.position.posX != figures[figure.index].position.posX &&
                figure.position.posY != figures[figure.index].position.posY) {
            throw new FigureNotFoundException("Figure doesn't exist");
        }
        else {
            for (Cell step : figure.way(destination)) {
                for (Figure cell : figures) {
                    if (step.posX == cell.position.posX && step.posY == cell.position.posY) {
                        throw new OccupiedWayException("This figure's way is occupied!");
                    } else {
                        invalid = true;
                        figures[figure.index].position = destination;
                    }
                }
            }
        }
        return invalid;
    }

}
