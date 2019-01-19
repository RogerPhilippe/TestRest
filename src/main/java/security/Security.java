package security;

import com.squareup.okhttp.*;

public class Security {

    public String authToken(String username, String password) {

        int HTTP_COD_SUCESSO = 200;
        String result = null;
        String target = "Bearer ";

        try {

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"username\":\""+username+"\",\"password\":\"" +
                    password+"\"}");
            Request request = new Request.Builder()
                    .url("http://localhost:8081/rest-ada/login")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("TestRest-Token", "ad2771a0-30ff-49e1-ace6-c9f4a8e99328")
                    .build();

            Response response = client.newCall(request).execute();

            if(response.code() == HTTP_COD_SUCESSO) {

                String value = response.headers().get("Authorization");

                if(value != null && !value.isEmpty()) {

                    int index = value.indexOf(target);
                    int subIndex = index + target.length();

                    result = value.substring(subIndex);

                }

            }

        } catch (Exception er) { er.printStackTrace(); }

        return result;
    }

}
