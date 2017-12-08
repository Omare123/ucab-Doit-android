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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIniSesion = (Button) findViewById(R.id.button) ;
        botonIniSesion.setOnClickListener(this);
        boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                Intent intent = new Intent(MainActivity.this,Registro.class);
                startActivity(intent);
                break;

            case R.id.button:
                Intent intentCuenta = new Intent(MainActivity.this,CuentaActivity.class);
                startActivity(intentCuenta);
                break;
        }
    }
}
