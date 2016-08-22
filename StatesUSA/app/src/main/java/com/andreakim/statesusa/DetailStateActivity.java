package com.andreakim.statesusa;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailStateActivity extends AppCompatActivity {

    public Intent mHomeIntent;
    Button mButton;
    private State mState;
    String json_string;


    TextView mAbbreviation;
    TextView mArea;
    TextView mCapital;
    ImageView mFlag;
    TextView mMostPopulousCity;
    TextView mName;
    TextView mPopulation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_state);
        mState = State.getInstance();

        mAbbreviation = (TextView) findViewById(R.id.state_abbreviation);
        mArea = (TextView) findViewById(R.id.state_area);
        mCapital = (TextView) findViewById(R.id.state_capital);
        mFlag = (ImageView) findViewById(R.id.flagImage);
        mMostPopulousCity = (TextView) findViewById(R.id.most_populous_city);
        mName = (TextView) findViewById(R.id.state_name);
        mPopulation = (TextView) findViewById(R.id.state_population);




        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomeIntent = new Intent(DetailStateActivity.this, MainActivity.class);
                startActivity(mHomeIntent);
            }
        });

        json_string = getIntent().getExtras().getString("states");


    }
}