package arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                {{'1','2','.','.','3','.','.','.','.'},
                        {'4','.','.','5','.','.','.','.','.'},
                        {'.','9','8','.','.','.','.','.','3'},
                        {'5','.','.','.','6','.','.','.','4'},
                        {'.','.','.','8','.','3','.','.','5'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','.','.','.','.','.','2','.','.'},
                        {'.','.','.','4','1','9','.','.','8'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Resultado: " + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet filas;
        HashSet columnas;
        HashSet<Character>[] cuadros = new HashSet[9];
        int numeroCuadro;

        for (int i = 0; i < 9; i++) {
            cuadros[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            filas = new HashSet();
            columnas = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //Valido la fila
                    if (filas.contains(board[i][j])) {
                        return false;
                    } else {
                        filas.add(board[i][j]);
                    }

                    //Valido el cuadro
                    numeroCuadro = (i/ 3) * 3 + (j/ 3);
                    if(cuadros[numeroCuadro].contains(board[i][j])) {
                        return false;
                    } else {
                        cuadros[numeroCuadro].add(board[i][j]);
                    }
                }

                //Valido columna
                if(board[j][i] != '.') {
                    if(columnas.contains(board[j][i])) {
                        return false;
                    } else {
                        columnas.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }
}
