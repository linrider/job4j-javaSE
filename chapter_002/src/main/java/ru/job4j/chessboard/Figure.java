package ru.job4j.chessboard;

public abstract  class Figure {
    private String name;
    private boolean color;
    public Cell position;
    public int index;

    public Figure(String name, boolean color, Cell position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }
    public abstract Cell[] way(Cell desttination);

    public Figure clone(Cell destination) {
        Cell clonedCell = new Cell(destination.posX, destination.posY);
        this.position = clonedCell;
        return this;
    }


}
