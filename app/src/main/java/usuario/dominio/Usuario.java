package usuario.dominio;

public class Usuario {
    private String login;
    private String password;
    private int id;
    private String ativo;

    public Usuario(){
        this.login = null;
        this.password = null;
        this.ativo = "1";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtivo(){
        this.ativo = "1";
    }

    public void setInativo(){
        this.ativo = "0";
    }

    public String getAtivo() {
        return ativo;
    }
    public void setState(String a){
        this.ativo=a;
    }
}
