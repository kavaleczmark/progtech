package org.example;

public class MapEditor {

    private Map map;
    private UserInput userInput;
    private Game game;

    public MapEditor() {
        userInput = new UserInput();
    }

    public void mapEditor() {
        System.out.println("-------PÁLYASZERKESZTŐ-------");
        System.out.println("1. PÁLYA LÉTREHOZÁSA");
        System.out.println("2. PÁLYA BETÖLTÉSE    #comingsoon");
        System.out.println("3. PÁLYA MENTÉSE    #comingsoon");
        System.out.println("4. VISSZA A FŐMENÜBE");
        handleMapEditorInput(userInput.getUserInputAsInt());
    }

    private void handleMapEditorInput(int input) {
        switch (input) {
            case 1 -> createMap();
            case 4 -> game.startMainMenu();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    private void createMap() {
        System.out.println("Írja be a pálya méretét (NxN):");
        map = new Map(userInput.getUserInputAsInt());
        map.printMap();
    }
}
