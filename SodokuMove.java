
/**
 * An object representing a single digit placement while solving a SodokuPuzzle
 *
 * @author Aidan Schraeder
 * @version 11/4/19
 */
public class SodokuMove 
{
    private int row;
    private int column;
    private int digit;

    /**
     * Constructs the row, column and digit given to it by the find first blank.
     */
    public SodokuMove(int row, int column, int digit)
    {
        this.row = row;
        this.column = column;
        this.digit = digit;
    }
    
    /**
     * Method getRow
     * Gets the row from SodokuMove
     *
     * @return A row
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Method getColumn
     * 
     *
     * @return A column
     */
    public int getColumn()
    {
        return column;
    }
    
    /**
     * Method getDigit
     * Gets the digit given representing a move
     *
     * @return A digit 
     */
    public int getDigit()
    {
        return digit;
    }
    
    /**
     * Method setDigit
     * Sets the digit to the integer given
     *
     * @param num The new digit that you want to set
     */
    public void setDigit(int num)
    {
        digit = num; 
    }
}
