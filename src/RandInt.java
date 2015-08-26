package baccarat;
import java.util.Random;

/**
 * Uses the Random API to retrieve an integer between 1 - 13.
 * Written:  Kevin Wilson

 */
public class RandInt {

    public static Integer getNum() {

        Random rand = new Random();

        return rand.nextInt(13) + 1;

    }
}