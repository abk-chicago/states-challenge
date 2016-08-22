package com.andreakim.statesusa;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreakim on 8/22/16.
 */
public class StateAdapter extends ArrayAdapter{

List list = new ArrayList<>();

    public StateAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


}
