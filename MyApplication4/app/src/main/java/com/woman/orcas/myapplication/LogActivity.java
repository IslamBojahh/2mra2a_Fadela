package com.woman.orcas.myapplication;

import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

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

import static android.view.View.*;
import static com.woman.orcas.myapplication.R.anim.fadein;

public class LogActivity extends AppCompatActivity {
    private ImageView m1;
    private TextView t1;

    ArrayList<event_product> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://2mr2a-fadila.org/cc/event.php");
            }
        });


        m1=(ImageView)findViewById(R.id.log_img);

        final Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);

        m1.startAnimation(myanim);

        final Intent i=new Intent(this, com.woman.orcas.myapplication.MainActivity.class);

        Thread timer =new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();



    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        String ss=null;
        String ss2=null;
        String ss3=null;
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

                    arrayList.add(new event_product(
                            JO.getString("name_c")

                    ));
                    //  ss = JO.getString("name_c");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //   s1.setText("jfnsvbwd");



            int m= arrayList.size();



            if(m==0){ss=null;ss2=null;ss3=null;}
            else if(m==1){ss=arrayList.get(0).getName_c();ss2=null;ss3=null;}
            else if(m==2){ss=arrayList.get(0).getName_c();ss2=arrayList.get(1).getName_c();ss3=null;}
            else if(m>2){ss=arrayList.get(0).getName_c();ss2=arrayList.get(1).getName_c();ss3=arrayList.get(2).getName_c();}
            // ss =arrayList.get(0).getName_c();

            while (ss != null) {
                Log.i("dscfjcv", arrayList.get(0).getName_c());
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent notificationIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
                notificationIntent.putExtra("aya", ss);
                notificationIntent.putExtra("name","مناسبات اليوم");

                PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR, 9);
                cal.set(Calendar.SECOND, 5);
                cal.set(Calendar.MINUTE,00);

                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                ss=null;



            }

            while (ss2 != null) {
                Log.i("dscfjcv", arrayList.get(1).getName_c());

                AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent notificationIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
                notificationIntent.putExtra("aya", ss2);

                PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR, 9);
                cal.set(Calendar.SECOND, 5);
                cal.set(Calendar.MINUTE,5);

                alarmManager1.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                ss2=null;


            }

            if (ss3 != null) {
                Log.i("dscfjcv", arrayList.get(2).getName_c());

                AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                Intent notificationIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
                notificationIntent.putExtra("aya", ss3);

                PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR, 9);
                cal.set(Calendar.SECOND, 5);
                cal.set(Calendar.MINUTE, 10);

                alarmManager2.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                ss3=null;
            }

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
