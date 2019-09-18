package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Size and start coordinates?");

        Scanner scanner = new Scanner(System.in);
        String strippedStart = scanner.nextLine().replaceAll(",", "");
        Scanner stripScanner = new Scanner(strippedStart).useDelimiter("");

        int width = stripScanner.nextInt();
        int height = stripScanner.nextInt();
        int startPos[] = {stripScanner.nextInt(), stripScanner.nextInt()};

        String commandsInput = scanner.nextLine().replaceAll(",","");

        CommandHandler(commandsInput, width, height, startPos);

        System.out.println("You ended up att the following coordinates " + startPos[0] + "," + startPos[1]);

    }

    public static void CommandHandler(String commands, int width, int height, int[] startPos) {
        int commandInt;
        String returnString = "";

        // North = 1
        // East = 2
        // South = 3
        // West = 4
        int direction = 1;

        Scanner commandScanner = new Scanner(commands).useDelimiter("");
        for (int i = 0; i < commands.length()-1; i++) {
            if (checkPos(width, height, startPos)) return;
            commandInt = commandScanner.nextInt();
            switch (commandInt) {
                case 1:
                    moveForward(startPos, direction);
                    break;
                case 2:
                    moveBackward(startPos, direction);
                    break;
                case 3:
                    direction = rotateCCW(direction);
                    break;
                case 4:
                    direction = rotateCW(direction);
                    break;
                case 0:

                default:
                   return;
            }
        }
    }

    private static boolean checkPos(int width, int height, int[] startPos) {
        if (startPos[1] > width-1 || startPos[1] < 0){
            return true;
        } else if (startPos[0] > height-1 || startPos[0] < 0){
            return true;
        }
        return false;
    }

    private static int rotateCW(int direction) {
        if (direction == 1) {
            direction = 4;
        } else {
            direction--;
        }
        return direction;
    }

    private static int rotateCCW(int direction) {
        if (direction == 4) {
            direction = 1;
        } else {
            direction++;
        }
        return direction;
    }

    private static void moveBackward(int[] startPos, int direction) {
        if (direction == 1) {
            startPos[1]++;
        } else if (direction == 2) {
            startPos[0]--;
        } else if (direction == 3) {
            startPos[1]--;
        } else if (direction == 4) {
            startPos[0]++;
        }
    }

    private static void moveForward(int[] startPos, int direction) {
        if (direction == 1) {
            startPos[1]--;
        } else if (direction == 2) {
            startPos[0]++;
        } else if (direction == 3) {
            startPos[1]++;
        } else if (direction == 4) {
            startPos[0]--;
        }
    }
}
