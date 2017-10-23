package ru.job4j.chessBoard;

public interface Movable {
    Cell move(Cell oldPosition, Cell newPosition);
}
