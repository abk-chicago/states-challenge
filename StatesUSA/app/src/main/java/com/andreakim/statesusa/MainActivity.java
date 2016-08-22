package com.andreakim.statesusa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private AdapterView.OnItemClickListener mClickListener;

    Intent mDetailIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mFlag = (ImageView) findViewById(R.id.flag);
//        Picasso.with(this)
//                .load(R.drawable.flagplaceholder)
//                .resize(60, 60)
//                .into(mFlag);

        ArrayList<HashMap<String, String>> mStateList;
        mStateList = new ArrayList<>();
        mListView = (ListView) findViewById(R.id.states_list_view);

        ArrayAdapter<HashMap<String, String>> mArrayAdapter;
        mArrayAdapter = new ArrayAdapter<>(this, R.layout.list_row_item, mStateList);
        mListView.setAdapter(mArrayAdapter);
        mDetailIntent = new Intent(this, DetailStateActivity.class);
        mClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(mDetailIntent);
            }
        };
        mListView.setOnItemClickListener(mClickListener);


    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream stream = getAssets().open("States.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        return json;
    }


    private ArrayList<HashMap<String, String>> ParseJSON(String json) {
        if (json != null) {
            try {
                JSONObject JSONobj = new JSONObject(loadJSONFromAsset());
                JSONArray states_list = JSONobj.getJSONArray("states");

                for (int i = 0; i < states_list.length(); i++) {
                    JSONObject jsonState = states_list.getJSONObject(i);

                    String name = jsonState.getString("name");
                    String abbreviation = jsonState.getString("abbreviation");

                    HashMap<String, String> eachstate = new HashMap<>();
                    eachstate.put("name", name);
                    eachstate.put("abbreviation", abbreviation);

                  // states_list.add(eachstate);
                }
            } catch (JSONException jse) {
                jse.printStackTrace();
                return null;
            }
        }
        return null;
    }



}

