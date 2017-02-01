package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * A very normal tweet.
 */

public class NormalTweet extends Tweet {
    /**
     * Instantiates a new tweet.
     * @param date the date of the tweet.
     * @param message The tweet's message.
     * @throws TweetTooLongException
     */
    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new tweet with a default date.
     * @param message The tweet's message.
     * @throws TweetTooLongException
     */
    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * This is just a normal tweet!
     * @return False
     */
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
