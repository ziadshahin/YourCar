package com.example.ziad.yourcar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;


public class databasenew extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private databaseAdapter TheAdapter;


    private Intent intent;
    private String Type;
    private String Table;
    private static final int URL_LOADER = 1;



    private String GetNumberCall(String types) {
        switch (types) {
            case ("Opel"):
                return "+20 2 33086777";
            case ("Mazda"):
                return "+20 16670";
            case ("Audi"):
                return " 012 110 710 72";
            case ("Proton"):
                return "+20 19399";
            case ("Mitsubishi"):
                return "+20 16606";
            case ("Honda"):
                return "+20 2 26119811";
            case ("Chevrolet"):
                return "+20 16424";
            case ("Kia"):
                return "+20 19949";
            case ("Peugeot"):
                return "+20 19207";
            case ("Seat"):
                return "+20 19178";
            case ("Toyota"):
                return "+20 2 24880400";
            case ("Volvo"):
                return "+20 019 55 00 111";
            default:
                return "0";

        }
    }

    private String GetNumber(String tablename) {
        switch (tablename) {
            case ("Opel"):
                return "1";
            case ("Mazda"):
                return "2";
            case ("Audi"):
                return "3";
            case ("Proton"):
                return "4";
            case ("Mitsubishi"):
                return "5";
            case ("Honda"):
                return "6";
            case ("Chevrolet"):
                return "7";
            case ("Kia"):
                return "8";
            case ("Peugeot"):
                return "9";
            case ("Seat"):
                return "10";
            case ("Toyota"):
                return "11";
            case ("Volvo"):
                return "12";
            default:
                return "0";

        }
    }

    private String GetLocation(String tablename) {
        switch (tablename) {
            case ("Opel"):
                return "geo:30.056643,31.204324?q=30.056643,31.204324";
            case ("Mazda"):
                return "geo:30.0562242,31.2372846?q=30.0562242,31.2372846";
            case ("Audi"):
                return "geo:29.9571603,31.2511569?q=29.9571603,31.2511569";
            case ("Proton"):
                return "geo:30.0483256,31.2143084?q=30.0483256,31.2143084";
            case ("Mitsubishi"):
                return "geo:30.0607186,31.0310394?q=30.0607186,31.0310394";
            case ("Honda"):
                return "geo:30.0632989,31.204874?q=30.0632989,31.204874";
            case ("Chevrolet"):
                return "geo:30.056643,31.204324?q=30.056643,31.204324";
            case ("Kia"):
                return "geo:30.0564572,31.2020726?q=30.0564572,31.2020726";
            case ("Peugeot"):
                return "geo:30.0618096,31.2840588?q=30.0618096,31.2840588";
            case ("Seat"):
                return "geo:30.0742121,31.2483291?q=30.0742121,31.2483291";
            case ("Toyota"):
                return "geo:30.0634045,31.2821344?q=30.0634045,31.2821344";
            case ("Volvo"):
                return "geo:30.0484462,31.2374613?q=30.0484462,31.2374613";
            default:
                return "0";

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalchoose);
        getSupportActionBar().hide();


        intent = this.getIntent();
        Type = intent.getStringExtra(Intent.EXTRA_TEXT);
        Table = GetNumber(Type);


        getSupportLoaderManager().initLoader(URL_LOADER, null, this);


        TheAdapter = new databaseAdapter(this, null, 0);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(TheAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TextView ay = (TextView) view.findViewById(R.id.textView5);


                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setType("vnd.android-dir/mms-sms");
                sendIntent.putExtra("address", GetNumberCall(Type));
                sendIntent.putExtra("sms_body","Get your "+ Type +" " +ay.getText().toString() +" now!");

                startActivity(sendIntent);
            }
        });

        final Button but1 = (Button) findViewById(R.id.button2);
        but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, GetLocation(Type));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
            });


        final Button but2 = (Button) findViewById(R.id.button);
        but2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+GetNumberCall(Type)));
                    startActivity(callIntent);
                } catch (ActivityNotFoundException e) {
                    Log.e("Dialing reseller", "Call failed", e);
                }
            }

        });



        final ImageView img = (ImageView) findViewById(R.id.imageView11);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.contactcars.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_databasenew, menu);
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


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Uri uri = Uri.parse("content://com.example.ziad.yourcar/"+Table);

        return new CursorLoader(this, uri, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        TheAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        TheAdapter.swapCursor(null);
    }
}
