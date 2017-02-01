package ca.ualberta.cs.lonelytwitter;

/**
 * Created by pensk on 2017/01/17.
 * An exception for when tweets are too long.
 */

public class TweetTooLongException extends Exception {
    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }

    public TweetTooLongException() {
    }
}
