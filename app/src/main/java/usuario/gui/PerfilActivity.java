package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvPlanoSaude;
    private ContatoNegocio contatoNegocio;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvNome =(TextView)findViewById(R.id.tv_nome);
        tvPlanoSaude =(TextView)findViewById(R.id.tv_planoSaude);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        contatoNegocio = new ContatoNegocio(getApplicationContext());
        sessaoUsuario.iniciarSessao();
        listViewContatos = (ListView) findViewById(R.id.listagem);

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
            tvNome.setText(sessaoUsuario.getPessoaLogada().getNome());
            tvPlanoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        }
        listViewContatos.setAdapter(contatoNegocio.construtorAdapter(sessaoUsuario));
    }
}
