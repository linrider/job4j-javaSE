package ru.job4j.chessBoard;

public abstract  class Figure {
    private String name;
    private boolean color;
    public Cell position;

    public Figure(String name, boolean color, Cell position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }
    public abstract Cell[] way(Cell desttination);


}
