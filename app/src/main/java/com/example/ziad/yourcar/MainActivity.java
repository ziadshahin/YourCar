package com.example.ziad.yourcar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {



    private String DB_NAME = "Carsdb.sqlite";
    private String DB_PATH = "/data/data/com.example.ziad.yourcar/";
    private String DB_DIR_PATH = "/data/data/com.example.ziad.yourcar/databases";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        getSupportActionBar().hide();
        StoreDatabase();



        final ImageView img = (ImageView) findViewById(R.id.imageView9);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
            }
            });

        final ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setOnClickListener(new View.OnClickListener() {
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





    private void StoreDatabase() {
        try {
            //create the directory "databases"
            File databases_dir = new File(DB_DIR_PATH);
            databases_dir.mkdirs();
            File DbFile = new File(DB_PATH + DB_NAME);
            if (!DbFile.exists()) {
                DbFile.createNewFile();
                //open the file in the assets
                InputStream is = this.getAssets().open(DB_NAME);
                FileOutputStream fos = new FileOutputStream(DbFile);
                //copy from the file in the asset to the file in the databases
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0)
                    fos.write(buffer,0,length );
                //close both files
                fos.flush();
                fos.close();
                is.close();
                DbFile.renameTo(this.getDatabasePath("Carsdb.sqlite"));
            }
            else
            {
                Toast.makeText(MainActivity.this, "File already exists", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e) {
            Toast.makeText(MainActivity.this, "Error in attachment", Toast.LENGTH_SHORT).show();
        }
    }
}
