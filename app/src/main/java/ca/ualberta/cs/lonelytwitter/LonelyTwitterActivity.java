package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 *  This class is the main view class of the project. <br /> In this class, user interaction
 *  and file manipulation is performed.
 *  All files are in the form of "json" files that are stored in Emulator's access
 *  <ore>
 *      pre-formatted text: <br />
 *      	File Explorer -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> file.sav
 *  </ore>
 *  <code>
 *      begin <br />
 *      Some pseudo code <br />
 *      end.
 *  </code>
 *  The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
 *  <ul>
 *		<li>Item 1</li>
 *		<li>Item 2</li>
 *		<li>Item 3</li>
 *  </ul>
 * 	<ol>
 *		<li>Item 1</li>
 *		<li>Item 2</li>
 *		<li>Item 3</li>
 *  </ol>
 *
 *  @author pensk
 *  @version 1.0
 *  @see Tweet
 *  @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved in. The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile(String, Date()
	 */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {Date};
	private EditText bodyText;
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		try {
			Tweet tweet = new NormalTweet("My First Tweet.");
			tweet.setMessage("wao");
			ImportantTweet importantTweet = new ImportantTweet("Very Important");
			NormalTweet normalTweet = new NormalTweet("I'm Normal");

			ArrayList<Tweet> tweets = new ArrayList<Tweet>();
			tweets.add(tweet);
			tweets.add(importantTweet);
			tweets.add(normalTweet);
			importantTweet.addMood(new Happy());

			Happy happy = new Happy();
			happy.getDate();

		} catch (TweetTooLongException e) {
			e.printStackTrace();
		}

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = trimExtraSpaces(bodyText.getText().toString());
				saveInFile(text, new Date(System.currentTimeMillis()));
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Trims extra spaces using a regular expression.
	 * @param inputString
	 * @return String trimmed
     */
	private String trimExtraSpaces(String inputString){
		return inputString.replaceAll("\\s+", " ");
	}

	/**
	 * This method sorts the tweet list items and refreshes the adapter.
	 * @param ordering ordering to be used.
     */
	private void sortTweetListItems(TweetlistOrdering ordering){

	}

	/**
	 * Loads tweets from specified file.
	 * @throws TweetTooLongException if the Tweet's text is too long.
	 * @exception FileNotFoundException if the file is not created first.
     */
	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Saved tweets to a file in JSON format.
	 * @throws FileNotFoundException if the file folder does not exist.
     */
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}