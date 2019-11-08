import java.util.Scanner;
/**
 * 
 * Container for the main method. This
 *
 * @author Aidan Schraeder
 * @version 11/4/19
 */
public class SodokuTest
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter filename of puzzle to solve:");
        String file = scan.nextLine();
        SodokuPuzzle p = new SodokuPuzzle(file);
        System.out.println("Enter filename of puzzle solution (Optional):");
        String solution = scan.nextLine();
        if (solution.length() != 0)
        {
            SodokuPuzzle n = new SodokuPuzzle(solution);
            System.out.println(p);
            SodokuSolver t = new SodokuSolver(p);
            t.solve();
            if (p.equals(n))
            {
                System.out.println(p);
                System.out.println("Board is Correct!");
            }
            else
            {
                System.out.println("Solution is NOT correct!");
            }
        }
        else
        {
            System.out.println(p);
            SodokuSolver t = new SodokuSolver(p);
            t.solve();
            System.out.println(p);
        }
    }

}
