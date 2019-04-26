package com.woman.orcas.myapplication;

import android.app.DownloadManager;
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
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import static android.view.View.LAYOUT_DIRECTION_RTL;

public class VideosActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v7.widget.Toolbar toolbar;
    //RECYCLER VIEW FIELD
    RecyclerView recyclerView;
    ArrayList<com.woman.orcas.myapplication.YoutubeVideo> videoDetailsArrayList;
    //VECTOR FOR VIDEO URLS
    Vector<com.woman.orcas.myapplication.YoutubeVideo> youtubeVideos = new Vector<com.woman.orcas.myapplication.YoutubeVideo>();
    String URL="http://2mr2a-fadila.org/cc/video.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        videoDetailsArrayList=new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


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

        showVideo();



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


    private void showVideo() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray JA = new JSONArray(response);
                    for (int i = 0; i < JA.length(); i++) {
                        JSONObject JO = (JSONObject) JA.get(i);

                        com.woman.orcas.myapplication.YoutubeVideo videoDetails=new com.woman.orcas.myapplication.YoutubeVideo();
                        // JO.getString("img_add_v")

                        // JO.getString("img_add_v")
                        String x=JO.getString("link");
                        videoDetails.setURL("<iframe width=\"100%\" " +
                                "height=\"100%\" " +
                                "src=\"https://www.youtube.com/embed/"+x+"\" " +
                                "frameborder=\"0\"" +
                                " allowfullscreen></iframe>" );
                        videoDetails.setVideoName(JO.getString("title_v"));
                        videoDetails.setVideoDesc(JO.getString("title_v"));
                        videoDetails.setVideoId(JO.getString("link"));
                       // Toast.makeText(getApplicationContext(), JO.getString("img_add_v"),Toast.LENGTH_SHORT).show();
                        videoDetailsArrayList.add(videoDetails);
                    }
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                    recyclerView.setLayoutManager(layoutManager);
                    VideoAdapter videoAdapter = new VideoAdapter(videoDetailsArrayList);
                    recyclerView.setAdapter(videoAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this, Main2Activity.class);
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

            Intent i = new Intent(this,For_you.class);
            startActivity(i);

        }
        else if (id == R.id.written) {
            Intent i = new Intent(this, com.woman.orcas.myapplication.WritenThought.class);
            startActivity(i);
        }
        else if (id == R.id.albums) {
            Intent i = new Intent(this,Pictures.class);
            startActivity(i);
        }
        else if (id == R.id.videos) {
            Intent i = new Intent(this,VideosActivity.class);
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
