package org.example;

public class Game {
    private UserInput userInput;
    private String userName;
    private MainMenu mainMenu;

    public Game() {
        this.userInput = new UserInput();
        this.mainMenu = new MainMenu(this,userInput);
    }

    public void startGame() {
        getUserName();
        mainMenu.startMainMenu();
    }

    private void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        userName = userInput.getUserInputAsString();
        System.out.println("Köszönjük! További jó szórakozást " + userName + "!");
    }

    public void game() {
        System.out.println("-------JÁTÉK-------");
        System.out.println("1. PÁLYA BETÖLTÉSE JÁTÉKBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        System.out.println("3. VISSZA A FŐMENÜBE");
        handleGameInput(userInput.getUserInputAsInt());
    }

    private void handleGameInput(int input) {
        switch (input) {
            case 3 -> mainMenu.startMainMenu();
            default -> {
                System.out.println("#comingsoon or #wrongcommand");
                game();
            }
        }
    }

    public void exitGame() {
        System.exit(0);
    }

}