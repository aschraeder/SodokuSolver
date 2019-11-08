import java.util.Scanner;
import java.io.File;
/**
 * Reads in file of a Sodoku game and constructs a board. This class holds the board at all
 * stages of the game being played
 *
 * @author Aidan Schraeder
 * @version 11/4/19
 */
public class SodokuPuzzle
{
    public final int NUMROWS = 9; //number of rows in the board
    public final int NUMCOLUMNS = 9; //number of columns in the board
    private int[][] nums = new int[NUMROWS][NUMCOLUMNS];
    Scanner scan;

    /**
     * Reads in a file and constructs a Sodoku board 
     */
    public SodokuPuzzle(String filename)
    {
        try
        {
            scan = new Scanner(new File(filename));
            for (int i = 0; i < NUMROWS; i++)
            {
                for (int j = 0; j < NUMCOLUMNS; j++)
                {
                    int value = scan.nextInt();
                    nums[i][j] = value;
                }
            }
            scan.close(); 
        }
        catch (Exception e)
        {
            System.out.println("File not Found. Try Again.");
        }
    }

    /**
     * Method findFirstBlank
     * Scans the puzzle row by row to find the first blank
     *
     * @return SodokuMove that contains the row column and a digit
     */
    public SodokuMove findFirstBlank()
    {
        for (int i = 0; i < NUMROWS; i++)
        {
            for (int j = 0; j < NUMCOLUMNS; j++)
            {
                if (nums[i][j] == 0)
                {
                    return new SodokuMove(i,j, 0);
                }
            }
        }
        return null;
    }

    /**
     * Method isLegal
     *
     * Checks to see if the move given is allowed by the rules of Sodoku
     * 
     * @param move A SodokuMove consisting of row column and move
     * @return False is illegal, True if legal
     */
    public boolean isLegal(SodokuMove move)
    {
        int gridRow = (move.getRow()/ 3) * 3;
        int gridColumn = (move.getColumn()/3) * 3;
        for (int i = gridRow; i < (gridRow + 3); i++)
        {
            for (int j = gridColumn; j < (gridColumn + 3); j++)
            {
                if (nums[i][j] == move.getDigit())
                {
                    return false;
                }
            }
        }

        for (int i = 0; i < NUMROWS; i++)
        {
            if (nums[i][move.getColumn()] == move.getDigit())
            {
                return false;
            }
        }

        for (int i = 0; i < NUMCOLUMNS; i++)
        {
            if (nums[move.getRow()][i] == move.getDigit())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method makeMove
     * Changes the digit for the given row and column
     *
     * @param move A SodokuMove that consists of a row column and digit
     */
    public void makeMove(SodokuMove move)
    {
        nums[move.getRow()][move.getColumn()] = move.getDigit();
    }

    /**
     * Method erase
     * Used to remove a move that might have worked before but now does not work anymore
     *
     * @param move A SodokuMove for the row and column but replaces the digit with 0
     */
    public void erase(SodokuMove move)
    {
        nums[move.getRow()][move.getColumn()] = 0;
    }

    /**
     * Method equals
     * Checks to see if two Sodoku Puzzles contain the exact same numbers
     *
     * @param obj A SodokuPuzzle to compare
     * @return True if same, false if not
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof SodokuPuzzle)
        {
            SodokuPuzzle puzzle = (SodokuPuzzle)obj;
            for (int i = 0; i < NUMROWS; i++)
            {
                for (int j = 0; j < NUMCOLUMNS; j++)
                {
                    if (nums[i][j] != puzzle.nums[i][j])
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String s = "";
        for (int i = 0; i < NUMROWS; i++)
        {
            for (int j = 0; j < NUMCOLUMNS; j++)
            {
                int value = nums[i][j];
                if (value == 0)
                {
                    s += "_ ";
                }
                else
                {
                    s += value + " ";
                }
            }
            s += "\n";
        }
        return s;
    }
}
