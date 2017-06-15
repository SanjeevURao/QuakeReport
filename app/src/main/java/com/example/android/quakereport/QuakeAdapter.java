package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanjeev on 15/6/17.
 */

public class QuakeAdapter extends ArrayAdapter<Earthquake> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquake currentWord = getItem(position);
        TextView magnitude = (TextView)listItemView.findViewById(R.id.mag);
        magnitude.setText(currentWord.getMag());
        TextView place = (TextView)listItemView.findViewById(R.id.place);
        place.setText(currentWord.getPlace());
        TextView time = (TextView)listItemView.findViewById(R.id.time);
        time.setText(currentWord.getTime());
        return listItemView;


    }
    private static final String LOG_TAG = QuakeAdapter.class.getSimpleName();

    public QuakeAdapter(Activity context, ArrayList<Earthquake> words ) {

        super(context, 0, words);


    }
}