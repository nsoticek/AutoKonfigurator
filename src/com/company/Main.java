package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car mercedesA = new Car("Mercedes", "A45 AMG", 360, Color.BLACK, "W177A123");
        Car mercedesC = new Car("Mercedes", "C63 AMG", 460, Color.BLUE, "A205C123");

        Car newMercedes = mercedesA;
        newMercedes.setSerialNumber("W177A234");

        while (true) {
            mainMenu(cars, mercedesA, mercedesC);
        }
    }

    private static void mainMenu(ArrayList<Car> cars, Car mercedesA, Car mercedesC) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        Car car = null;

        String message1 = "Derzeit sind zwei Modelle erhältlich. 1.Mercedes-Benz A45 AMG u. 2.Mercedes-Benz C63 AMG";
        String message2 = "Welchen der zwei möchten Sie kaufen? Zahl eingeben: ";
        String message3 = "Sie können die Leistung verändern. Bitte die Leistung in PS angeben: ";
        String message4 = "Bitte wählen Sie eine Farbe. Black/Red/Grey/Blue: ";

        System.out.println("---Auto Konfigurator---");

        // user input, ask user which car he want to buy
        int selection = userInput(scannerNum, message1, message2);
        if(selection == 1) {
            car = mercedesA;
        } else if (selection == 2) {
            car = mercedesC;
        } else {
            System.out.println("Error.");
        }

        // change hp
        int userInputHorsePower = userInput(scannerNum, message3);
        if(userInputHorsePower != car.getHorsePower()) {
          car.setHorsePower(userInputHorsePower);
        }

        // change color
        String userInputColor = userInputStr(scannerStr, message4);
        if(!userInputColor.equalsIgnoreCase(String.valueOf(car.getColor()))) {
            if(userInputColor.equalsIgnoreCase("Black")) {
                car.setColor(Color.BLACK);
            } else if(userInputColor.equalsIgnoreCase("Red")) {
                car.setColor(Color.RED);
            } else if(userInputColor.equalsIgnoreCase("Blue")) {
                car.setColor(Color.BLUE);
            } else if(userInputColor.equalsIgnoreCase("Grey")) {
                car.setColor(Color.GREY);
            }
        }
        cars.add(car);
        printCarFacts(cars);
    }

    private static void printCarFacts(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getBrand() + " " + cars.get(i).getType() + " " + cars.get(i).getHorsePower() +
                    " " + cars.get(i).getSerialNumber() + " " + cars.get(i).getColor());
        }
    }

    private static String userInputStr(Scanner scannerStr, String message1) {
        System.out.println(message1);
        String selection = scannerStr.nextLine();
        return selection;
    }

    private static int userInput(Scanner scannerNum, String message1) {
        System.out.println(message1);
        int selection = scannerNum.nextInt();
        return selection;
    }

    private static int userInput(Scanner scannerNum, String message1, String message2) {
        System.out.println(message1 + "\n" + message2);
        int selection = scannerNum.nextInt();
        return selection;
    }
}
