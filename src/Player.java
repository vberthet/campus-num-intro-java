import java.util.Objects;

/**
 * Model for a player
 * Hold details information about the player
 */
public class Player {

    /**
     * Name of the player
     */
    private String name;
    private int life;
    private int attack;
    private String type;

    /**
     * Create a new player using default parameters
     */
    public Player() {
        this.name = "Gandlaf";
        this.life = 6;
        this.attack = 15;
        this.type = " wizzard";
    }

    /**
     * Create a new player using given parameters
     * @param name name of the player
     * @param life
     * @param attack
     * @param type
     */
    public Player(String name, int life, int attack, String type) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", attack=" + attack +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return life == player.life && attack == player.attack && Objects.equals(name, player.name) && Objects.equals(type, player.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, life, attack, type);
    }
}
