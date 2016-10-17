package com.example.kellyjohanazapataestrada.practica5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText User,Pass;
    Button bAceptar,bRegistro;
    String user,pass,email;
    static int bandera=0;
    SharedPreferences preferencias;
    String preferencia1,preferencia2,preferencia3,cerrar;
    int ban=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        User =  (EditText)findViewById(R.id.txtLogin);
        Pass = (EditText)findViewById(R.id.txtPass);
        bAceptar=(Button)findViewById(R.id.btnIngresar);
        bRegistro=(Button)findViewById(R.id.btnRegistro);

        preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferencia1=preferencias.getString("user","");
        preferencia2=preferencias.getString("pass","");
        preferencia3=preferencias.getString("email","");
        cerrar=preferencias.getString("cerrar","");

        if(preferencia1.length()==0 && cerrar=="no")
        {
            bAceptar.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    if(bandera==0)
                    {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(), "No hay usuarios registrados", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    else if(bandera==1)
                    {
                        String Login = User.getText().toString();
                        String Passw = Pass.getText().toString();

                        if(TextUtils.isEmpty(Login))
                        {
                            User.setError("Ingrese Login");
                            Toast.makeText(LogginActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(TextUtils.isEmpty(Passw))
                        {
                            Pass.setError("Ingrese Password");
                            Toast.makeText(LogginActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if ((User.getText().toString()).equals(preferencia1) == true && (Pass.getText().toString()).equals(preferencia2))
                        {
                            Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                            intento.putExtra("user", user);
                            intento.putExtra("pass", pass);
                            intento.putExtra("email", email);
                            startActivity(intento);
                        }
                        else
                        {
                            Toast.makeText(LogginActivity.this,"Usuario o contrasena incorrectos",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            bRegistro.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });

        }
        else if(preferencia1.length()!=0 && cerrar=="no")
        {
            Intent intento2=new Intent(this,MainActivity.class);
            intento2.putExtra("user", user);
            intento2.putExtra("pass", pass);
            intento2.putExtra("email", email);
            startActivity(intento2);
            finish();
        }
        else if(preferencia1.length()!=0 && cerrar=="si")
        {
            bAceptar.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    if(bandera==0)
                    {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(), "No hay usuarios registrados", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    else if(bandera==1)
                    {
                        String Login = User.getText().toString();
                        String Passw = Pass.getText().toString();

                        if(TextUtils.isEmpty(Login))
                        {
                            User.setError("Ingrese Login");
                            Toast.makeText(LogginActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(TextUtils.isEmpty(Passw))
                        {
                            Pass.setError("Ingrese Password");
                            Toast.makeText(LogginActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if ((User.getText().toString()).equals(preferencia1) == true && (Pass.getText().toString()).equals(preferencia2))
                        {
                            Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                            intento.putExtra("user", user);
                            intento.putExtra("pass", pass);
                            intento.putExtra("email", email);
                            startActivity(intento);
                        }
                        else
                        {
                            Toast.makeText(LogginActivity.this,"Usuario o contrasena incorrectos",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            bRegistro.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view) {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });
        }
        else
        {
            bAceptar.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    if(bandera==0)
                    {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(), "No hay usuarios registrados", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    else if(bandera==1)
                    {
                        String Login = User.getText().toString();
                        String Passw = Pass.getText().toString();

                        if(TextUtils.isEmpty(Login))
                        {
                            User.setError("Ingrese Login");
                            Toast.makeText(LogginActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(TextUtils.isEmpty(Passw))
                        {
                            Pass.setError("Ingrese Password");
                            Toast.makeText(LogginActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if ((User.getText().toString()).equals(preferencia1) == true && (Pass.getText().toString()).equals(preferencia2))
                        {
                            Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                            intento.putExtra("user", user);
                            intento.putExtra("pass", pass);
                            intento.putExtra("email", email);
                            startActivity(intento);
                        }
                        else
                        {
                            Toast.makeText(LogginActivity.this,"Usuario o contrasena incorrectos",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            bRegistro.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    Intent intento = new Intent(getApplicationContext(), RegistroActivity.class);
                    startActivityForResult(intento, 1234);
                }
            });
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            user = data.getExtras().getString("user");
            pass = data.getExtras().getString("pass");
            email = data.getExtras().getString("email");
            Log.d("user", user);
            Log.d("pass", pass);
            Log.d("email",email);
            SharedPreferences preferencias=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor= preferencias.edit();
            editor.putString("user",  user);
            editor.putString("pass", pass);
            editor.putString("email", email);
            editor.putString("cerrar","no");
            editor.commit();
            preferencias = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            preferencia1=preferencias.getString("user","");
            preferencia2=preferencias.getString("pass","");
            preferencia3=preferencias.getString("email","");
            cerrar=preferencias.getString("cerrar","");

        }
        if (requestCode == 1234 && resultCode == RESULT_CANCELED) {
            Log.d("mensaje", "no se cargaron datos");
            Toast.makeText(this, "No se cargaron los datos",Toast.LENGTH_SHORT).show();
        }
    }

}
