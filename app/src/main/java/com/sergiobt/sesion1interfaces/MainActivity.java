package com.sergiobt.sesion1interfaces;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity  {


    private String usuario, password, repcon, correo, sexo,hobbies = "", ciudad;
    private static final String TAG = "MainAcivity";
    private EditText eUsuario, ePassword, eCorreo,eRepcon;
    private TextView tInformacion;
    private CheckBox cBailar, cDormir, cComer, cCine;

    private RadioButton rMasculino, rFemenino;
    private Spinner sCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eUsuario = (EditText) findViewById(R.id.eUsuario);
        ePassword = (EditText) findViewById(R.id.ePassword);
        eRepcon = (EditText) findViewById(R.id.eRepcon);
        eCorreo= (EditText) findViewById(R.id.eCorreo);
        tInformacion = (TextView) findViewById(R.id.tInformacion);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        rMasculino = (RadioButton) findViewById(R.id.rMasculino);
        rFemenino = (RadioButton) findViewById(R.id.rFemenino);
        sCiudades = (Spinner) findViewById(R.id.sCiudades);


        cBailar = (CheckBox) findViewById(R.id.cBailar);
        cDormir = (CheckBox) findViewById(R.id.cDormir);
        cComer = (CheckBox) findViewById(R.id.cComer);
        cCine = (CheckBox) findViewById(R.id.cCine);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }


        });

    }
    public void Registrar(View view) {
        usuario = eUsuario.getText().toString();
        password = ePassword.getText().toString();
        repcon = eRepcon.getText().toString();
        correo = eCorreo.getText().toString();
        hobbies = "";

        if (cBailar.isChecked()) {
            hobbies += "Gaming ";
        }
        if (cDormir.isChecked()) {
            hobbies += "Dormir ";
        }
        if (cComer.isChecked()) {
            hobbies += "Comer ";
        }
        if (cCine.isChecked()) {
            hobbies += "Leer ";
        }

        if (rMasculino.isChecked()) {
            sexo = "Masculino";
        } else if (rFemenino.isChecked()) {
            sexo = "Femenino";
        }



        if (!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(password)&&
                !TextUtils.isEmpty(repcon) && !TextUtils.isEmpty(correo) &&
                !TextUtils.isEmpty(ciudad) && !TextUtils.isEmpty(hobbies) && !TextUtils.isEmpty(sexo)) {

            if (password.equals(repcon)) {


                tInformacion.setText("Usuario: " + usuario + " \nPassword: " + password + " \nE-mail: " + correo +" \nSexo: " + sexo + " \nhobbies: " + hobbies + " \nCiudad: " + ciudad);
            } else {
                tInformacion.setText("Porfavor verifique que los password cocincidan !");
                ePassword.setText("");
                eRepcon.setText("");
                ePassword.setError("Digite nuevamente");

            }

        }

        else {tInformacion.setText("Faltan campos por llenar");

            if(TextUtils.isEmpty(usuario)){eUsuario.setError("Digite el dato ");}
            if(TextUtils.isEmpty(password)){ePassword.setError("Digite el dato ");}
            if(TextUtils.isEmpty(repcon)){eRepcon.setError("Digite el dato ");}
            if(TextUtils.isEmpty(correo)){eCorreo.setError("Digite el dato ");}
            if(TextUtils.isEmpty(hobbies)){tInformacion.setText("Faltan campos por llenar" + "\nSeleccione algun hobbie");}

        }




    }


    }





