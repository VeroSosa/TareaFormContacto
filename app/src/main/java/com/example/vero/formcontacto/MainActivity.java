package com.example.vero.formcontacto;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText date;
    private EditText telefono;
    private EditText correo;
    private EditText descripcion;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etNombre);
        date = (EditText) findViewById(R.id.etFinalB);
        telefono = (EditText) findViewById(R.id.etTelefono);
        correo = (EditText) findViewById(R.id.etEmail);
        descripcion = (EditText) findViewById(R.id.etDescripcion);
        btn = (Button) findViewById(R.id.siguiente) ;

        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    selectDate();
                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!nombre.getText().toString().trim().isEmpty() && !date.getText().toString().trim().isEmpty() &&
                        !telefono.getText().toString().trim().isEmpty() && !correo.getText().toString().trim().isEmpty() &&
                        !nombre.getText().toString().trim().isEmpty()){

                    Intent intent = new Intent(getBaseContext(), DatosContacto.class);
                    intent.putExtra(getResources().getString(R.string.nombre), nombre.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.fecha), date.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.telefono), telefono.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.correo), correo.getText().toString().trim());
                    intent.putExtra(getResources().getString(R.string.descripcion), descripcion.getText().toString().trim());
                    startActivity(intent);
                    finish();

                }
                else
                    {
                        Toast toast1 =  Toast.makeText(getApplicationContext(), "Datos incompletos", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
            }
        });



        Intent intent = getIntent();
        if (null != intent) { //Null Checking
            try{
                nombre.setText(intent.getStringExtra(getResources().getString(R.string.nombre)));
                date.setText(intent.getStringExtra(getResources().getString(R.string.fecha)));
                telefono.setText(intent.getStringExtra(getResources().getString(R.string.telefono)));
                correo.setText(intent.getStringExtra(getResources().getString(R.string.correo)));
                descripcion.setText(intent.getStringExtra(getResources().getString(R.string.descripcion)));
            }catch (Exception ex){
                //  Exception
            }
        }


    }


    public void selectDate(){

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(date.getWindowToken(), 0);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();

    }


    }
