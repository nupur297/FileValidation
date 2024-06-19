import my.client.PaperRockScissorGame;
import my.client.data.Move;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class PaperRockScissorGameTest {


    @Test
    void testPlayersMoveForNull() {

        Optional<Move> playersMove = PaperRockScissorGame.getPlayersMove(null);
        assert playersMove.isEmpty();
    }

    @Test
    void testPlayersMoveForEmpty() {

        Optional<Move> playersMove = PaperRockScissorGame.getPlayersMove("");
        assert playersMove.isEmpty();
    }

    @Test
    void testPlayersMoveForValidInput() {

        Optional<Move> rockMove = PaperRockScissorGame.getPlayersMove("rock");
        assert rockMove.get().equals(Move.ROCK);

        Optional<Move> scissorMove = PaperRockScissorGame.getPlayersMove("scissor");
        assert scissorMove.get().equals(Move.SCISSOR);

        Optional<Move> paperMove = PaperRockScissorGame.getPlayersMove("paper");
        assert paperMove.get().equals(Move.PAPER);
    }

    @Test
    void testPlayersMoveForInValidInput() {

        Optional<Move> testMove = PaperRockScissorGame.getPlayersMove("test");
        assert testMove.isEmpty();
    }

    void testWinWithPlayersRock() {

        assert !PaperRockScissorGame.isPlayerWin(Move.ROCK, Move.ROCK);

        assert PaperRockScissorGame.isPlayerWin(Move.ROCK, Move.SCISSOR);

        assert !PaperRockScissorGame.isPlayerWin(Move.ROCK, Move.PAPER);
    }

    void testWinWithPlayersPaper() {

        assert PaperRockScissorGame.isPlayerWin(Move.PAPER, Move.ROCK);

        assert !PaperRockScissorGame.isPlayerWin(Move.PAPER, Move.SCISSOR);

        assert !PaperRockScissorGame.isPlayerWin(Move.PAPER, Move.PAPER);
    }

    void testWinWithPlayersScissor() {

        assert !PaperRockScissorGame.isPlayerWin(Move.SCISSOR, Move.ROCK);

        assert !PaperRockScissorGame.isPlayerWin(Move.SCISSOR, Move.SCISSOR);

        assert PaperRockScissorGame.isPlayerWin(Move.SCISSOR, Move.PAPER);
    }

}
