package usuario.gui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import usuario.dao.ContatoDao;
import usuario.dominio.ContatoEmergencia;
import usuario.negocio.SessaoUsuario;


public class PerfilActivity extends AppCompatActivity {
    private TextView tv_nome;
    //private TextView tv_endereco;
    private TextView tv_planoSaude;
    private TextView tv_contatoEmergencia1;
    private TextView tv_contatoEmergencia2;
    private TextView tv_contatoEmergencia3;
    private TextView tv_telefoneContatoEmergencia1;

    private Button btn_deletar;
    private ContatoEmergencia contatoExistente;
    private ContatoDao daoContato;
    private SessaoUsuario sessaoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tv_nome=(TextView)findViewById(R.id.tv_nome);
        //tv_endereco=(TextView)findViewById(R.id.tv_endereco);
        tv_planoSaude=(TextView)findViewById(R.id.tv_planoSaude);
        tv_contatoEmergencia1=(TextView)findViewById(R.id.tv_contatoEmergencia1);
        tv_contatoEmergencia2=(TextView)findViewById(R.id.tv_contatoEmergencia2);
        tv_contatoEmergencia3=(TextView)findViewById(R.id.tv_contatoEmergencia3);
        tv_telefoneContatoEmergencia1 = (TextView)findViewById(R.id.tv_telefoneContatoEmergencia1);

        btn_deletar=(Button)findViewById(R.id.btn_deletarPerfil);

        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        sessaoUsuario.iniciarSessao();

        btn_deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        daoContato = new ContatoDao(getApplicationContext());
        sessaoUsuario.iniciarSessao();
        tv_nome.setText(sessaoUsuario.getPessoaLogada().getNome());
        tv_planoSaude.setText(sessaoUsuario.getPessoaLogada().getPlanoSaude());
        contatoExistente = daoContato.buscarContato(sessaoUsuario.getUsuarioLogado().getLogin());
        if(!(contatoExistente==null)){
            tv_contatoEmergencia1.setText(contatoExistente.getNome());
            tv_telefoneContatoEmergencia1.setText(contatoExistente.getNumero());
        }

    }
    public void editar(View view){
        startActivity(new Intent(this,EditarPerfilActivity.class ));
    }
}
