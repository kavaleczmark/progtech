package org.example;

public class Game {
    private UserInput userInput;

    public Game() {
        userInput=new UserInput();
    }
    public void startGame() {
        getUserName();
    }

    private void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        userInput.getUserInputAsString();
        System.out.println("Köszönjük! További jó szórakozást!");
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. KILÉPÉS");
        switch (userInput.getUserInputAsInt()) {
            case 1 -> game();
            case 2 -> mapEditor();
            case 3 -> exitGame();
            default -> {
                System.out.println("NEM LÉTEZIK ILYEN PARANCS");
                mainMenu();
            }
        }
    }

    private void game() {
        System.out.println("-------JÁTÉK-------");
        System.out.println("1. PÁLYA BETÖLTÉSE JÁTÉKBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        System.out.println("3. VISSZA A FŐMENÜBE");
        switch (userInput.getUserInputAsInt()) {
            case 3 -> mainMenu();
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
        switch (userInput.getUserInputAsInt()) {
            case 4 -> mainMenu();
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
