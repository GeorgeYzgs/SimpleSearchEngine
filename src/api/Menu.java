/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.Scanner;
import strategy.*;

/**
 *
 * @author George.Giazitzis
 */
public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void menu() {
        loop:
        do {
            System.out.println("=== Menu ===\n"
                    + "1. Find a person\n"
                    + "2. Print all people\n"
                    + "0. Exit");
            switch (sc.nextLine()) {
                case "1":
                    searchCriteria();
                    break;
                case "2":
                    System.out.println("=== List of people ===");
                    GenerateData.getList().forEach(System.out::println);
                    break;
                case "0":
                    System.out.println("Bye!");
                    break loop;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        } while (true);
    }

    private static void searchCriteria() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        loop:
        do {
            switch (Strategy.valueOf(sc.nextLine())) {
                case ALL:
                    new AllFinder().find();
                    break loop;
                case ANY:
                    new AnyFinder().find();
                    break loop;
                case NONE:
                    new NoneFinder().find();
                    break loop;
                default:
                    System.out.println("Invalid strategy option! Try again.");
            }
        } while (true);
    }
}
