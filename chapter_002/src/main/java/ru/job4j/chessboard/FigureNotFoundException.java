package ru.job4j.chessboard;

public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
