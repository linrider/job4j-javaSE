package ru.job4j.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufReaderExample {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any symbol. q - for exit.");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
