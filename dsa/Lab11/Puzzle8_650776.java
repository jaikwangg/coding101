package Lab11;

import java.util.ArrayList;
import java.util.Stack;

public class Puzzle8_650776
{
    int size = 3;
    int[] sequence;
    ArrayList<Puzzle8State> explored;
    Stack<Puzzle8State> dfs;

    public Puzzle8_650776(int[] seq)
    {
        sequence = seq;
        dfs = new Stack<>();
        explored = new ArrayList<>();
        Puzzle8State init = new Puzzle8State(sequence);
        dfs.push(init);
        explored.add(init);
    }


    public void nextMoveWithStack()
    {
        generateNextMoves();
    }


    private Puzzle8State createMoveFromSwapWithEmptyTile(Puzzle8State currentState, int blackPos, int swapPos)
    {
        Puzzle8State dup = new Puzzle8State(currentState.sequence);
        dup.sequence[blackPos] = currentState.sequence[swapPos];
        dup.sequence[swapPos] = 9;
        return dup;
    }

    private boolean isThisStateInExploredStates(Puzzle8State state)
    {
        for (Puzzle8State st :  explored)
        {
            if (st.equals(state))
            {
                return true;
            }
        }
        return false;
    }

    public void generateNextMoves()
    {
        int blackPos = -1;
        Puzzle8State currentState = dfs.pop();
        assert currentState != null;
        for (int i = 0; i < currentState.sequence.length; i++) 
        {
            if (currentState.sequence[i] == 9)
                blackPos = i;
        }
        assert blackPos != -1;

        Puzzle8State[] possibleNewStates = new Puzzle8State[4];
        for (int i = 0; i < 4; i++)
            possibleNewStates[i] = null;
        if (blackPos + 3 < 27 && blackPos + 9 < 27)
        {
            possibleNewStates[0] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos + 9);
        }
        if (blackPos - 3 > -1 && blackPos - 9 > -1)
        {
            possibleNewStates[1] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos - 9);
        }
        if (blackPos %3 <= 2 && blackPos + 3 < 27)
        {
            possibleNewStates[2] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos + 3);
        }
        if (blackPos %3 > 0 && blackPos - 3 < -1)
        {
            possibleNewStates[3] = createMoveFromSwapWithEmptyTile(currentState, blackPos, blackPos - 3);

        }

        for (int i = 0; i < 4; i++)
        {
            if (possibleNewStates[i] != null)
            {
                if (!isThisStateInExploredStates(possibleNewStates[i]))
                {
                    dfs.push(possibleNewStates[i]);
                    explored.add(possibleNewStates[i]);

                    possibleNewStates[i].displaySequence(false);

                    System.out.println();
                }

                if (isGoal(possibleNewStates[i].sequence))
                {
                    System.exit(0);
                }

            }
        }
        nextMoveWithStack();
    }

    public boolean isGoal(int[] seq)
    {
        int[] finalConfigurationSeq = new int[27];

        for (int i = 0; i < 9; i++)
        {
            int j = i * 3;
            finalConfigurationSeq[j] = i + 1;

            if (seq[j] != finalConfigurationSeq[j])
                return false;
        }
        return true;
    }

    void displayBoard()
    {
        int[][] mat = new int[3][3];
        for (int i = 0; i < sequence.length / 3; i++) {
            int row = i / 3;
            int col = i % 3;

            mat[row][col] = sequence[3 * i];
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.printf("%s %s",
                    mat[i][j] == 9 ? " " : String.valueOf(mat[i][j]),
                    j == 2 ? "\n" : ""
                );
            }
        }
    }


    
    static Puzzle8_650776 game ;
    public static void main(String[] args) {
        int [] seq = new int[]{9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2};
        game = new Puzzle8_650776(seq);
        demo1();
        demo2();
        demo3();
    }

    static void demo1()
    {
        game.displayBoard();
    }

    static void demo2()
    {
        game.generateNextMoves();
    }

    static void demo3()
    {
        game.nextMoveWithStack();
        
        for (Puzzle8State st : game.explored)
        {
            
            st.displaySequence(false);
        }
    }
}
