package example.omare.com.doit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button botonIniSesion,boton2;
    EditText username, password;
    private String baseUrl = "https://api-doit.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIniSesion = (Button) findViewById(R.id.button) ;
        botonIniSesion.setOnClickListener(this);
        boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.contrasena);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                Intent intent = new Intent(MainActivity.this,Registro.class);
                startActivity(intent);
                break;

            case R.id.button:
                username.getText().toString();
                password.getText().toString();
                User user = new User(username.getText().toString(), password.getText().toString());
                if(IniciarSesion(user) == 1){
                  
                    Intent intentCuenta = new Intent(MainActivity.this,CuentaActivity.class);
                    startActivity(intentCuenta);
                }
                break;
        }
    }


    public int IniciarSesion(User user){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        UsuarioService usuarioService = retrofit.create(UsuarioService.class);
        Call<User> call = usuarioService.iniciarSesion(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int check = response.code();
                switch (check){
                    case 200:
                        Toast.makeText(MainActivity.this, "Inicio Sesion "+response.body().getNombre(), Toast.LENGTH_SHORT).show();
                        return 1;
                    break;
                    case 400:
                        Toast.makeText(MainActivity.this, "Nombre de ususario o Contraseña incorrecta ", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Error "+response.code(),Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de servidor", Toast.LENGTH_SHORT).show();
            }
        });
      retunr 0;
    }

}
