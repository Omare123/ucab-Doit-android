package example.omare.com.doit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService{
    @POST("users")
    Call<User> createAccount(@Body User user);
}