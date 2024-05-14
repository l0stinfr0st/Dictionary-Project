package dictionaryProject;

import java.io.*;
import java.util.*;

public class test {

    public static Dictionary d;

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my dictionary!");
        int choice = 1;
        while (choice != 0) {
            System.out.println("");
            System.out.println("Please select one of the following options: ");
            System.out.println("");
            System.out.println("1) Input a text file to load as a dictionary");
            System.out.println("2) Search a word in our database");
            System.out.println("3) Insert a word into our database");
            System.out.println("4) Remove a word from our database");
            System.out.println("5) Input a text file to spell check");
            System.out.println("0) Exit the dictionary :(");
            System.out.println("");
            System.out.print("Choice: ");
            choice = input.nextInt();
            System.out.println("");
            switch (choice) {
                case 1: //Load text file
                    System.out.print("Enter file name: ");
                    d = new Dictionary(new File(input.next()));
                    System.out.println("Dictionary initialized");
                    break;
                case 2: //Search word
                    if (d == null) {
                        System.out.println("Initialize the dictionary first by choosing option 1");
                        break;
                    }
                    System.out.print("Enter a word to search: ");
                    System.out.println(d.searchWord(input.next()));
                    break;
                case 3: //Insert word
                    if (d == null) {
                        System.out.println("Initialize the dictionary first by choosing option 1");
                        break;
                    }
                    System.out.print("Enter a word to be inserted: ");
                    d.insertWord(input.next());
                    System.out.println("Word successfully inserted");
                    break;
                case 4: //Remove word
                    if (d == null) {
                        System.out.println("Initialize the dictionary first by choosing option 1");
                        break;
                    }
                    System.out.print("Enter a word to be deleted: ");
                    d.removeWord(input.next());
                    System.out.println("Word successfully removed");
                    break;
                case 5: //Insert a text file to be spell checked
                    if (d == null) {
                        System.out.println("Initialize the dictionary first by choosing option 1");
                        break;
                    }
                    System.out.print("Enter file name to be spell checked: ");
                    d.checkSpelling(new File(input.next()));
            }
        }

    }
}
