import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;

import java.io.IOException;

import java.sql.SQLOutput;

public class httpclient_GET {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        try{
            HttpGet request = new HttpGet("https://gorest.co.in/public/v2/posts");

            CloseableHttpResponse response=httpClient.execute(request);

            try{
                System.out.println(response.getProtocolVersion());
                System.out.println(response.getStatusLine().getStatusCode());;
                System.out.println(response.getStatusLine().getReasonPhrase());
                System.out.println("RESPONSE" + response.getStatusLine().toString());

                HttpEntity entity=response.getEntity();
                if(entity!=null){
                    String result = EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
        }finally {
            httpClient.close();
        }
    }

}
