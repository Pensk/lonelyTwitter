package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/14.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        if(tweets.indexOf(tweet) != -1){
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet){
        for(int x=0; x<tweets.size(); x++){
            if(tweets.get(x).equals(tweet)) { return true; }
        }
        return false;
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public int getCount(){
        return tweets.size();
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

}
