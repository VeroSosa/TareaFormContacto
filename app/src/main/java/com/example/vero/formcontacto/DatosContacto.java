package com.example.vero.formcontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosContacto extends AppCompatActivity {


    private TextView tvnombre, tvfecha, tvtelefono, tvemail, tvdescrip;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);

        tvnombre = (TextView) findViewById(R.id.tnombre);
        tvfecha = (TextView) findViewById(R.id.tfecha);
        tvtelefono = (TextView) findViewById(R.id.ttelefono);
        tvemail = (TextView) findViewById(R.id.tcorreo);
        tvdescrip = (TextView) findViewById(R.id.tdescripcion);

        editar = (Button) findViewById(R.id.editar);


        final Intent intent = getIntent();
        if (null != intent) { //Null Checking
            tvnombre.setText(intent.getStringExtra(getResources().getString(R.string.nombre)));
            tvfecha.setText(getResources().getString(R.string.fecha)+": "+intent.getStringExtra(getResources().getString(R.string.fecha)));
            tvtelefono.setText(getResources().getString(R.string.telefono)+": "+intent.getStringExtra(getResources().getString(R.string.telefono)));
            tvemail.setText(getResources().getString(R.string.correo)+": "+intent.getStringExtra(getResources().getString(R.string.correo)));
            tvdescrip.setText(getResources().getString(R.string.descripcion)+": "+intent.getStringExtra(getResources().getString(R.string.descripcion)));

        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_new = new Intent(getBaseContext(), MainActivity.class);
                intent_new.putExtra(getResources().getString(R.string.nombre), intent.getStringExtra(getResources().getString(R.string.nombre)));
                intent_new.putExtra(getResources().getString(R.string.fecha), intent.getStringExtra(getResources().getString(R.string.fecha)));
                intent_new.putExtra(getResources().getString(R.string.telefono), intent.getStringExtra(getResources().getString(R.string.telefono)));
                intent_new.putExtra(getResources().getString(R.string.correo), intent.getStringExtra(getResources().getString(R.string.correo)));
                intent_new.putExtra(getResources().getString(R.string.descripcion), intent.getStringExtra(getResources().getString(R.string.descripcion)));
                startActivity(intent_new );
                finish();
            }
        });

    }
}
