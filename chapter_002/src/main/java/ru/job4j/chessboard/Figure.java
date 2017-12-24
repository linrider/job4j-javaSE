package ru.job4j.chessboard;

public abstract  class Figure {
    public final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell destination) throws ImpossibleMoveException;

    public abstract Figure copy(Cell destination);


}
