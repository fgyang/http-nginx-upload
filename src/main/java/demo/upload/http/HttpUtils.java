package demo.upload.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

public class HttpUtils {
    private static final String HTTP_FILE_UPLOAD_KEY = "file";
    private static final String HTTP_PHRASE_STATUS_OK = "OK";

    public static boolean post(File file, String url) {
        FileBody body;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        if (file != null) {
            body = new FileBody(file);
        } else {
            return false;
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart(HTTP_FILE_UPLOAD_KEY, body);
        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            String reasonPhrase = statusLine.getReasonPhrase();
            int statusCode = statusLine.getStatusCode();

            if (HTTP_PHRASE_STATUS_OK.equals(reasonPhrase) && statusCode == 200) {
                return true;
            }

            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
