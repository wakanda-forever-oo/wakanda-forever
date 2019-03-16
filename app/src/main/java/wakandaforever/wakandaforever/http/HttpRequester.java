package wakandaforever.wakandaforever.http;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import okhttp3.ResponseBody;
import wakandaforever.wakandaforever.models.FarmObject;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String body) throws IOException;

    List<FarmObject> getAllFarmObjects();
}

