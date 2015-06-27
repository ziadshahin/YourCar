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


public class databasenew extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private databaseAdapter TheAdapter;


    private Intent intent;
    private String Type;
    private String Table;
    private static final int URL_LOADER = 1;



    private String GetNumberCall(String types) {
        switch (types) {
            case ("Opel"):
                return "1111111111";
            case ("Mazda"):
                return "2222222222";
            case ("Audi"):
                return "3333333333";
            case ("Proton"):
                return "4444444444";
            case ("Mitsubishi"):
                return "5555555555";
            case ("Honda"):
                return "6666666666";
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

        final Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
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
