package com.pluralsight;

import java.io.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<WorkoutRoutine> workoutRoutineList= new ArrayList<>();
    static String command;

    public static void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, boolean nextLine) {
        if (nextLine) {System.out.println(text);}
        else {System.out.print(text);}
    }

    public static double stringToDouble(String prompt) {
        while (true){
            print(prompt,false);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                print("Error invalid command! Please enter a valid command");
                stringToDouble(prompt);
            }
        }
    }

    public static void main(String[] args) {
        runMainMenu();
    }

    private static void runMainMenu(){
        do {
            print("""
                === Home ===
                N) New Workout
                W) Workouts
                X) Exit
                Enter a command:"""+" ",false);
            command = scanner.nextLine().toLowerCase().trim();
            switch (command){
                case "n" -> createNewWorkout();
                case "w" -> listAllWorkout();
                default -> {
                    if (!command.equals("x")) {
                        print("Error invalid command! Please enter a valid command.");
                    }
                }
            }
        } while (!command.equals("x"));
    }

    private static void createNewWorkout() {
        WorkoutRoutine workoutRoutine = new WorkoutRoutine();
        print("Enter Name: ",false);
        command = scanner.nextLine();
        workoutRoutine.setName(command);
        workoutRoutine.setLength(stringToDouble("length in minutes: "));
        workoutRoutineList.add(workoutRoutine);
        print(String.format("Added %s (%.2f minutes)",workoutRoutine.getName(),workoutRoutine.getLength()));
        print("Press Enter to go back to the menu... ",false);
        scanner.nextLine();
    }
    private static void listAllWorkout() {
        if (!workoutRoutineList.isEmpty()){
            for (WorkoutRoutine workoutRoutine: workoutRoutineList){
                print(String.format("Added %s (%.2f minutes)",workoutRoutine.getName(),workoutRoutine.getLength()));
            }
        } else {print("there are no Workouts found in list");}
        print("Press Enter to go back to the menu... ",false);
        scanner.nextLine();
    }

}