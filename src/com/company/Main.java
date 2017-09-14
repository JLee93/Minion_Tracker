package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The main class implements the Evil Minion tracker of Assignment 0
 */
public class Main {

    public static void main(String[] args) {

        Boolean stillRunning = true;
        List<Minion> minions = new ArrayList<>();
        Minion currentMinion;
        Menu mainMenu = initiateMainMenu();

        int selection;

        while (stillRunning) {

            mainMenu.display();
            selection = mainMenu.getSelection();

            switch (selection) {
                case 1:
                    printListOfMinions(minions);
                    break;
                case 2:
                    currentMinion = createMinion();
                    addMinion(minions, currentMinion);
                    break;
                case 3:
                    removeMinion(minions);
                    break;
                case 4:
                    attributeEvilDeed(minions);
                    break;
                case 5:
                    dumpObjects(minions);
                    break;
                case 6:
                    stillRunning = false;
                    break;
                default:
                    assert false;

            }
        }

    }


    private static void printListOfMinions(List<Minion> minions) {

        System.out.println("List of Minions: ");
        System.out.println("****************");

        if (minions.size() <= 0) {

            System.out.println("No minions found.\n");
            return;

        }

        for (int i = 0; i < minions.size(); i++) {

            System.out.println((i + 1) + ". " + minions.get(i).getName() + ", "
                    + minions.get(i).getHeightInM() + "m, " + minions.get(i).getEvilDeedCount() + " evil deed(s)");


        }

        System.out.println();

    }

    private static Minion createMinion() {

        Scanner scan = new Scanner(System.in);
        String minionName;
        Double minionHeight;

        System.out.println("Enter Minion's name: ");
        minionName = scan.nextLine();
        System.out.println("Enter Minion's height: ");
        minionHeight = scan.nextDouble();

        return new Minion(minionName, minionHeight);

    }

    private static void addMinion(List<Minion> minions, Minion minion) {

        minions.add(minion);

    }

    public static void removeMinion(List<Minion> minions) {

        int selectedMinion;

        Menu removeMenu = initiateMinionMenu(minions);

        printListOfMinions(minions);

        if (minions.size() <= 0) {
            System.out.println("(Enter 0 to cancel.)");
            removeMenu.getNumberBetween(0, 0, true);

        } else {
            System.out.println("(Enter 0 to cancel.)");
            selectedMinion = removeMenu.getNumberBetween(1, minions.size(), true);

            if (selectedMinion == 0) {

                return;

            } else {

                //arrayList index starts at 0
                minions.remove(selectedMinion - 1);

            }

        }

    }

    private static void attributeEvilDeed(List<Minion> minions) {

        int selectedMinion;
        Menu evilDeedMenu = initiateMinionMenu(minions);

        printListOfMinions(minions);

        if (minions.size() <= 0) {
            System.out.println("(Enter 0 to cancel.)");
            evilDeedMenu.getNumberBetween(0, 0, true);

        } else {
            System.out.println("(Enter 0 to cancel.)");
            selectedMinion = evilDeedMenu.getNumberBetween(1, minions.size(), true);

            if (selectedMinion == 0) {

                return;

            } else {

                minions.get(selectedMinion - 1).incrementEvilDeeds();
                System.out.println(minions.get(selectedMinion - 1).getName() + " has now done " +
                        minions.get(selectedMinion - 1).getEvilDeedCount() + " evil deed(s)!");

                System.out.println();

            }

        }

    }

    private static void dumpObjects(List<Minion> minions) {

        System.out.println("All Minion Objects: ");

        for (int i = 0; i < minions.size(); i++) {

            System.out.println((i + 1) + "." + "sfu.cmpt213.as0.Minion" + minions.get(i).toString());

        }

        System.out.println();

    }


    private static Menu initiateMinionMenu(List<Minion> minions) {

        String[] options = new String[minions.size()];

        for (int i = 0; i < minions.size(); i++) {

            options[i] = minions.get(i).getName() + ", "
                    + minions.get(i).getHeightInM() + "m, " + minions.get(i).getEvilDeedCount() + " evil deed(s)";

        }

        //will already be printing the list of minions using printListOfMinions, no need for a title
        return new Menu("", options);

    }

    private static Menu initiateMainMenu() {

        String[] options = new String[6];
        options[0] = "List minions";
        options[1] = "Add a new minion";
        options[2] = "Remove a minion";
        options[3] = "Attribute evil deed to a minion";
        options[4] = "DEBUG: Dump objects (toString)";
        options[5] = "Exit";

        return new Menu("Main Menu", options);

    }

}
