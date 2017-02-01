package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * Defines the Sad mood.
 */

public class Sad extends Mood {
    /**
     * Define a new sad mood.
     */
    public Sad() {
        super();
    }

    /**
     * Define a new sad mood and give it a date.
     * @param date the date of the mood.
     */
    public Sad(Date date) {
        super(date);
    }

    /**
     * Format this mood into a string.
     * @return String the mood
     */
    public String format() {
        return "Sad";
    }
}
