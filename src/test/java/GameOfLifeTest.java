import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest
{

    @Test
    public void shouldBeAbleToProvideNextGenerationWithPeriod()
    {
        String boardVisualisation = "+----+" + System.lineSeparator() +
                                    "|    |" + System.lineSeparator() +
                                    "|    |" + System.lineSeparator() +
                                    "|ooo |" + System.lineSeparator() +
                                    "|    |" + System.lineSeparator() +
                                    "+----+";
        Board board = new Board(4, 4, Cell.live(1, 0), Cell.live(1, 1), Cell.live(1, 2));
        assertEquals(boardVisualisation, board.toString());

        String expected = "+----+" + System.lineSeparator() +
                          "|    |" + System.lineSeparator() +
                          "| o  |" + System.lineSeparator() +
                          "| o  |" + System.lineSeparator() +
                          "| o  |" + System.lineSeparator() +
                          "+----+";
        Board boardNextGeneration = board.nextGeneration();
        assertEquals(expected, boardNextGeneration.toString());
    }
}
