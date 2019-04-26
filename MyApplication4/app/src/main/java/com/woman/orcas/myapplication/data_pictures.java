package com.woman.orcas.myapplication;

import android.os.AsyncTask;

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

/**
 * Created by ORCAS_ISLAM on 1/24/2018.
 */


public class data_pictures extends AsyncTask<Void,Void,Void> {

    public AsyncRespones delegate=null;
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    public static ArrayList<String> data1 = new ArrayList<>();
    public static ArrayList<String> data2 = new ArrayList<>();
    public static ArrayList<String> data3 = new ArrayList<>();

    @Override

    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://2mr2a-fadila.org/cc/img.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =
                        "" + JO.get("title_i") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";
                data1.add(dataParsed);
                dataParsed = "";
            }
            dataParsed = "";
            JSONArray JA2 = new JSONArray(data);
            for (int i = 0; i < JA2.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =

                        "" + JO.get("add_i") + "\n";


                dataParsed = dataParsed + singleParsed + "\n";

                data2.add(dataParsed);
                dataParsed = "";
            }
            dataParsed = "";
            JSONArray JA3 = new JSONArray(data);
            for (int i = 0; i < JA3.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =

                        "" + JO.get("text_i") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";

                data3.add(dataParsed);
                dataParsed = "";
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        // MainActivity.t1.setText(data2.get(0));

        delegate.mydata(data1,data2,data3);
    }
}
