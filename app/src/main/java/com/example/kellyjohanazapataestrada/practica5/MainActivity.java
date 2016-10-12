package com.example.kellyjohanazapataestrada.practica5;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends LogginActivity implements View.OnClickListener
{

    private String[] opciones = new String[]{"Pastas", "Postres", "Bebidas"};
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorPrincipal);
        list = (ListView)findViewById(R.id.menuIzqui);
        list.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),android.R.layout.simple_list_item_1,opciones));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                android.support.v4.app.Fragment fragment = null;
                switch (i){
                    case(0): fragment = new PastasFragment(); break;
                    case(1): fragment = new PostresFragment(); break;
                    case(2): fragment = new BebidasFragment(); break;
                    case(3): Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                if (i != 3) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                list.setItemChecked(i,true);
                drawerLayout.closeDrawer(list);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.menuover)
        {
            Toast.makeText(getApplicationContext(), "Bienvenido a su perfil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,PerfilActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }
        else if(id == R.id.menu2)
        {
            Intent intent = new Intent(this,MenuActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       /* Toast toast2 =
                Toast.makeText(getApplicationContext(), "request" + requestCode + "code" + resultCode, Toast.LENGTH_SHORT);
        toast2.show();*/

        if(requestCode == 4567 && resultCode==RESULT_OK)
        {
            Bundle Extras = getIntent().getExtras();
            //Variables para capturar los datos
            String user2 = data.getExtras().getString("User2");
            String pass2 = data.getExtras().getString("Pass2");
            String repass2 = data.getExtras().getString("RePass2");
            String email2 = data.getExtras().getString("Email2");

           /* Toast toast1 =
                    Toast.makeText(getApplicationContext(), "User" + user2+"Pass" + pass2 + "Email" + email2, Toast.LENGTH_SHORT);
            toast1.show();*/
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

}
