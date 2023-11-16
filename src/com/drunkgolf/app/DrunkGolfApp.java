package com.drunkgolf.app;

import com.drunkgolf.ClubType;

import java.util.Scanner;

// Controller
class DrunkGolfApp {
    private Scanner scanner = new Scanner(System.in);
    private ClubType club = ClubType.DRIVER;


    public void execute() {
        welcome();
        int courseNum = promptForCourse();
        teeOff(courseNum);
        club.swingClub(club);

        endResults();

    }

    public void welcome() {
        System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
        System.out.println("W E L C O M E   T O   D R U N K   G O L F");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
    }

    public void teeOff(int courseNum) {
        Course currentCourse = new Course(courseNum);
        while(!currentCourse.isComplete()) {
            ClubType club = promptForClub();
            currentCourse.play(club);
            System.out.println(currentCourse.showScoreCard()); // clear screen and maintain as header while playing
        }
    }

    private int promptForCourse() {
        boolean validInput = false;
        int courseSize = 0;
        System.out.println("Enter amount of holes: ");
        String userInput = scanner.nextLine().trim();
        courseSize = Integer.parseInt(userInput);

        while(!validInput) {
            if(userInput.matches("\\d{1,2}")) {
                if(courseSize == 1 || courseSize == 9 || courseSize == 18) {
                    validInput = true;
                }
                printRules();
            }
            printRules();
        }
        return courseSize;
    }

    private void printRules() {
        System.out.println("You can only enter: [1] [9] [18]");
    }


    private ClubType promptForClub(){

    }
    private void endResults() {
        System.out.println("+ + + + + + + + + + + + + +");
        System.out.println("Y O U   A R E   T R A S H");
        System.out.println("+ + + + + + + + + + + + + +");
    }


}