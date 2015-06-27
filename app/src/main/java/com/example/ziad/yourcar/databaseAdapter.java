package com.example.ziad.yourcar;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Ziad on 25/06/2015.
 */
public class databaseAdapter extends CursorAdapter
{


    public databaseAdapter(Context context, Cursor c, int flags) {

        super(context, c, flags);
    }



    public static class ViewHolder {
        public final TextView Name;
        public final TextView Price;
        public final TextView Power;


        public ViewHolder(View view) {

            Name = (TextView) view.findViewById(R.id.textView5);
            Price = (TextView) view.findViewById(R.id.textView6);
            Power = (TextView) view.findViewById(R.id.textView7);

        }
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {



        View view = LayoutInflater.from(context).inflate(R.layout.last, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }





    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        String Name = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
        Integer Price = cursor.getInt(cursor.getColumnIndexOrThrow("Price"));
        Integer Power = cursor.getInt(cursor.getColumnIndexOrThrow("Power"));


        viewHolder.Name.setText(Name);
        viewHolder.Price.setText(String.valueOf(Price));
        viewHolder.Power.setText(String.valueOf(Power));


    }




}