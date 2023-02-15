/**
 * Hold details about the current game
 */
public class Game {

    public static final int NB_CASE = 64;
    private Player player;

    private Dice dice;

    private int playerPosition;

    public Game() {
        this.player = null;
        this.playerPosition = 0;
        this.dice = new Dice();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void playTurn() {
        // The player throw the dice
        System.out.println("You launch the dice....");
        int moves = this.dice.throwDice();
        // and advance is player accordingly
        System.out.printf("You move %d cases forward...",moves);
        System.out.println();
        this.playerPosition += moves;
        if(this.isFinished()){
            System.out.println("You reach the end of the board");
        } else {
            System.out.printf("You have reached cell %d", this.playerPosition + 1);
        }
    }

    public boolean hasPlayer() {
        return this.player != null;
    }

    public void unsetPlayer() {
        this.player = null;
    }

    public boolean isFinished() {
        return this.playerPosition > NB_CASE;
    }
}
