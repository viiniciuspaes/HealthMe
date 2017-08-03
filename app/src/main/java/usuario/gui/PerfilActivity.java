package usuario.gui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

import usuario.dao.ContatoDao;
import usuario.dao.DbHelper;
import usuario.dominio.ContatoEmergencia;
import usuario.negocio.SessaoUsuario;

public class PerfilActivity extends AppCompatActivity {

    private TextView tv_nome;
    private TextView tv_planoSaude;
    private ContatoDao daoContato;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewContatos;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv_nome=(TextView)findViewById(R.id.tv_nome);
        tv_planoSaude=(TextView)findViewById(R.id.tv_planoSaude);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        daoContato = new ContatoDao(getApplicationContext());
        sessaoUsuario.iniciarSessao();

        setTextos();
    }
    @Override
    public void onResume(){super.onResume();}

    public void editar(View view){
        startActivity(new Intent(this,EditarPerfilActivity.class));
        finish();
    }

    public void setTextos(){
        String pessoa= sessaoUsuario.getPessoaLogada().getNome();
        if (!(pessoa == null)){
            tv_nome.setText(sessaoUsuario.getPessoaLogada().getNome());
            tv_planoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        }
        Cursor c = daoContato.buscarDados(sessaoUsuario.getUsuarioLogado().getLogin());
        String[] from = new String[]{"_id","contato_usuario","contato_nome","contato_telefone"};
        int[] to = new int[]{R.id.txvContatoEmergencial,R.id.txvContatoUsuario,R.id.txvContatoNome,R.id.txvContatoNumero,};
        adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.modelo_listview_contatos, c, from, to,0);
        adapter.notifyDataSetChanged();
        listViewContatos = (ListView) findViewById(R.id.listaDeContatos);
        listViewContatos.setAdapter(adapter);
    }
}
