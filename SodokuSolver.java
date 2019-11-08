import java.util.Deque;
import java.util.LinkedList;
/**
 * An object that is given a SodokuPuzzle. Has a solver that use functions from 
 * SodokuPuzzle to solve the SodokuPuzzle.
 *
 * @author Aidan Schraeder
 * @version 11/4/19
 */
public class SodokuSolver
{
    Deque<SodokuMove> deque = new LinkedList<SodokuMove>();
    private SodokuPuzzle p;
    private SodokuMove move;
    /**
     * 
     * Constructor for objects of class SodokuSolver
     * Takes in a SodokuPuzzle as a parameter.
     */

    public SodokuSolver(SodokuPuzzle p)
    {
        this.p = p;
    }

    /**
     * Method solve
     * Solves the puzzle by moving through the puzzle and backtracking when needed.
     *
     */
    public void solve()
    {
        int startPoint = 1;
        while (p.findFirstBlank() != null)
        {
            move = p.findFirstBlank();
            while(nextMove(startPoint))
            {
                startPoint = 1; 
            }
            if (move == null)
            {
                break;
            }
            SodokuMove temp = deque.pop();
            p.erase(temp);
            startPoint = (temp.getDigit() + 1);
        }

    }

    /**
     * Method nextMove
     * Helper method for Solve method 
     * 
     * @param start A parameter
     * @return false if no move is available, true if there was a move made
     */
    private boolean nextMove(int start)
    {
        move = p.findFirstBlank();
        if (move == null)
        {
            return false;
        }
        else
        {
            for (int i = start; i <= p.NUMROWS; i++)
            {
                move.setDigit(i);
                if (p.isLegal(move))
                {
                    deque.push(move);
                    p.makeMove(move);
                    return true;
                }
            }
        }
        return false;
    }
}
