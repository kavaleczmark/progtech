package org.example;

public class Game {
    private UserInput userInput;
    private String userName;
    private Map map;
    private MapEditor mapEdit;

    public Game() {
        userInput = new UserInput();
        mapEdit = new MapEditor();
    }

    public void startGame() {
        getUserName();
        startMainMenu();
    }

    private void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        userName = userInput.getUserInputAsString();
        System.out.println("Köszönjük! További jó szórakozást " + userName + "!");
    }

    void startMainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. KILÉPÉS");
        handleMainMenuInput(userInput.getUserInputAsInt());
    }

    private void handleMainMenuInput(int input) {
        switch (input) {
            case 1 -> game();
            case 2 -> mapEdit.mapEditor();
            case 3 -> exitGame();
            default -> {
                System.out.println("NEM LÉTEZIK ILYEN PARANCS");
                startMainMenu();
            }
        }
    }

    private void game() {
        System.out.println("-------JÁTÉK-------");
        System.out.println("1. PÁLYA BETÖLTÉSE JÁTÉKBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        System.out.println("3. VISSZA A FŐMENÜBE");
        handleGameInput(userInput.getUserInputAsInt());
    }

    private void handleGameInput(int input) {
        switch (input) {
            case 3 -> startMainMenu();
            default -> {
                System.out.println("#comingsoon or #wrongcommand");
                game();
            }
        }
    }

    private void exitGame() {
        System.exit(0);
    }

}
