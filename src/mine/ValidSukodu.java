package mine;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/2/13
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValidSukodu {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(board==null || board.length!=9)
            return false;
        Set fullSet = new HashSet();
        for (int i=1; i<=9; i++) {
            fullSet.add(i);
        }
        for (int i=0; i<9; i++) {
            char[] row = board[i];
            if (row==null || row.length!=9)
                return false;
            Set set = new HashSet(fullSet);
            for (int j=0; j<9; j++) {
                if (row[j]!='.' && !set.remove(j))
                    return false;
            }
        }
        for (int j=0; j<9; j++) {
            Set set = new HashSet(fullSet);
            for (int i=0; i<9; i++) {
                if (board[j][i]!='.' && !set.remove(board[j][i]))
                    return false;
            }
        }

        for (int m=0; m<3; m++) {
            for (int n=0; n<3; n++) {
                Set set = new HashSet(fullSet);
                for (int p=0; p<3; p++) {
                    for (int q=0; q<3; q++) {
                        char ch = board[p+3*m][q+3*n];
                        if(ch!='.' && !set.remove(ch))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                board[i][j] = '.';
            }
        }
        new ValidSukodu().isValidSudoku(board);
    }
}

