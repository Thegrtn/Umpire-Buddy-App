package com.example.nathaniel.myfirstapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mStrikesCount, mBallsCount;
    private static final String BALL_COUNT = "ball_count";
    private static final String STRIKE_COUNT = "strike_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Button mBallsButton;
        Button mStrikesButton;

        setContentView(R.layout.activity_main);

        //Check if values are stored in Bundle
        if (savedInstanceState != null) {
            mStrikesCount = savedInstanceState.getInt(STRIKE_COUNT);
            mBallsCount = savedInstanceState.getInt(BALL_COUNT);

            //Update Textview with stored values
            TextView Ballid = (TextView)findViewById(R.id.Ballid);
            Ballid.setText(String.valueOf(mStrikesCount));
            TextView Strikeid = (TextView)findViewById(R.id.Strikeid);
            Strikeid.setText(String.valueOf(mBallsCount));
        }
        mBallsButton = (Button) findViewById(R.id.Balls);
        mBallsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BallCount(0);
                if (mBallsCount >= 4) {
                    WalkDialog().show();
                    StrikeCount(1);
                    BallCount(1);
                }
            }
        });
        mStrikesButton = (Button) findViewById(R.id.Strikes);
        mStrikesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrikeCount(0);
                if (mStrikesCount >= 3) {
                    OutDialog().show();
                    StrikeCount(1);
                    BallCount(1);
                }
            }
        });


    }

    public AlertDialog WalkDialog() {
        AlertDialog.Builder WalkDialog = new AlertDialog.Builder(MainActivity.this);
        WalkDialog.setMessage(R.string.Walk);
        WalkDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicks OK
            }
        });
        return WalkDialog.create();
    }

    public AlertDialog OutDialog() {
        AlertDialog.Builder OutDialog = new AlertDialog.Builder(MainActivity.this);
        OutDialog.setMessage(R.string.Out);
        OutDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicks OK
            }
        });
        return OutDialog.create();
    }

    /*
    Parameters: int
    Note: if val == 0, then count increments by 1, else count is reset to 0.
     */
    public void BallCount(int val) {
        if (val == 0)
        {
            mBallsCount++;
        }
        else{
            mBallsCount = 0;
        }
        TextView Strikeid = (TextView)findViewById(R.id.Strikeid);
        Strikeid.setText(String.valueOf(mBallsCount));
    }

    /*
    Parameters: int val
    Note: if val == 0, then count increments by 1, else count is reset to 0.
     */
    public void StrikeCount(int val) {
        if (val == 0)
        {
            mStrikesCount++;
        }
        else{
            mStrikesCount = 0;
        }
        TextView Ballid = (TextView)findViewById(R.id.Ballid);
        Ballid.setText(String.valueOf(mStrikesCount));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(BALL_COUNT, mBallsCount);
        savedInstanceState.putInt(STRIKE_COUNT, mStrikesCount);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
