package com.woman.orcas.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import static android.view.View.LAYOUT_DIRECTION_RTL;


public class Pictures extends AppCompatActivity implements AsyncRespones,NavigationView.OnNavigationItemSelectedListener  {
    android.support.v7.widget.Toolbar toolbar;
    boolean x=true;

    data_pictures data1=new data_pictures();



    public static TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        data1.delegate=this;
        data1.execute();
        // t1=(TextView) findViewById(R.id.textview);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLayoutDirection(LAYOUT_DIRECTION_RTL);

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

        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
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
    public void mydata(ArrayList<String> b1, ArrayList<String> b2, ArrayList<String> b3) {

    ArrayList<albumItem> theimage = new ArrayList<>();

    for (int i = 0; i < b1.size(); i++) {
        albumItem createList = new albumItem();
        createList.setImage_title(b1.get(i));
        createList.setImage_ID(b2.get(i));
        createList.setText(b3.get(i));

        theimage.add(createList);
    }


    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.imagegallery);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
    recyclerView.setLayoutManager(layoutManager);
    AdapterAlbum adapter = new AdapterAlbum(getApplicationContext(), theimage);
    recyclerView.setAdapter(adapter);
        b1.clear();
        b2.clear();
        b3.clear();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_womanchris) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.Woman_christ.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(this,com.woman.orcas.myapplication.Calender.class);
            startActivity(i);
        } else if (id == R.id.nav_for_you) {

            Intent i = new Intent(this, For_you.class);
            startActivity(i);

        } else if (id == R.id.written) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.WritenThought.class);
            startActivity(i);
        } else if (id == R.id.albums) {
            Intent i = new Intent(this, Pictures.class);
            startActivity(i);
        } else if (id == R.id.videos) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.VideosActivity.class);
            startActivity(i);
        } else if (id == R.id.call_us) {
            Intent i = new Intent(this, ContactUs.class);
            startActivity(i);
        } else if (id == R.id.about_us) {
            Intent i = new Intent(this, aboutApp.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}

