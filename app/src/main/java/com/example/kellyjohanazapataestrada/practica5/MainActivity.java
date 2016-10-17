package com.example.kellyjohanazapataestrada.practica5;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentContainer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends NavigationDraActivity{

    String user,pass,email;
    String promo;
    private String[] opciones = new String[] {"Mi Perfil","Menu", "Healthy","Promociones"};
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    ListView list;
    private Productos[] productos=
            new Productos[]{
                    new Productos("Sanduche AM","Huevo frito sobre tostadas de pan rellenas " +
                            "con jamón",21300,R.drawable.desayuno),
                    new Productos("Parmessano Omega","Crema de tomate y quinoa parmessano",25900,R.drawable.omega),
                    new Productos("Dulces Pancakes!","Pancakes tradicionales servidos con miel maple y queso",14900,R.drawable.pancake),
                    new Productos("Tabla Parmessano","Queso provolone, queso camembert",17300,R.drawable.tabla),
                    new Productos("ACAI BOWL","Mezcla leche de almendras, cubierto con kiwi",13900,R.drawable.bowl),
                    new Productos("Postre de reina","Postre de Reina una receta auténtica de nuestra abuela Lía",8900,R.drawable.reina),
                    new Productos("Coctel sin alcohol","Un coctel sin licor para una tarde refrescante ",8900,R.drawable.coctel)
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        user = getIntent().getExtras().getString("user");
        pass = getIntent().getExtras().getString("pass");
        email = getIntent().getExtras().getString("email");
        promo = getIntent().getExtras().getString("promo");

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);

        //Para el menu de la izquierda (NAvigation)
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        Intent intent=new Intent(MainActivity.this,PerfilActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("pass", pass);
                        intent.putExtra("email", email);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        Intent intento1=new Intent(MainActivity.this,MenuActivity.class);
                        intento1.putExtra("user", user);
                        intento1.putExtra("pass", pass);
                        intento1.putExtra("email", email);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        Intent intento=new Intent(MainActivity.this,HealthyActivity.class);
                        intento.putExtra("user", user);
                        intento.putExtra("pass", pass);
                        intento.putExtra("email", email);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        //Para la lista de promociones
        Adapter adaptador=new Adapter(this, productos);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case(0):
                        promo= "primero";
                        Intent intent=new Intent(MainActivity.this,PromocionesActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("pass", pass);
                        intent.putExtra("email", email);
                        intent.putExtra("promo", promo);
                        startActivity(intent);
                        finish();
                        break;
                    case(1):
                        promo= "segundo";
                        Intent intento1=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento1.putExtra("user", user);
                        intento1.putExtra("pass", pass);
                        intento1.putExtra("email", email);
                        intento1.putExtra("promo", promo);
                        startActivity(intento1);
                        finish();
                        break;
                    case(2):
                        promo= "tercero";
                        Intent intento=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento.putExtra("user", user);
                        intento.putExtra("pass", pass);
                        intento.putExtra("email", email);
                        intento.putExtra("promo", promo);
                        startActivity(intento);
                        finish();
                        break;
                    case(3):
                        promo= "cuarto";
                        Intent intento2=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento2.putExtra("user", user);
                        intento2.putExtra("pass", pass);
                        intento2.putExtra("email", email);
                        intento2.putExtra("promo", promo);
                        startActivity(intento2);
                        finish();
                        break;
                    case (4):
                        promo= "quinto";
                        Intent intento3=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento3.putExtra("user", user);
                        intento3.putExtra("pass", pass);
                        intento3.putExtra("email", email);
                        intento3.putExtra("promo", promo);
                        startActivity(intento3);
                        finish();
                        break;
                    case (5):
                        promo= "sexto";
                        Intent intento4=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento4.putExtra("user", user);
                        intento4.putExtra("pass", pass);
                        intento4.putExtra("email", email);
                        intento4.putExtra("promo", promo);
                        startActivity(intento4);
                        finish();
                        break;
                    case (7):
                        promo= "sexto";
                        Intent intento6=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento6.putExtra("user", user);
                        intento6.putExtra("pass", pass);
                        intento6.putExtra("email", email);
                        intento6.putExtra("promo", promo);
                        startActivity(intento6);
                        finish();
                        break;
                    case (6):
                        promo= "septimo";
                        Intent intento5=new Intent(MainActivity.this,PromocionesActivity.class);
                        intento5.putExtra("user", user);
                        intento5.putExtra("pass", pass);
                        intento5.putExtra("email", email);
                        intento5.putExtra("promo", promo);
                        startActivity(intento5);
                        finish();
                        break;
                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

        };

        drawerLayout.setDrawerListener(drawerToggle);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
            case R.id.mCerrar:
                SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor= preferencias.edit();
                editor.putString("cerrar", "si");
                editor.commit();
                Intent intento2=new Intent(this,LogginActivity.class);
                intento2.putExtra("user", user);
                intento2.putExtra("pass", pass);
                intento2.putExtra("email", email);
                startActivity(intento2);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    class Adapter extends ArrayAdapter<Productos> {
        public Adapter(Context context, Productos[] productos) {
            super(context, R.layout.layout_item1, productos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item1, null);

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen1);
            imagen.setImageResource(productos[position].getImageId());

            TextView tPrecio = (TextView) item.findViewById(R.id.precio1);
            tPrecio.setText(String.valueOf(productos[position].getPrecioP()));

            TextView tNombre = (TextView) item.findViewById(R.id.nombre1);
            tNombre.setText(productos[position].getNombreP());

            TextView tDescripcion = (TextView) item.findViewById(R.id.descripcion1);
            tDescripcion.setText(productos[position].getDesP());
            return (item);

        }
    }




}