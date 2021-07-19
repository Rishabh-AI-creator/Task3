package DailyTask;

import java.util.LinkedList;

public class Consumer extends Thread {
    Producer producer;
    LinkedList<Character> characters;
    String str;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true) {
            try {
               str = producer.popCharacter();
               Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
