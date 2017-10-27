package example.omare.com.doit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton2:
                Intent intent = new Intent(Registro.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
