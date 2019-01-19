package main;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import model.Parking;
import security.Security;
import utils.GsonUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Main {

    private static int HTTP_COD_SUCESSO = 200;

    private static Gson gson;

    public static void main(String[] args) {

        Security security = new Security();

        String authToken = security.authToken("Admin", "admin");

        if(authToken !=null && !authToken.isEmpty()) {

            try {

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://localhost:8081/rest-ada/parkings")
                        .get()
                        .addHeader("Authorization", authToken)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("TestRest-Token", "ad2771a0-30ff-49e1-ace6-c9f4a8e99328")
                        .build();

                Response response = client.newCall(request).execute();

                String resStr = response.body().string();

                gson = new Gson();

                List<Parking> parkingList = GsonUtils.toList(resStr, Parking.class);


                System.out.println("");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
