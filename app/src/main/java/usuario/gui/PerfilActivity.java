package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import usuario.negocio.ContatoNegocio;
import usuario.negocio.SessaoUsuario;

/**
 * <h1>PerfilActivity</h1>
 * Activity responsavel pelas funcionalidade do Perfil do aplicativo.
 */

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvPlanoSaude;
    private ContatoNegocio contatoNegocio;
    private SessaoUsuario sessaoUsuario;
    private ListView listViewContatos;

    /**
     * O metodo onCreate() tem a funcionalidade de setar o layout: activity_perfil e setar os
     * TextViews do layout para cada atributo da classe e chama o metodo setTextos() da mesma classe.
     *
     * @see PerfilActivity#setTextos()
     * @param savedInstanceState Objeto da classe Bundle que contem o estado anterior da activity
     */

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

    /**
     * O metodo editar() tem a funcionalidade de iniciar a activity PerfilActivity e iniciar
     * a activity EditarPerfilActivity.
     *
     * @param view Contem o que foi observado na activity.
     */
    public void editar(View view){
        startActivity(new Intent(this,EditarPerfilActivity.class));
        finish();
    }

    /**
     * O metodo setTextos() tem a funcionalidade de setar os textos dos TextViews com auxilio dos
     * gets do SessaoUsuario: getNome() e getPlanoSaude. E setar o adaptador com os contatos de
     * emergencia do usuario usando o metodo: contrutorAdapter() da classe ContatoNegocio().
     *
     * @see ContatoNegocio#construtorAdapter(SessaoUsuario)
     */

    public void setTextos(){
        String pessoa= sessaoUsuario.getPessoaLogada().getNome();
        if (!(pessoa == null)){
            tvNome.setText(sessaoUsuario.getPessoaLogada().getNome());
            tvPlanoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        }
        listViewContatos.setAdapter(contatoNegocio.construtorAdapter(sessaoUsuario));
    }
}
