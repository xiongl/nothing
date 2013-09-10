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
        Set fullSet = new HashSet<Character>();
        for (int i=1; i<=9; i++) {
            fullSet.add(String.valueOf(i).charAt(0));
        }
        for (int i=0; i<9; i++) {
            char[] row = board[i];
            if (row==null || row.length!=9)
                return false;
            Set set = new HashSet(fullSet);
            for (int j=0; j<9; j++) {
                if (row[j]!='.' && !set.remove(row[j]))
                    return false;
            }
        }
        for (int j=0; j<9; j++) {
            Set set = new HashSet(fullSet);
            for (int i=0; i<9; i++) {
                if (board[i][j]!='.' && !set.remove(board[i][j]))
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
        String[] strings = new String[]{"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};

        char[][] board = new char[9][9];
        for (int i=0; i<9; i++) {
            String str = strings[i];
            for (int j=0; j<9; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        new ValidSukodu().isValidSudoku(board);
    }
}

