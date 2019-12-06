package com.example.myapplication_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    public static Room room1;
    public static Room room2;
    public static Room room3;
    private TextView txtView;

    String PlayMarkLink;
    //private TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(this);

        /*mTextView = (TextView)findViewById(R.id.textView);
        mTextView.setText("0");*/

        String def = "defoult, is 20 ";
        room1 = new Room(def);
        room2 = new Room(def);
        room3 = new Room(def);
        Button btnrm1 = findViewById(R.id.btnrm1);
        Button btnrm2 = findViewById(R.id.btnrm2);
        Button btnrm3 = findViewById(R.id.btnrm3);

        txtView = findViewById(R.id.text11);


        txtView = (TextView) findViewById(R.id.text11);

        btnrm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room1 = new Room((String.valueOf(seekBar.getProgress())));
            }
        });
        btnrm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room2 = new Room(txtView.getText().toString());
            }
        });
        btnrm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room3 = new Room(txtView.getText().toString());
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_rooms) {
            //Toast.makeText(getApplicationContext(), "LolText", Toast.LENGTH_LONG).show();

            //////////////CHANGE SCENE ////////////////////////////////////////////////
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_addroom) {
            //////////////CHANGE SCENE ////////////////////////////////////////////////
            Intent b = new Intent(MainActivity.this, Bluetooth.class);
            startActivity(b);

        } else if (id == R.id.nav_share) {
            Intent shareintent = new Intent();
            String shareBody = "Telegram";
            PlayMarkLink = "https://play.google.com/store";
            shareintent.setType("text/plain");
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_SUBJECT,PlayMarkLink);

            ///////////////////////////// For send button/////////////////////////////////////////
            //shareintent.putExtra(Intent.EXTRA_CHOOSER_TARGETS, shareBody);
            //shareintent.putExtra(Intent.EXTRA_INITIAL_INTENTS, myInitialIntentArray);
            //shareintent.putExtra(Intent.EXTRA_TEXT,shareBody);

            startActivity(Intent.createChooser(shareintent, "share via"));
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        txtView.setText(String.valueOf(seekBar.getProgress()));
    }
}
