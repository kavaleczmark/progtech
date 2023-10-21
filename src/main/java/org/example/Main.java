package org.example;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        Scanner sc=new Scanner(System.in);
        String userName= sc.nextLine();
        System.out.println("Köszönjük! További jó szórakozást!");
        mainMenu();
    }
    private static void mainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. KILÉPÉS");
        Scanner sc=new Scanner(System.in);
        int menuNumber=sc.nextInt();
        switch (menuNumber)
        {
            case 1:game();
            break;
            case 2:mapEditor();
            break;
            case 3:exitGame();
            break;
            default: {
                System.out.println("NEM LÉTEZIK ILYEN PARANCS");
                mainMenu();}
        }
    }
    private static void game() {
        System.out.println("-------JÁTÉK-------");
        System.out.println("1. PÁLYA BETÖLTÉSE JÁTÉKBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        System.out.println("3. VISSZA A FŐMENÜBE");
        Scanner sc=new Scanner(System.in);
        int menuNumber=sc.nextInt();
        switch (menuNumber)
        {
            case 3:mainMenu();
            default:{
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }
    private static void mapEditor() {
        System.out.println("-------PÁLYASZERKESZTŐ-------");
        System.out.println("1. PÁLYA LÉTREHOZÁSA    #comingsoon");
        System.out.println("2. PÁLYA BETÖLTÉSE    #comingsoon");
        System.out.println("3. PÁLYA MENTÉSE    #comingsoon");
        System.out.println("4. VISSZA A FŐMENÜBE");
        Scanner sc=new Scanner(System.in);
        int menuNumber=sc.nextInt();
        switch (menuNumber)
        {
            case 4:mainMenu();
            default:{
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    private static void exitGame() {
        System.exit(0);
    }
    public static void main(String[] args) {
        getUserName();

    }
}