package com.alextheracer1.SudokuGenerator.API;

import com.alextheracer1.SudokuGenerator.Sudoku.Generator;
import com.alextheracer1.SudokuGenerator.Sudoku.Grid;
import com.alextheracer1.SudokuGenerator.Sudoku.Sudoku;
import com.alextheracer1.SudokuGenerator.Sudoku.Sudokus;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SudokuController {

  private final Gson gson = new Gson();
  private int count = 0;


  @GetMapping("/greeting")
  public String controllerTest() {
    return "Hellorld!";
  }

  @GetMapping("/randomSudokus")
  public String randomSudokus() {

    Generator g = new Generator();
    Grid grid;

    Sudokus sudokus = null;
    int limit = 10000;

    ArrayList<Sudoku> sudokusList = new ArrayList<>();

    for (int i = 0; i < limit; i++) {

      grid = g.generate(75);

      int[][] solvedGrid = new int[9][9];
      for (int j = 0; j < 9; j++) {
        for (int k = 0; k < 9; k++) {
          solvedGrid[j][k] = grid.getCell(j, k).getValue();
        }
      }

      Sudoku sudoku = new Sudoku(count, solvedGrid);

      sudokusList.add(sudoku);

      count++;

    }

    sudokus = new Sudokus(sudokusList);

    return gson.toJson(sudokus.getSudokuList());
  }

  @GetMapping("/randomSudoku")
  public String randomSudoku() {

    Generator g = new Generator();
    Grid grid = g.generate(70);

    count++;

    int[][] solvedGrid = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        solvedGrid[i][j] = grid.getCell(i, j).getValue();
      }
    }

    Sudoku sudoku = new Sudoku(count, solvedGrid);

    String json = gson.toJson(sudoku);

    return json;

  }

}
