package com.example.ziad.yourcar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;


public class Welcome extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        getSupportActionBar().hide();


        final ListView types;
        types = (ListView) findViewById(R.id.listView);


        ArrayList<String> data = new ArrayList<String>();
        data.add("Opel");
        data.add("Mazda");
        data.add("Audi");
        data.add("Proton");
        data.add("Mitsubishi");
        data.add("Honda");


        ArrayAdapter<String> TypesAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.row, R.id.textView8, data);
        types.setAdapter(TypesAdapter);


        types.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(Welcome.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT, types.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });



        final Switch swi = (Switch) findViewById(R.id.switch1);
        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(Welcome.this, "Switching to logos", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Welcome.this, Logos.class);
                         swi.setChecked(false);
                        startActivity(intent);
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
                getMenuInflater().inflate(R.menu.menu_welcome, menu);
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
