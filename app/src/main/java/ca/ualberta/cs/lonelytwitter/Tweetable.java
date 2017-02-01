package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by pensk on 2017/01/17.
 * An interface for all tweets.
 */

public interface Tweetable {
    /**
     * Tweets should have messages
     * @return String
     */
    public String getMessage();

    /**
     * Tweets should have dates.
     * @return
     */
    public Date getDate();
}
