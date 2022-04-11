import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpurl_POST {

    public static void main(String[] args) throws IOException {
        String url="https://gorest.co.in/public/v2/users";
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Bearer 1d223849ee348038c8ab3078d4759c2f9fab5b81921da28db3027fe25dfa1c27");
        con.setRequestMethod("POST");

        JSONObject cred   = new JSONObject();


        cred.put("name","Deeksha");
        cred.put("email", "singhdeeksha1511@gmail.com");
        cred.put("gender","female");
        cred.put("status","active");



        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(cred.toString());
        wr.flush();



        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }



    }
}