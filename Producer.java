package DailyTask;

import java.util.LinkedList;

public class Producer extends Thread {
      LinkedList<Character> characters;
      String str;
      final int length = 5;

    public Producer(LinkedList<Character> characters, String str) {
        this.characters = characters;
        this.str = str;
    }
    public synchronized void pushCharacters() throws InterruptedException {
        while(characters.size() == length){
           characters.wait();
        }
        for(int  i = 0; i < length; i++){
            characters.push(str.charAt(i));
        }
        characters.notify();
    }

    public synchronized String popCharacter() throws InterruptedException {
        characters.notify();
        while(characters.isEmpty()){
            characters.wait();
        }
        while(characters.peekLast() != null){
            str += characters.pop();
        }
        return str;
    }
    @Override
    public void run() {
        while(true) {
            try {
                pushCharacters();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
