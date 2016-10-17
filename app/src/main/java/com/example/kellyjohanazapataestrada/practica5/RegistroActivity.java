package com.example.kellyjohanazapataestrada.practica5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends LogginActivity
{

    Button btnSign;
    EditText txtUser, txtPass, txtRePass, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnSign = (Button)findViewById(R.id.btnSign);
        txtUser =  (EditText)findViewById(R.id.txtUser);
        txtPass = (EditText)findViewById(R.id.txtPass);
        txtRePass = (EditText)findViewById(R.id.txtRePass);
        txtEmail = (EditText)findViewById(R.id.txtEmail);

        btnSign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String strUserName = txtUser.getText().toString();
                String strPass = txtPass.getText().toString();
                String strPass2 = txtRePass.getText().toString();
                String strEmail = txtEmail.getText().toString();

                if(TextUtils.isEmpty(strUserName))
                {
                    txtUser.setError("Ingrese Login");
                    Toast.makeText(RegistroActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strPass))
                {
                    txtPass.setError("Ingrese Password");
                    Toast.makeText(RegistroActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strPass2))
                {
                    txtRePass.setError("Repita Password");
                    Toast.makeText(RegistroActivity.this,"Repita Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(strEmail))
                {
                    txtEmail.setError("Ingrese Email");
                    Toast.makeText(RegistroActivity.this,"Ingrese Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if ((txtPass.getText().toString()).equals(txtRePass.getText().toString())!=true)
                {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
                else
                {
                    bandera = 1;
                    Intent intent = new Intent();
                    intent.putExtra("user",txtUser.getText().toString());
                    intent.putExtra("pass",txtPass.getText().toString());
                    intent.putExtra("rePass",txtRePass.getText().toString());
                    intent.putExtra("email",txtEmail.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        });
    }

}
