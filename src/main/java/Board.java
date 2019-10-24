
public class Board
{
    private static char[][] board;
    private static final char CELL_ALIVE = 'o';
    private static final char CELL_DEAD = ' ';
    private Cell[] cell;

    public Board(int sizeRow, int sizeColumn,  Cell... cells)
    {
        board = new char[sizeRow][sizeColumn];

        cell = cells;

        setCell(cell);
    }

    private Board(char[][] newBoard)
    {
        board = newBoard;
    }

    public void setCell(Cell... cells)
    {
        for (int i = 0; i < cells.length; i++)
        {
            int row = cells[i].getRow();
            int column = cells[i].getColumn();
            int last = board.length - 1;

            board[last - row][column] = CELL_ALIVE;
        }
    }

    public Board nextGeneration()
    {

        int howMany;
        int sizeRow = board.length;
        int sizeColumn = board[sizeRow-1].length;
        char[][] newBoard = new char[sizeRow][sizeColumn];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == CELL_ALIVE)
                {
                    howMany = howManyNeighbours(i, j);
                    if(howMany < 2 || howMany > 3)
                        newBoard[i][j] = CELL_DEAD;
                    else newBoard[i][j] = CELL_ALIVE;
                }
                else
                {
                    howMany = howManyNeighbours(i, j);
                    if(howMany == 3)
                        newBoard[i][j] = CELL_ALIVE;
                }
            }
        }

        return new Board(newBoard);
    }

    private int howManyNeighbours(int row, int column)
    {
        int countNeighbours = 0;
        int lastX = board.length - 1;
        int pointerX = -1;
        do
        {
            int x = row + pointerX;
            if(x < 0)
                x = lastX;
            else if(x > lastX)
                x = 0;
            int pointerY = -1;
            do
            {
                int lastY = board[lastX].length - 1;
                int y = column + pointerY;
                if(y < 0)
                    y = lastY;
                else if(y > lastY)
                    y = 0;

                if (x == row && y == column)
                {
                    pointerY++;
                    continue;
                }
                if (board[x][y] == CELL_ALIVE)
                    countNeighbours++;

                pointerY++;
            }while (pointerY < 2);
            pointerX++;
        }while(pointerX < 2);

        return countNeighbours;
    }

    public int getAmountsOfCells()
    {
        int sumOfCells = 0;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == CELL_ALIVE)
                {
                    sumOfCells++;
                }
            }
        }

        return sumOfCells;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int size = board.length;
        int innerSize = board[size-1].length;
        sb.append(createLine(innerSize));
        sb.append(System.lineSeparator());
        for(int i = 0; i < board.length; i++)
        {
            sb.append("|");
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == CELL_ALIVE)
                    sb.append(board[i][j]);
                else
                    sb.append(" ");
            }
            sb.append("|");
            sb.append(System.lineSeparator());
        }
        sb.append(createLine(innerSize));

        return sb.toString();
    }

    public String createLine(int size)
    {
        StringBuilder line = new StringBuilder();
        for(int i = 0; i <=size + 1; i++)
        {
            if(i == 0 || i > size)
                line.append("+");
            else
                line.append("-");
        }

        return line.toString();
    }

}
