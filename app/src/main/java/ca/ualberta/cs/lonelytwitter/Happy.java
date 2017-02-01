package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * Defines the Happy Mood
 */

public class Happy extends Mood {
    /**
     * Instantiates the Mood.
     */
    public Happy() {
        super();
    }

    /**
     * Returns this mood's date.
     * @param date
     */
    public Happy(Date date) {
        super(date);
    }

    /**
     * Formats the Mood.
     * @return a string representing the mood.
     */
    public String format() {
        return "Happy";
    }
}
