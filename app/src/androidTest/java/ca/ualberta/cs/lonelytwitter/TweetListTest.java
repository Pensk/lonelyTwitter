package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by pensk on 2017/02/14.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("wao");

        tweets.add(tweet);

        try {
            tweets.add(tweet);
        } catch(Exception e){
            assertTrue(e instanceof IllegalArgumentException);
        }

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("wao");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet, tweet);
        assertEquals(returnedTweet.getDate(), tweet.getDate());
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("tweet1");
        Tweet tweet2 = new NormalTweet("tweet2");

        tweets.add(tweet1);
        tweets.add(tweet2);

        
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("wao");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();

        tweets.add(new NormalTweet("wao1"));
        tweets.add(new NormalTweet("wao2"));
        tweets.add(new NormalTweet("wao3"));

        assertEquals(tweets.getCount(), 3);
    }

}
