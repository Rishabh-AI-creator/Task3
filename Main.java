package DailyTask;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LinkedList<Character> characters = new LinkedList<>();

        Producer producer = new Producer(characters,str);
        producer.start();

        Consumer consumer = new Consumer(producer);
        consumer.start();
    }
}
