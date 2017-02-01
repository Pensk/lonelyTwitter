package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * Defines Moods' data and methods.
 */

public abstract class Mood {
    /**
     * The date of this mood.
     */
    private Date date;

    /**
     * Instantiates a new mood with a default date.
     */
    public Mood() {
        this.date = new Date();
    }

    /**
     * Instantiates a mood
     * @param date
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Returns the date of this mood
     * @return Date the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date for the mood.
     * @param date the new date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Formats the mood into a string.
     * @return String the mood
     */
    abstract public String format();
}
