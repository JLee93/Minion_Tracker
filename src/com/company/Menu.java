package com.company;

import java.util.Scanner;

/**
 * Created by Jonathan on 5/16/2016.
 */


/**
 * The Menu class models a console based menu that contains a title and an array of options.
 * It supports display, retrieving input, formatting the title.
 */
public class Menu {

    private String title;
    private String[] options;

    public Menu(String title, String[] options) {

        this.title = title;
        this.options = options;

    }

    public void display() {

        System.out.println(getFormattedTitle());

        for (int i = 0; i < options.length; i++) {

            System.out.println((i + 1) + "." + options[i]);

        }

    }

    public int getSelection() {

        return getNumberBetween(1, options.length, false);

    }

    //cancelAllowed controls whether 0 is a valid input or not. 0 is used for exiting out of a menu option in this case.
    public int getNumberBetween(int lower, int upper, Boolean cancelAllowed) {

        Boolean correctInput = false;
        Scanner scan = new Scanner(System.in);
        int input = -1;

        while (!correctInput) {

            input = scan.nextInt();

            if ((input < lower || input > upper)
                    && !cancelAllowed) {

                System.out.println("Error: Please enter a selection between " + lower + " and " + upper);

            } else if ((input < lower || input > upper)
                    && cancelAllowed) {

                if (input == 0) {

                    correctInput = true;

                } else {

                    System.out.println("Error: Please enter a selection between " + lower + " and " + upper);

                }

            } else {

                correctInput = true;

            }

        }

        return input;

    }

    private String getFormattedTitle() {

        String formattedTitle = "";

        //Don't format if the title is empty
        if (title.length() <= 0) {

            return formattedTitle;

        }

        for (int i = 0; i < title.length() + 4; i++) {

            formattedTitle = formattedTitle + "*";

        }

        formattedTitle = formattedTitle + "\n" + "* " + title;
        formattedTitle = formattedTitle + " *" + "\n";

        for (int i = 0; i < title.length() + 4; i++) {

            formattedTitle = formattedTitle + "*";

        }

        return formattedTitle;

    }

}
