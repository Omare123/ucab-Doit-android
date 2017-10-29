package example.omare.com.doit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {
    EditText nombre, apellido, username, fechanacimiento, cedula, password;
    Button boton1,boton2;
    private String baseUrl = "https://doit-api.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_registro);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        username = (EditText) findViewById(R.id.username);
        fechanacimiento = (EditText) findViewById  (R.id.nacimiento);
        cedula = (EditText) findViewById(R.id.cedula);
        password = (EditText) findViewById(R.id.password);
        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(
                        nombre.getText().toString(),
                        apellido.getText().toString(),
                        fechanacimiento.getText().toString(),
                        password.getText().toString(),
                        username.getText().toString(),
                        cedula.getText().toString()
                );
                createAccount(user);
            }
        });
        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void createAccount(User user){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        UsuarioService usuarioService = retrofit.create(UsuarioService.class);
        Call<User> call = usuarioService.createAccount(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int check = response.code();
                switch (check){
                    case 201:
                        Toast.makeText(Registro.this, "Usuario Creado"+response.body().getNombre(), Toast.LENGTH_SHORT).show();
                        break;
                    case 400:
                        Toast.makeText(Registro.this, "Usuario existente", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Registro.this, "Error de servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
