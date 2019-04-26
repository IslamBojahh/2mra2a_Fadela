package com.woman.orcas.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;

import static android.view.View.LAYOUT_DIRECTION_RTL;

public class aboutApp extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // toolbar.setLayoutDirection(LAYOUT_DIRECTION_RTL);

        //cc1=(ImageButton)findViewById(R.id.cc1);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.setLayoutDirection(LAYOUT_DIRECTION_RTL);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view=navigationView.getHeaderView(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.backarrow) {
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.Main2Activity.class);
            startActivity(i);

        }
        else if (id == R.id.nav_womanchris) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.Woman_christ.class);
            startActivity(i);

        }
        else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(this,com.woman.orcas.myapplication.Calender.class);
            startActivity(i);}
        else if (id == R.id.nav_for_you) {

            Intent i = new Intent(this, com.woman.orcas.myapplication.For_you.class);
            startActivity(i);

        }
        else if (id == R.id.written) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.WritenThought.class);
            startActivity(i);
        }
        else if (id == R.id.albums) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.Pictures.class);
            startActivity(i);
        }
        else if (id == R.id.videos) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.VideosActivity.class);
            startActivity(i);
        }

        else if (id == R.id.call_us) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.ContactUs.class);
            startActivity(i);
        }

        else if (id == R.id.about_us) {
            Intent i = new Intent(this,aboutApp.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
