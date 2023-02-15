import equipment.DefensiveEquipment;
import equipment.OffensiveEquipment;

import java.util.Scanner;

public class Menu {
    private Game game;

    private final Scanner scanner;
    private boolean exit;

    public Menu(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
        this.exit = false;
    }

    public void run(){
        while (!this.exit) {
            System.out.println("Bonjour ! ");
            if(this.game.hasPlayer()){
                System.out.println(" 1 - Update player");
                System.out.println(" 2 - Delete player");
                System.out.println(" 3 - Show player");
                System.out.println(" 4 - Run game");
            } else {
                System.out.println(" 1 - Create player");
            }
            System.out.println(" 9 - Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    if(this.game.hasPlayer()){
                        // If there is already a player we update it
                        this.updatePlayer(this.game.getPlayer());
                    } else {
                        // if no player exists we create a new one
                        Player player = this.createPlayer();
                        this.game.setPlayer(player);
                    }
                }
                case 2 -> {
                    // We check that there's already a player defined
                    if(this.game.hasPlayer()){
                        // if so we remove the currently defined player
                        this.game.unsetPlayer();
                        //this.game.setPlayer(null);
                    }
                }
                case 3 -> {
                    if (this.game.hasPlayer()){
                        System.out.println(this.game.getPlayer().toString());
                    }
                }
                case 4 -> {
                    // We check that there's already a player defined
                    // FIXME we should check if the game is ready to start (delegate that responsibility to the game object)
                    if(this.game.hasPlayer()){
                        // Then we run the game
                        this.startGame();
                    }
                }
                // The user which to exit (we break the main loop)
                case 9 -> this.exit = true;
            }
        }
    }

    private void startGame() {
        while(!this.game.isFinished()) {
            this.game.playTurn();
        }
        // the game is finish we create a new one and return to the main menu
        this.game = new Game();
    }

    /**
     * Display a menu to permit update of an existing player
     * @param player player to update
     */
    private void updatePlayer(Player player) {
        System.out.println("Type new name :");
        String name = this.scanner.nextLine();
        player.setName(name);
    }

    /**
     * Display a menu for player creation
     * @return newly created player
     */
    private Player createPlayer() {
        System.out.println("Bonjour ! ");
        System.out.println("Type name :");
        String name  = this.scanner.nextLine();
        boolean correct;
        Player player = null;
        do {
            System.out.println("Choose class");
            System.out.println(" 1 - Warrior");
            System.out.println(" 2 - Wizzard");
            int choice  = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 -> {
                    correct = true;
                    DefensiveEquipment armor = new DefensiveEquipment("Training armor",3);
                    OffensiveEquipment sword = new OffensiveEquipment("Training sword",1);
                    player = new Player(name, 10, 10, "warrior", armor, sword);
                }
                case 2 -> {
                    correct = true;
                    DefensiveEquipment armor = new DefensiveEquipment("Cloak",1);
                    OffensiveEquipment spell = new OffensiveEquipment("Spark",3);
                    player = new Player(name, 6, 15, "wizzard", armor, spell);
                }
                default -> correct = false;
            }
        } while (!correct);

        return player;
    }

}
