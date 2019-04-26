package com.woman.orcas.myapplication;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Picture;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import static android.view.View.LAYOUT_DIRECTION_RTL;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    LinearLayout silderdots;
    Toolbar toolbar;
    GridView maingrid;
    CardView cw1,cw2,cw3,cw4,cw5,cw6,cw7,cw8,cw9,cw10;
    ImageButton cc1;

    public static  String aya="connect to internet";
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://2mr2a-fadila.org/cc/ayatoday.php");
                Log.d("cffffffffffffff","ddddddddddddddddddddddddddddd");
            }
        });


        cw1=(CardView) findViewById(R.id.cw1);
        cw2=(CardView) findViewById(R.id.cw2);
        cw3=(CardView) findViewById(R.id.cw3);
        cw4=(CardView) findViewById(R.id.cw4);
        cw5=(CardView) findViewById(R.id.cw5);
        cw6=(CardView) findViewById(R.id.cw6);
        cw7=(CardView) findViewById(R.id.cw7);
        cw8=(CardView) findViewById(R.id.cw8);
        cw9=(CardView) findViewById(R.id.cw9);
        cw10=(CardView) findViewById(R.id.cw10);

        cw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
        cw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.woman.orcas.myapplication.Woman_christ.class);
                startActivity(i);
            }
        });
        cw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.woman.orcas.myapplication.Calender.class);
                startActivity(i);
            }
        });

        cw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),For_you.class);
                startActivity(i);
            }
        });

        cw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.woman.orcas.myapplication.WritenThought.class);
                startActivity(i);
            }
        });
        cw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.woman.orcas.myapplication.VideosActivity.class);
                startActivity(i);
            }
        });

      cw7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), com.woman.orcas.myapplication.Pictures.class);
                startActivity(i);
            }
        }) ;
        cw8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ContactUs.class);
                startActivity(i);
            }
        }) ;
        cw9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),aboutApp.class);
                startActivity(i);
            }
        }) ;

        cw10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NotificationActivity.class);
                i.putExtra("aya",aya);
                i.putExtra("name","آية اليوم");
                startActivity(i);
            }
        }) ;
        //viewPager =(ViewPager) findViewById(R.id.viewPager);
        //ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
       // viewPager.setAdapter(viewPagerAdapter);

        //maingrid=(GridView)findViewById(R.id.mainGrid);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
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


    ArrayList<com.woman.orcas.myapplication.notification_products> arrayList = new ArrayList<>();

    class ReadJSON extends AsyncTask<String, Integer, String> {

        String ss;

        @Override
        protected String doInBackground(String... params) {

            return readingURL(params[0]);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String content) {
            try {
                JSONArray JA = new JSONArray(content);
                for (int i = 0; i < JA.length(); i++) {
                    JSONObject JO = (JSONObject) JA.get(i);

                    arrayList.add(new com.woman.orcas.myapplication.notification_products(
                            JO.getString("aya")

                    ));
                    ss = JO.getString("aya");
                    aya=ss;
                    Log.d("cffffffffffffff",ss);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            Intent notificationIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
            notificationIntent.putExtra("aya",ss);
            notificationIntent.putExtra("name","آية اليوم");

            PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR,8);
            cal.set(Calendar.SECOND, 5);
            cal.set(Calendar.MINUTE,5);


            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

           // Intent aya=new Intent(getApplicationContext(),ayaToday.class);
           // aya.putExtra("aya",aya);


        }

    }

    private static String readingURL(String theURL) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theURL);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                content.append(line + "\n");

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();

    }
}
