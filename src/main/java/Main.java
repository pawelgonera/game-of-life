
public class Main
{
    public static void main (String[] agrs)
    {
        Board board = new Board(20, 60,  Cell.live(10,20), Cell.live(10, 21),
                            Cell.live(9, 21), Cell.live(9, 22), Cell.live(11,20), Cell.live(11,21),
                            Cell.live(11,19), Cell.live(10,23), Cell.live(11,19), Cell.live(8, 20), Cell.live(8,21));

        System.out.println(board.toString());
        System.out.println(board.getAmountsOfCells());

        for(int i = 0; i < 500; i++)
        {
            board.nextGeneration();
            System.out.println(board.toString());
            System.out.println(board.getAmountsOfCells());
            System.out.println(i);
        }

    }
}
