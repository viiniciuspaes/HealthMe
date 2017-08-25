package rede;

/**
 * <h1>RedeBayesiana</h1>
 * Classe responsavel pela rede bayesiana do aplicativo.
 */

public class RedeBayesiana {
    NoCardiologia noCardio = new NoCardiologia();
    NoOtorrinolaringologia noOtorrino = new NoOtorrinolaringologia();
    NoOftalmologia noOftalmo = new NoOftalmologia();

    public String respostasABD() {
        double respostaTTT = 0.95;
        double negacaoFFF = 0.05;

        double probabilidade = (noCardio.getA()*noCardio.getB()*noCardio.getD()*respostaTTT/((noCardio.getA()*noCardio.getB()*noCardio.getD()*respostaTTT)+(noCardio.getnA()*noCardio.getnB()*noCardio.getnD()*negacaoFFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNANBND() {
        double respostaFFF = 0.05;
        double negacaoTTT = 0.95;

        double probabilidade = (noCardio.getnA()*noCardio.getnB()*noCardio.getnD()*respostaFFF/((noCardio.getnA()*noCardio.getnB()*noCardio.getnD()*respostaFFF)+(noCardio.getA()*noCardio.getB()*noCardio.getD()*negacaoTTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNANBD() {
        double respostaFFT = 0.05;
        double negacaoTTF = 0.95;

        double probabilidade = (noCardio.getnA()*noCardio.getnB()*noCardio.getD()*respostaFFT/((noCardio.getnA()*noCardio.getnB()*noCardio.getD()*respostaFFT)+(noCardio.getA()*noCardio.getB()*noCardio.getnD()*negacaoTTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasABND() {
        double respostaTTF = 0.95;
        double negacaoFFT = 0.05;

        double probabilidade = (noCardio.getA()*noCardio.getB()*noCardio.getnD()*respostaTTF/((noCardio.getA()*noCardio.getB()*noCardio.getnD()*respostaTTF)+(noCardio.getnA()*noCardio.getnB()*noCardio.getD()*negacaoFFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasANBD() {
        double respostaTFT = 0.65;
        double negacaoFTF = 0.75;

        double probabilidade = (noCardio.getA()*noCardio.getnB()*noCardio.getD()*respostaTFT/((noCardio.getA()*noCardio.getnB()*noCardio.getD()*respostaTFT)+(noCardio.getnA()*noCardio.getB()*noCardio.getnD()*negacaoFTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNABND() {
        double respostaFTF = 0.75;
        double negacaoTFT = 0.65;

        double probabilidade = (noCardio.getnA()*noCardio.getB()*noCardio.getnD()*respostaFTF/((noCardio.getnA()*noCardio.getB()*noCardio.getnD()*respostaFTF)+(noCardio.getA()*noCardio.getnB()*noCardio.getD()*negacaoTFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasANBND() {
        double respostaTFF = 0.60;
        double negacaoFTT = 0.70;

        double probabilidade = (noCardio.getA()*noCardio.getnB()*noCardio.getnD()*respostaTFF/((noCardio.getA()*noCardio.getnB()*noCardio.getnD()*respostaTFF)+(noCardio.getnA()*noCardio.getB()*noCardio.getD()*negacaoFTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNABD() {
        double respostaFTT = 0.70;
        double negacaoTFF = 0.60;

        double probabilidade = (noCardio.getnA()*noCardio.getB()*noCardio.getD()*respostaFTT/((noCardio.getnA()*noCardio.getB()*noCardio.getD()*respostaFTT)+(noCardio.getA()*noCardio.getnB()*noCardio.getnD()*negacaoTFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasCDF() {
        double respostaTTT = 0.90;
        double negacaoFFF = 0.10;

        double probabilidade = (noOtorrino.getC()*noOtorrino.getD()*noOtorrino.getF()*respostaTTT/((noOtorrino.getC()*noCardio.getD()*noOtorrino.getF()*respostaTTT)+(noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getnF()*negacaoFFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNCNDNF() {
        double respostaFFF = 0.10;
        double negacaoTTT = 0.90;

        double probabilidade = (noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getnF()*respostaFFF/((noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getnF()*respostaFFF)+(noOtorrino.getC()*noOtorrino.getD()*noOtorrino.getF()*negacaoTTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNCNDF() {
        double respostaFFT = 0.22;
        double negacaoTTF = 0.78;

        double probabilidade = (noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getF()*respostaFFT/((noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getF()*respostaFFT)+(noOtorrino.getC()*noOtorrino.getD()*noOtorrino.getnF()*negacaoTTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasCDNF() {
        double respostaTTF = 0.78;
        double negacaoFFT = 0.22;

        double probabilidade = (noOtorrino.getC()*noOtorrino.getD()*noOtorrino.getnF()*respostaTTF/((noOtorrino.getC()*noOtorrino.getD()*noOtorrino.getnF()*respostaTTF)+(noOtorrino.getnC()*noOtorrino.getnD()*noOtorrino.getF()*negacaoFFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasCNDF() {
        double respostaTFT = 0.75;
        double negacaoFTF = 0.60;

        double probabilidade = (noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getF()*respostaTFT/((noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getF()*respostaTFT)+(noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getF()*negacaoFTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNCDNF() {
        double respostaFTF = 0.60;
        double negacaoTFT = 0.75;

        double probabilidade = (noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getnF()*respostaFTF/((noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getnF()*respostaFTF)+(noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getnF()*negacaoTFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasCNDNF() {
        double respostaTFF = 0.60;
        double negacaoFTT = 0.64;

        double probabilidade = (noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getnF()*respostaTFF/((noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getnF()*respostaTFF)+(noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getF()*negacaoFTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNCDF() {
        double respostaFTT = 0.64;
        double negacaoTFF = 0.60;

        double probabilidade = (noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getF()*respostaFTT/((noOtorrino.getnC()*noOtorrino.getD()*noOtorrino.getF()*respostaFTT)+(noOtorrino.getC()*noOtorrino.getnD()*noOtorrino.getnF()*negacaoTFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasEFD() {
        double respostaTTT = 0.92;
        double negacaoFFF = 0.08;

        double probabilidade = (noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getD()*respostaTTT/((noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getD()*respostaTTT)+(noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getnD()*negacaoFFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNENFND() {
        double respostaFFF = 0.08;
        double negacaoTTT = 0.92;

        double probabilidade = (noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getnD()*respostaFFF/((noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getnD()*respostaFFF)+(noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getD()*negacaoTTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNENFD() {
        double respostaFFT = 0.11;
        double negacaoTTF = 0.89;

        double probabilidade = (noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getD()*respostaFFT/((noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getD()*respostaFFT)+(noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getnD()*negacaoTTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasEFND() {
        double respostaTTF = 0.89;
        double negacaoFFT = 0.11;

        double probabilidade = (noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getnD()*respostaTTF/((noOftalmo.getE()*noOftalmo.getF()*noOftalmo.getnD()*respostaTTF)+(noOftalmo.getnE()*noOftalmo.getnF()*noOftalmo.getD()*negacaoFFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasENFD() {
        double respostaTFT = 0.59;
        double negacaoFTF = 0.61;

        double probabilidade = (noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getD()*respostaTFT/((noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getD()*respostaTFT)+(noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getnD()*negacaoFTF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNEFND() {
        double respostaFTF = 0.61;
        double negacaoTFT = 0.59;

        double probabilidade = (noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getnD()*respostaFTF/((noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getnD()*respostaFTF)+(noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getD()*negacaoTFT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasNEFD() {
        double respostaFTT = 0.69;
        double negacaoTFF = 0.58;

        double probabilidade = (noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getD()*respostaFTT/((noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getD()*respostaFTT)+(noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getnD()*negacaoTFF))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }

    public String respostasENFND() {
        double respostaTFF = 0.58;
        double negacaoFTT = 0.69;

        double probabilidade = (noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getnD()*respostaTFF/((noOftalmo.getE()*noOftalmo.getnF()*noOftalmo.getnD()*respostaTFF)+(noOftalmo.getnE()*noOftalmo.getF()*noOftalmo.getD()*negacaoFTT))*100);
        String resultado = String.format("%.2f%%", probabilidade);
        return resultado;
    }
}
