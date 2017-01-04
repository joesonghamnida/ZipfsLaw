import entities.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by joe on 1/3/17.
 */
public class ReturnMostFrequentWords {

    public static Scanner scanner = new Scanner(System.in);

    public static void returnMostFrequentWords(HashMap<String, Integer> sortedWords) {
        System.out.println("Enter the number of word / value pairs you want to see: ");
        int count = Integer.parseInt(scanner.nextLine());

        ArrayList<Word> words = new ArrayList<>();

    }
}
