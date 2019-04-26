package com.woman.orcas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

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

public class ChannelActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<com.woman.orcas.myapplication.YoutubeVideo> videoDetailsArrayList;
    com.woman.orcas.myapplication.VideoAdapter customListAdapter;
    String searchName;
    String TAG="ChannelActivity";
    //UC1NF71EwP41VdjAU1iXdLkw
    // UC9CYT9gSNLevX5ey2_6CK0Q
    String URL="http://2mr2a-fadila.org/cc/video.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        videoDetailsArrayList=new ArrayList<>();
        customListAdapter=new com.woman.orcas.myapplication.VideoAdapter(videoDetailsArrayList);
        showVideo();

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

                        videoDetails.setURL( JO.getString("img_add_v"));
                        videoDetails.setVideoName(JO.getString("title_v"));
                        videoDetails.setVideoDesc(JO.getString("title_v"));
                        videoDetails.setVideoId(JO.getString("link"));

                        videoDetailsArrayList.add(videoDetails);
                    }

                    recyclerView.setAdapter(customListAdapter);
                    customListAdapter.notifyDataSetChanged();
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
}
