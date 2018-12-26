package moera.ermais.google.com.tanuki;

import moera.ermais.google.com.tanuki.entity.request.Request;
import moera.ermais.google.com.tanuki.entity.response.Reply;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST
    Call<Reply> reply
            (@Body Request request);
}
