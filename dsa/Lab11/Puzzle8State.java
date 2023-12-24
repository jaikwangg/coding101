package Lab11;

public class Puzzle8State
{
    public int[] sequence;

    public Puzzle8State(int[] sequence) {
        assert sequence.length == 9;
        this.sequence = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            this.sequence[i] = sequence[i];
        }
    }
    

    @Override
    public boolean equals(Object ot)
    {
        Puzzle8State other = (Puzzle8State) ot;
        for (int i = 0; i < other.sequence.length; i++)
        {
            if (sequence[i] != other.sequence[i])
            {
                return false;
            }
        }
        return true;
    }

    public void displaySequence(boolean fullformat)
    {
        System.out.print("[");
        for (int i = 0; i < sequence.length; i++)
        {
            if (fullformat)
                System.out.printf("%d, ", sequence[i]);
            else
            {
                if (i % 3 == 0)
                    System.out.printf("%d, ", sequence[i]);
            }
        }
        System.out.println("]");
    }


    void displaySeq()
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
                System.out.printf("%s %s");
            }
        }
    }
}
