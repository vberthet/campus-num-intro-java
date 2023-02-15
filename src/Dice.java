import java.util.Random;

/**
 * Simulate a 6-sided dice using a pseudo-random generator
 */
public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    /**
     * Throw a 6-sided dice and return the result
     * @return visible side of the dice
     */
    public int throwDice(){
        return this.random.nextInt(1,7);
    }
}
