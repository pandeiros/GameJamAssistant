package com.wpam.gamejamapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by milor on 6/6/2016.
 */
public class HttpRequest extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... urls) {
        String dataUrl = "http://10.0.2.2:4000/auth/session";
//                String dataUrlParameters = "email=" + "pp@gmail.com" + "&name=" + "priyabrat";
//                URL url = "http://localhost:4000/account";;
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(dataUrl);
// Create connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");

//                    urlConnection.setRequestProperty("Host", "android.schoolportal.gr");
            urlConnection.connect();
// Send request
//                    DataOutputStream wr = new DataOutputStream(
//                            connection.getOutputStream());
//                    wr.writeBytes(dataUrlParameters);
//                    wr.flush();
//                    wr.close();
// Get Response
            //Create JSONObject here
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("username", "panda");
            jsonParam.put("password", "r2d2c3po");
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonParam.toString());
            out.close();

            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                Log.e("RESPONSE", sb.toString());
                return sb.toString();

            } else {
                System.out.println(urlConnection.getResponseMessage());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

        return "ERROR";
    }

    protected void onPostExecute(Boolean result) {

    }
}
