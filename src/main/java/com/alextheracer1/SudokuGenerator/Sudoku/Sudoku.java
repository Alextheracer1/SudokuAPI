package com.alextheracer1.SudokuGenerator.Sudoku;

import java.util.Arrays;

public class Sudoku {

  private int id;
  private int[][] masked;

  public Sudoku(int id, int[][] sudoku) {
    this.id = id;
    this.masked = sudoku;
  }

  public int getId() {
    return id;
  }

  public int[][] getSudoku() {
    return masked;
  }

  public void setSudoku(int[][] sudoku) {
    this.masked = sudoku;
  }

  @Override
  public String toString() {
    return "id:" + id + "sudoku:" + Arrays.toString(masked);
  }
}
