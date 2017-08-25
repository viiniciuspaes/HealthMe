package usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import rede.RedeBayesiana;

/**
 * <h1>ResultadosExamesActivity</h1>
 * Activity responsavel pela chamada pela recomendacao feita atraves de perguntas.
 * Cada metodo desta classe corresponde a uma chamada de metodo correspondente na rede.
 *
 */

public class ResultadosExamesActivity extends AppCompatActivity {

    private RedeBayesiana redeBayesiana;
    private ArrayList<String> arrayRespostas;
    private ArrayList<String> dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_exames);

        arrayRespostas = getIntent().getExtras().getStringArrayList("lista");
        redeBayesiana = new RedeBayesiana();
        dados = new ArrayList<>();

        ListView lista = (ListView) findViewById(R.id.lvResultados);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, probabilidade());
        lista.setAdapter(arrayAdapter);

    }

    /**
     * @see RedeBayesiana#respostasABD()
     */

    public void usarperguntaAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasABD());
        }
    }
    /**
     * @see RedeBayesiana#respostasANBD()
     */

    public void usarperguntaAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasANBD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNABD()
     */

    public void usarperguntaNAperguntaBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNABD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNANBD() ()
     */

    public void usarperguntaNAperguntaNBperguntaD(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNANBD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNANBND()
     */

    public void usarperguntaNAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNANBND());
        }
    }

    /**
     * @see RedeBayesiana#respostasABND()
     */

    public void usaperguntaAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasABND());
        }
    }

    /**
     * @see RedeBayesiana#respostasNABND()
     */

    public void usarperguntaNAperguntaBperguntaND(){
        if(arrayRespostas.get(0).equals("nao") && arrayRespostas.get(1).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasNABND());
        }
    }

    /**
     * @see RedeBayesiana#respostasANBND()
     */

    public void usarperguntaAperguntaNBperguntaND(){
        if(arrayRespostas.get(0).equals("sim") && arrayRespostas.get(1).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Cardiologia");
            dados.add(redeBayesiana.respostasANBND());
        }
    }

    /**
     * @see RedeBayesiana#respostasCDF()
     */

    public void usarperguntaCperguntaDperguntaF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCDF());
        }
    }

    /**
     * @see RedeBayesiana#respostasCNDF()
     */

    public void usarperguntaCperguntaNDperguntaF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCNDF());
        }
    }

    /**
     * @see RedeBayesiana#respostasNCDF()
     */

    public void usarperguntaNCperguntaDrespostaF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCDF());
        }
    }

    /**
     * @see RedeBayesiana#respostasNCNDF()
     */

    public void usarperguntaNCpergundaNDrespostaF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("sim")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCNDF());
        }
    }

    /**
     * @see RedeBayesiana#respostasNCNDNF()
     */

    public void usarperguntaNCperguntaNDperguntaNF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCNDNF());
        }
    }

    /**
     * @see RedeBayesiana#respostasCDNF()
     */

    public void usaperguntaCperguntaDperguntaNF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCDNF());
        }
    }

    /**
     * @see RedeBayesiana#respostasNCDNF()
     */

    public void usarperguntaNCperguntaDperguntaNF(){
        if(arrayRespostas.get(2).equals("nao") && arrayRespostas.get(3).equals("sim") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasNCDNF());
        }
    }
    /**
     * @see RedeBayesiana#respostasCDNF()
     */

    public void usarperguntaCperguntaNDperguntaNF(){
        if(arrayRespostas.get(2).equals("sim") && arrayRespostas.get(3).equals("nao") && arrayRespostas.get(5).equals("nao")){
            dados.add("Otorrinolaringologia");
            dados.add(redeBayesiana.respostasCNDNF());
        }
    }

    /**
     * @see RedeBayesiana#respostasEFD()
     */

    public void usarperguntaEperguntaFperguntaD(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasEFD());
        }
    }

    /**
     * @see RedeBayesiana#respostasENFD()
     */

    public void usarperguntaEperguntaNFrespostaD(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasENFD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNEFD()
     */

    public void usarperguntaNEperguntaFperguntaD(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNEFD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNENFD()
     */

    public void usarperguntaNEperguntaNFperguntaD(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("sim")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNENFD());
        }
    }

    /**
     * @see RedeBayesiana#respostasNENFND()
     */

    public void usarperguntaNEperguntaNFperguntaND(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNENFND());
        }
    }

    /**
     * @see RedeBayesiana#respostasEFND()
     */

    public void usaperguntaEperguntaFperguntaND(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasEFND());
        }
    }

    /**
     * @see RedeBayesiana#respostasNEFND()
     */

    public void usarperguntaNEperguntaFperguntaND(){
        if(arrayRespostas.get(4).equals("nao") && arrayRespostas.get(5).equals("sim") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasNEFND());
        }
    }

    /**
     * @see RedeBayesiana#respostasENFND()
     */

    public void usarperguntaEperguntaNFperguntaND(){
        if(arrayRespostas.get(4).equals("sim") && arrayRespostas.get(5).equals("nao") && arrayRespostas.get(3).equals("nao")){
            dados.add("Oftalmologia");
            dados.add(redeBayesiana.respostasENFND());
        }
    }

    /**
     * Esse metodo faz a chamada de cada verificacao de cada possivel conjunto de respostas para cada
     * pergunta, sendo realizado na classe RedeBayesiana.java
     *
     * @see RedeBayesiana
     * @return retorna uma lista para o usuario com as probabilidades de cada especialidade.
     */
    public List<String> probabilidade(){

        usarperguntaAperguntaBperguntaD();
        usarperguntaAperguntaNBperguntaD();
        usarperguntaNAperguntaBperguntaD();
        usarperguntaNAperguntaNBperguntaD();
        usarperguntaNAperguntaNBperguntaND();
        usaperguntaAperguntaBperguntaND();
        usarperguntaNAperguntaBperguntaND();
        usarperguntaAperguntaNBperguntaND();
        usarperguntaCperguntaDperguntaF();
        usarperguntaCperguntaNDperguntaF();
        usarperguntaNCperguntaDrespostaF();
        usarperguntaNCpergundaNDrespostaF();
        usarperguntaNCperguntaNDperguntaNF();
        usaperguntaCperguntaDperguntaNF();
        usarperguntaNCperguntaDperguntaNF();
        usarperguntaCperguntaNDperguntaNF();
        usarperguntaEperguntaFperguntaD();
        usarperguntaEperguntaNFrespostaD();
        usarperguntaNEperguntaFperguntaD();
        usarperguntaNEperguntaNFperguntaD();
        usarperguntaNEperguntaNFperguntaND();
        usaperguntaEperguntaFperguntaND();
        usarperguntaNEperguntaFperguntaND();
        usarperguntaEperguntaNFperguntaND();
        return dados;
    }
    public void voltarParaHome(View view) throws Exception{
       startActivity(new Intent(ResultadosExamesActivity.this, TelaInicialNavActivity.class));
   }
}
