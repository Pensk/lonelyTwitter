package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * Defines tweets.
 */
public abstract class Tweet implements Tweetable {
    private Date date;
    private String message;
    private ArrayList<Mood> moods;

    /**
     * Construct a tweet with a custom date and message.
     * @param date
     * @param message
     * @throws TweetTooLongException
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
    }

    /**
     * Construct a tweet with a custom message and the current date.
     * @param message
     * @throws TweetTooLongException
     */
    public Tweet(String message) throws TweetTooLongException {
        this.date = new Date();
        this.setMessage(message);
    }

    /**
     * Return the tweet's message
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Update the tweet's message
     * @param message the new message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 144){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    /**
     * Return the Tweet's date
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Update the tweet's date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Assign a mood to this tweet
     * @param mood
     */
    public void addMood(Mood mood){
        moods.add(mood);
    }

    /**
     * Is this tweet normal or important?
     * @return Boolean
     */
    public abstract Boolean isImportant();
}


