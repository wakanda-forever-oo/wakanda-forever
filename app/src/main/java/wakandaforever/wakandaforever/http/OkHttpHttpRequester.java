package wakandaforever.wakandaforever.http;

import android.os.StrictMode;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Illness;

public class OkHttpHttpRequester implements HttpRequester {
    public OkHttpHttpRequester() {

    }

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String body = response.body().string();
        return body;
    }

    @Override
    public String post(String url, String bodyString) throws IOException {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                bodyString
        );

        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request)
                .execute();

        String responseBody = response.body().string();
        return responseBody;
    }

    @Override
    public List<FarmObject> getAllFarmObjects() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //final MediaType JSON = MediaType.get("application/json; charset=utf-8");
//        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .url("http://80.240.21.133:7777/farm/all")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        Type listType = new TypeToken<ArrayList<FarmObject>>() {
        }.getType();
        ArrayList<FarmObject> productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsDetailsDtos;
    }

    public List<Illness> getIllnessFarmObject(long id) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //final MediaType JSON = MediaType.get("application/json; charset=utf-8");
//        ObjectMapper objectMapper = new ObjectMapper();
        Request request = new Request.Builder()
                .get()
                .url("http://80.240.21.133:7777/farm/all/" + id + "/illnesses")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = null;
        try {
            response = client.newCall(request)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody body2 = response.body();
        Type listType = new TypeToken<ArrayList<Illness>>() {
        }.getType();
        List<Illness> productsDetailsDtos = null;
        try {
            productsDetailsDtos = new Gson().fromJson(body2.string(), listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsDetailsDtos;
    }
}

