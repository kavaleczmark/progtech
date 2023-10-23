package org.example;

public class Game {
    private UserInput userInput;
    private String userName;

    public Game() {
        userInput = new UserInput();
    }

    public void startGame() {
        getUserName();
        startMainMenu();
    }

    private void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        userName = userInput.getUserInputAsString();
        System.out.println("Köszönjük! További jó szórakozást!");
    }

    private void startMainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. KILÉPÉS");
        handleMainMenuInput(userInput.getUserInputAsInt());
    }

    private void handleMainMenuInput(int input) {
        switch (input) {
            case 1 -> game();
            case 2 -> mapEditor();
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
                System.out.println("#cominsoon or #wrongcommand");
                game();
            }
        }
    }

    private void mapEditor() {
        System.out.println("-------PÁLYASZERKESZTŐ-------");
        System.out.println("1. PÁLYA LÉTREHOZÁSA    #comingsoon");
        System.out.println("2. PÁLYA BETÖLTÉSE    #comingsoon");
        System.out.println("3. PÁLYA MENTÉSE    #comingsoon");
        System.out.println("4. VISSZA A FŐMENÜBE");
        handleMapEditorInput(userInput.getUserInputAsInt());
    }

    private void handleMapEditorInput(int input) {
        switch (input) {
            case 4 -> startMainMenu();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    private void exitGame() {
        System.exit(0);
    }

}
