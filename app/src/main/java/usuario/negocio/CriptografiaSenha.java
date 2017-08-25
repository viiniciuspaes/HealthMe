package usuario.negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <h1>CriptografiaSenha</h1>
 * Classe responsavel em criar a criptografia para as senhas do aplicativo.
 */

public class CriptografiaSenha {

    /**
     * O metodo criptoSenha() tem a funcionalidade de criar a criptografia da senha do usuario
     * usando o SHA-256.
     *
     * @param senha String da senha escolhida pelo usuario.
     * @return Retorna uma String com a senha ja criptografada.
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String criptoSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();
        return senhaCriptografada;
    }
}
