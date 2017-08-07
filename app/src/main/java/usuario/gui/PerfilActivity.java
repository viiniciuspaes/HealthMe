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

    private TextView tv_nome;
    private TextView tv_planoSaude;
    private ContatoNegocio contatoNegocio;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv_nome=(TextView)findViewById(R.id.tv_nome);
        tv_planoSaude=(TextView)findViewById(R.id.tv_planoSaude);

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
            tv_nome.setText(sessaoUsuario.getPessoaLogada().getNome());
            tv_planoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        }
        listViewContatos.setAdapter(contatoNegocio.construtorAdapter(sessaoUsuario));
    }
}
