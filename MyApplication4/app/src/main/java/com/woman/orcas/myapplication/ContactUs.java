package com.woman.orcas.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

import static android.view.View.LAYOUT_DIRECTION_RTL;

public class ContactUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);




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

      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View view=navigationView.getHeaderView(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

      /*  ImageView imageView =(ImageView)findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });*/

        CardView fb= (CardView) findViewById(R.id.cc1);
        CardView tw= (CardView) findViewById(R.id.cc2);
        CardView ph= (CardView) findViewById(R.id.cc3);
        CardView web= (CardView) findViewById(R.id.cc4);
        CardView skype= (CardView) findViewById(R.id.cc5);
        CardView email= (CardView) findViewById(R.id.cc6);





        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = null;
                try {
                    getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    String url = "https://www.facebook.com/Murasala.net/";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href="+url));
                } catch (Exception e) {
                    // no Facebook app, revert to browser
                    String url ="https://www.facebook.com/Murasala.net/";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent .setData(Uri.parse(url));
                }
                startActivity(intent);
            }
        });

        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = null;
                try {
                    getPackageManager().getPackageInfo("com.twitter.android", 0);
                    String url = "https://twitter.com/womanapp";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user/f?href="+url));
                } catch (Exception e) {
                    String url ="https://twitter.com/womanapp";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent .setData(Uri.parse(url));
                }

                startActivity(intent);
            }
        });

        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String dial = "tel:" +"0526282170";
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                    Toast.makeText(getApplicationContext(), "Enter a phone number", Toast.LENGTH_SHORT).show();

            }
        });


        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = null;
                    String url ="http://www.murasala.net/WomanApp/";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent .setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent skype_intent = new Intent("android.intent.action.VIEW");
                skype_intent.setClassName("com.skype.raider", "com.skype.raider.Main");
                skype_intent.setData(Uri.parse("skype:murasala.net"));
                startActivity(skype_intent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" +"mashora@life-agape.org"));
                startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
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
            Intent i = new Intent(this,ContactUs.class);
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

