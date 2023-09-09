
/**
 * Write a description of class Tour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Knight 
{
    private int boardSize = 8;
    private int[][] chessboard2 = new int[boardSize][boardSize];
    private final Move[] moves = {new Move(-1, 2),new Move(-2, 1), new Move(-2, -1),new Move(-1, -2), new Move(1, -2),new Move(2, -1), new Move(1, 2)};
    
    public Knight() 
    {
        getBoard();
    }

    public void getBoard() 
    {
        for (int i = 0; i < boardSize; i++)
        {
            Arrays.fill(chessboard2[i], Integer.MIN_VALUE);
        }
    }

    public boolean move(int moveNum, int x, int y) 
    {
        if (moveNum == 64) 
        {
            return true;
        }
        
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        
        for (Move move : moves) 
        {
            int nextRow =  x + move.row;
            int nextCol =  y + move.col;
            if (canMove(nextRow, nextCol) && chessboard2[nextRow][nextCol] == Integer.MIN_VALUE)
            {
                possibleMoves.add(move);
            }
        }
        
        if (!possibleMoves.isEmpty()) 
        {
            Move chosenMove = possibleMoves.get((int) Math.random() * (possibleMoves.size()));
            int nextRow =  x + chosenMove.row;
            int nextCol =  y + chosenMove.col;
            chessboard2[nextRow][nextCol] = moveNum + 1;
            move(moveNum + 1, nextRow, nextCol);
            return true;
        } 
        else
        {
            return false;
        }
    }     

    public boolean canMove(int x, int y) 
    {
        return (x >= 0 && x < boardSize && y >= 0 && y < boardSize);
    }

    public void print() 
    {
        for (int i = 0; i < boardSize; i++) 
        {
            for (int square : chessboard2[i])
            {
                if (square == Integer.MIN_VALUE)
                {
                    System.out.print("--- ");
                }
                else
                {
                    System.out.print(String.format("%3d", square) + " ");
                }
            }
            System.out.println();
        }
    }
 
    public void solve() 
    {
        chessboard2[0][0] = 1;
        if (move(1, 0, 0))
        {
            print();
        }
    }

    class Move 
    {
        int row = 0;
        int col = 0;

        Move(int r, int c) 
        {
            this.row = r;
            this.col = c;
        }
    }
}
