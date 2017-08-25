package usuario.gui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import usuario.dominio.ContatoEmergencia;
import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>TelaInicialNavActivity</h1>
 * Activity responsavel por implementar as funcionalidades da tela principal do aplicativo.
 */

public class TelaInicialNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences preferences;
    private SessaoUsuario sessao;
    private TextView boasVindas;
    private ContatoNegocio negocioContato;

    /**
     * O método onCreate() tem a funcionalidade de setar o layout: activity_tela_inicial_nav, setar
     * o menu lateral e chama o metodo: bemVindo().
     *
     * @see TelaInicialNavActivity
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        bemVindo();
    }

    /**
     * O metodo bemVindo() tem a funcionalidade de chamar metodo iniciarSessao() da classe
     * SessaoUsuario para iniciar a sessao e mudar o TextView da activity e colocar o nome do usuario.
     */

    public void bemVindo(){
        preferences = getSharedPreferences("user", Context.MODE_APPEND);
        sessao = new SessaoUsuario(getApplicationContext());

        sessao.iniciarSessao();

        boasVindas = (TextView)findViewById(R.id.boasVindas);
        String bemvindo = boasVindas.getText().toString() +  sessao.getPessoaLogada().getNome() + ".";
        boasVindas.setText(bemvindo);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.tela_inicial_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_logout) {
            sessao.encerrarSessao();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_perfil) {
            Intent intent=new Intent(TelaInicialNavActivity.this, PerfilActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_calendario) {
            Intent intent = new Intent(TelaInicialNavActivity.this, CalendarioActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_mapa) {
            Intent intent = new Intent(TelaInicialNavActivity.this, MapActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_prevecao){
            Intent intent = new Intent(TelaInicialNavActivity.this, PerguntasActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * No metodo panico ele ira pegar os contatos do nosso usuario logado e vai mandar mensagens
     * para os contatos e chama o metodo isPermissionGranted() da mesma classe, se o metodo retornar
     * a booleana True, chama o método callAction() da mesma classe.
     *
     * @see TelaInicialNavActivity#isPermissionGranted()
     * @see TelaInicialNavActivity#callAction()
     * @param v O que foi observado na activity.
     * @throws Exception Exceção de erro java.
     */

    public void panico(View v)throws Exception {

        sessao = new SessaoUsuario(getApplicationContext());
        negocioContato = new ContatoNegocio(getApplicationContext());
        sessao.iniciarSessao();

        for (ContatoEmergencia x : negocioContato.smsContato(sessao)) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(x.getNumero(), null, "Socorro by HealthMe", null, null);

            boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
            if (isWhatsappInstalled) {
                Uri uri = Uri.parse("smsto:" + x.getNumero());
                Intent sendIntent = new Intent(Intent.ACTION_SEND, uri);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Socorro by HealthMe");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        }
        if (isPermissionGranted()) {
            callAction();
        }
    }
    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    /**
     * O metodo callAction() tem a funcionalidade de fazer uma ligação automatica para o samu.
     */

    public void callAction(){
        String phnum = "996556828";
        Intent callIntent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        callIntent.putExtra("com.android.phone.extra.slot",0);

        callIntent.setData(Uri.parse("tel:" + phnum));
        startActivity(callIntent);
    }

    /**
     * O metodo isPermissionGranted() tem a funcionalidade de perguntar se o usuario da permissao
     * para o aplicativo fazer uma ligacao.
     *
     * @return Retorna uma booleana.
     */
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else {
            Log.v("TAG","Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    callAction();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }
}
