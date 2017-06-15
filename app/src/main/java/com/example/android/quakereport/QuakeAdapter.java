package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.

        TextView magnitudeView = (TextView)listItemView.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        Double mMagnitude = currentWord.getMag();
        DecimalFormat decimalformat = new DecimalFormat("0.00");
        String magStr = decimalformat.format(mMagnitude);
        magnitudeView.setText(magStr);


        TextView place = (TextView)listItemView.findViewById(R.id.offset);
        String p =currentWord.getPlace();
        /*Log.v("NumbersActivity", "Place = " + p);*/
        String offset , primary;
        int breakPoint = p.indexOf("of");
        if(breakPoint!=-1)
        {
            breakPoint+=2;
            offset=p.substring(0,breakPoint);
            primary=p.substring(breakPoint,p.length());

        }
        else
        {
            offset="Near The";
            primary=p;
        }
//        Log.v("NumbersActivity", "offset = " + offset);
//        Log.v("NumbersActivity", "primary = " + primary);
        place.setText(offset);
        TextView prim = (TextView)listItemView.findViewById(R.id.primary);
        prim.setText(primary);

        Date dateObj = new Date(currentWord.getTime());
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);
        String dateStr = formatDate(dateObj);
        dateView.setText(dateStr);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);

        String timeStr = formatTime(dateObj);

        timeView.setText(timeStr);
        return listItemView;


    }
    private static final String LOG_TAG = QuakeAdapter.class.getSimpleName();

    public QuakeAdapter(Activity context, ArrayList<Earthquake> words ) {

        super(context, 0, words);


    }

    public String formatDate(Date obj)
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("LLL dd , yyyy");
        return dateformat.format(obj);
    }

    public String formatTime(Date obj)
    {
        SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
        return timeformat.format(obj);
    }

    public int getMagnitudeColor(double mag)
    {    int m = (int) Math.floor(mag);
        int mid;
        Log.v("NumbersActivity", "m= = " + m);
        switch(m )
        {   case 0 :
            case 1 :

                mid = R.color.magnitude1;
                break;

            case 2:
                mid = R.color.magnitude2;
                break;


            case 3:
                mid = R.color.magnitude3;
                break;

            case 4:
                mid =  R.color.magnitude4;
                break;

            case 5:
                mid =  R.color.magnitude5;
                break;

            case 6:
                mid =  R.color.magnitude6;
                break;

            case 7:
                mid =  R.color.magnitude7;
                break;

            case 8:
                mid =  R.color.magnitude8;
                break;

            case 9:
                mid =  R.color.magnitude9;
                break;

            default:
                mid =  R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), mid);

    }
}