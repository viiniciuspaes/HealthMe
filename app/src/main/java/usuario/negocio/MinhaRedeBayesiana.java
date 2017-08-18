package usuario.negocio;

public class MinhaRedeBayesiana {

    public String perguntaAperguntaBperguntaD() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideAEBED = 0.95;
        double especialideNANBND = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*e*f*especialideAEBED/((a*b*c*d*e*f*especialideAEBED)+(na*nb*nc*nd*ne*nf*especialideNANBND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNAperguntaNBperguntaND() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideAEBED = 0.95;
        double especialideNANBND = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = na*nb*nc*nd*ne*nf*especialideNANBND/((na*nb*nc*nd*ne*nf*especialideNANBND)+(a*b*c*d*e*f*especialideAEBED));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNAperguntaNBperguntaD() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideABND = 0.95;
        double especialideNANBD = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = na*nb*c*d*e*f*especialideNANBD/((na*nb*c*d*e*f*especialideNANBD)+(a*b*nc*nd*ne*nf*especialideABND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaAperguntaNBperguntaD() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideANBD = 0.65;
        double especialideNABND = 0.75;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*nb*c*d*e*f*especialideANBD/((a*nb*c*d*e*f*especialideANBD)+(na*b*nc*nd*ne*nf*especialideNABND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaAperguntaNBperguntaND() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideANBND = 0.65;
        double especialideNABD = 0.75;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*nb*c*nd*e*f*especialideANBND/((a*nb*c*nd*e*f*especialideANBND)+(na*b*nc*d*ne*nf*especialideNABD));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNAperguntaBperguntaD() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideNABD = 0.75;
        double especialideANBND = 0.65;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = na*b*c*d*e*f*especialideNABD/((na*b*c*d*e*f*especialideNABD)+(a*nb*nc*nd*ne*nf*especialideANBND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }
    public String perguntaNAperguntaBperguntaND() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideNABND = 0.75;
        double especialideANBD = 0.65;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = na*b*c*nd*e*f*especialideNABND/((na*b*c*nd*e*f*especialideNABND)+(a*nb*nc*d*ne*nf*especialideANBD));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }
    public String perguntaAperguntaBperguntaND() {
        double a = 0.80;
        double na = 0.20;
        double b = 0.60;
        double nb = 0.40;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.55;
        double nd = 0.45;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideABND = 0.75;
        double especialideNANBD = 0.65;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*nd*e*f*especialideABND/((a*b*c*nd*e*f*especialideABND)+(na*nb*nc*d*ne*nf*especialideNANBD));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaCperguntaD() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.78;
        double nc = 0.22;
        double d = 0.62;
        double nd = 0.38;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialideCD = 0.95;
        double especialideNCND = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*e*f*especialideCD/((a*b*c*d*e*f*especialideCD)+(na*nb*nc*nd*ne*nf*especialideNCND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNCpergundaND() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.78;
        double nc = 0.22;
        double d = 0.62;
        double nd = 0.38;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialidadeNCND = 0.95;
        double especialideCD = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*nc*nd*e*f*especialideCD/((a*b*nc*nd*e*f*especialideCD)+(na*nb*c*d*ne*nf*especialidadeNCND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaCperguntaND() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.78;
        double nc = 0.22;
        double d = 0.62;
        double nd = 0.38;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialidadeCND = 0.60;
        double especialideNCD = 0.80;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*nd*e*f*especialidadeCND/((a*b*c*nd*e*f*especialidadeCND)+(na*nb*nc*d*ne*nf*especialideNCD));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNCperguntaD() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.78;
        double nc = 0.22;
        double d = 0.62;
        double nd = 0.38;
        double e = 0.50;
        double ne = 0.50;
        double f = 0.50;
        double nf = 0.50;
        double especialidadeNCD = 0.80;
        double especialidadeCND = 0.60;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*nc*d*e*f*especialidadeNCD/((a*b*nc*d*e*f*especialidadeNCD)+(na*nb*c*nd*ne*nf*especialidadeCND));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaEperguntaF() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.50;
        double nd = 0.50;
        double e = 0.83;
        double ne = 0.17;
        double f = 0.63;
        double nf = 0.37;
        double especialidadeEF = 0.95;
        double especialidadeNENF = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*e*f*especialidadeEF/((a*b*c*d*e*f*especialidadeEF)+(na*nb*nc*nd*ne*nf*especialidadeNENF));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNEperguntaNF() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.50;
        double nd = 0.50;
        double e = 0.83;
        double ne = 0.17;
        double f = 0.63;
        double nf = 0.37;
        double especialidadeNENF = 0.95;
        double especialidadeEF = 0.05;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*ne*nf*especialidadeEF/((a*b*c*d*ne*nf*especialidadeEF)+(na*nb*nc*nd*e*f*especialidadeNENF));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaEperguntaNF() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.50;
        double nd = 0.50;
        double e = 0.83;
        double ne = 0.17;
        double f = 0.63;
        double nf = 0.37;
        double especialidadeENF = 0.64;
        double especialidadeNEF = 0.78;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*e*nf*especialidadeENF/((a*b*c*d*e*nf*especialidadeENF)+(na*nb*nc*nd*ne*f*especialidadeNEF));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }

    public String perguntaNEperguntaF() {
        double a = 0.50;
        double na = 0.50;
        double b = 0.50;
        double nb = 0.50;
        double c = 0.50;
        double nc = 0.50;
        double d = 0.50;
        double nd = 0.50;
        double e = 0.83;
        double ne = 0.17;
        double f = 0.63;
        double nf = 0.37;
        double especialdiadeNEF = 0.78;
        double especialidadeENF = 0.64;
        double pTudoEspecialidade;
        double pTudoEspecialidadePorcentagem;

        pTudoEspecialidade = a*b*c*d*ne*f*especialdiadeNEF/((a*b*c*d*ne*f*especialdiadeNEF)+(na*nb*nc*nd*e*nf*especialidadeENF));
        pTudoEspecialidadePorcentagem = pTudoEspecialidade*100;
        String resultado = String.format("%.2f%%", pTudoEspecialidadePorcentagem);
        return resultado;
    }
}