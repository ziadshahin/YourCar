package com.example.ziad.yourcar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;


public class Logos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        getSupportActionBar().hide();




        final ImageView img1 = (ImageView) findViewById(R.id.imageView3);
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Opel database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Opel");
                startActivity(intent);
            }
        });


        final ImageView img2 = (ImageView) findViewById(R.id.imageView4);
        img2.setOnClickListener(new View.OnClickListener()

                                {
                                    public void onClick(View v) {
                                        Toast.makeText(Logos.this, "Opening Mazda database", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Logos.this, databasenew.class)
                                                .putExtra(Intent.EXTRA_TEXT,"Mazda");
                                        startActivity(intent);
                                    }
        });

        final ImageView img3 = (ImageView) findViewById(R.id.imageView5);
        img3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Audi database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Audi");
                startActivity(intent);
            }
        });


        final ImageView img4 = (ImageView) findViewById(R.id.imageView6);
        img4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Proton database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Proton");
                startActivity(intent);
            }
        });

        final ImageView img5 = (ImageView) findViewById(R.id.imageView7);
        img5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Mitsubishi database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Mitsubishi");
                startActivity(intent);
            }
        });

        final ImageView img6 = (ImageView) findViewById(R.id.imageView8);
        img6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Honda database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Honda");
                startActivity(intent);
            }
        });

        final ImageView img7 = (ImageView) findViewById(R.id.imageView);
        img7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Toyota database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Toyota");
                startActivity(intent);
            }
        });

        final ImageView img8 = (ImageView) findViewById(R.id.imageView12);
        img8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Chevorlet database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Chevorlet");
                startActivity(intent);
            }
        });

        final ImageView img9 = (ImageView) findViewById(R.id.imageView13);
        img9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Kia database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Kia");
                startActivity(intent);
            }
        });

        final ImageView img10 = (ImageView) findViewById(R.id.imageView14);
        img10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Peugeot database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Peugeot");
                startActivity(intent);
            }
        });

        final ImageView img11 = (ImageView) findViewById(R.id.imageView15);
        img11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Seat database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Seat");
                startActivity(intent);
            }
        });


        final ImageView img12 = (ImageView) findViewById(R.id.imageView16);
        img12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Logos.this, "Opening Volvo database", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Logos.this, databasenew.class)
                        .putExtra(Intent.EXTRA_TEXT,"Volvo");
                startActivity(intent);
            }
        });



        final Switch swi = (Switch) findViewById(R.id.switch2);
        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onBackPressed();

            }
        });
        final ImageView img = (ImageView) findViewById(R.id.imageView10);
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
        getMenuInflater().inflate(R.menu.menu_logos, menu);
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
