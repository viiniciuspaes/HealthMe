package usuario.negocio;

public class MinhaRedeBayesiana {

    public String a_e_b_e_d() {
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
        double cardio_a_e_b_e_d = 0.95;
        double cardio_na_e_nb_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*e*f*cardio_a_e_b_e_d/((a*b*c*d*e*f*cardio_a_e_b_e_d)+(na*nb*nc*nd*ne*nf*cardio_na_e_nb_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String na_e_nb_e_nd() {
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
        double cardio_a_e_b_e_d = 0.95;
        double cardio_na_e_nb_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = na*nb*nc*nd*ne*nf*cardio_na_e_nb_e_nd/((na*nb*nc*nd*ne*nf*cardio_na_e_nb_e_nd)+(a*b*c*d*e*f*cardio_a_e_b_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String na_e_nb_e_d() {
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
        double cardio_a_e_b_e_nd = 0.95;
        double cardio_na_e_nb_e_d = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = na*nb*c*d*e*f*cardio_na_e_nb_e_d/((na*nb*c*d*e*f*cardio_na_e_nb_e_d)+(a*b*nc*nd*ne*nf*cardio_a_e_b_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String a_e_nb_e_d() {
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
        double cardio_a_e_nb_e_d = 0.65;
        double cardio_na_e_b_e_nd = 0.75;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*nb*c*d*e*f*cardio_a_e_nb_e_d/((a*nb*c*d*e*f*cardio_a_e_nb_e_d)+(na*b*nc*nd*ne*nf*cardio_na_e_b_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String a_e_nb_e_nd() {
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
        double cardio_a_e_nb_e_nd = 0.65;
        double cardio_na_e_b_e_d = 0.75;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*nb*c*nd*e*f*cardio_a_e_nb_e_nd/((a*nb*c*nd*e*f*cardio_a_e_nb_e_nd)+(na*b*nc*d*ne*nf*cardio_na_e_b_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String na_e_b_e_d() {
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
        double cardio_na_e_b_e_d = 0.75;
        double cardio_a_e_nb_e_nd = 0.65;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = na*b*c*d*e*f*cardio_na_e_b_e_d/((na*b*c*d*e*f*cardio_na_e_b_e_d)+(a*nb*nc*nd*ne*nf*cardio_a_e_nb_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }
    public String na_e_b_e_nd() {
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
        double cardio_na_e_b_e_nd = 0.75;
        double cardio_a_e_nb_e_d = 0.65;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = na*b*c*nd*e*f*cardio_na_e_b_e_nd/((na*b*c*nd*e*f*cardio_na_e_b_e_nd)+(a*nb*nc*d*ne*nf*cardio_a_e_nb_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }
    public String a_e_b_e_nd() {
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
        double cardio_a_e_b_e_nd = 0.75;
        double cardio_na_e_nb_e_d = 0.65;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*nd*e*f*cardio_a_e_b_e_nd/((a*b*c*nd*e*f*cardio_a_e_b_e_nd)+(na*nb*nc*d*ne*nf*cardio_na_e_nb_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String c_e_d() {
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
        double cardio_c_e_d = 0.95;
        double cardio_nc_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*e*f*cardio_c_e_d/((a*b*c*d*e*f*cardio_c_e_d)+(na*nb*nc*nd*ne*nf*cardio_nc_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String nc_e_nd() {
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
        double cardio_c_e_d = 0.95;
        double cardio_nc_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*nc*nd*e*f*cardio_nc_e_nd/((a*b*nc*nd*e*f*cardio_nc_e_nd)+(na*nb*c*d*ne*nf*cardio_c_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String c_e_nd() {
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
        double cardio_c_e_nd = 0.60;
        double cardio_nc_e_d = 0.80;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*nd*e*f*cardio_c_e_nd/((a*b*c*nd*e*f*cardio_c_e_nd)+(na*nb*nc*d*ne*nf*cardio_nc_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String nc_e_d() {
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
        double cardio_nc_e_d = 0.80;
        double cardio_c_e_nd = 0.60;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*nc*d*e*f*cardio_nc_e_d/((a*b*nc*d*e*f*cardio_nc_e_d)+(na*nb*c*nd*ne*nf*cardio_c_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String e_e_f() {
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
        double cardio_c_e_d = 0.95;
        double cardio_nc_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*e*f*cardio_c_e_d/((a*b*c*d*e*f*cardio_c_e_d)+(na*nb*nc*nd*ne*nf*cardio_nc_e_nd));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String ne_e_nf() {
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
        double cardio_c_e_d = 0.95;
        double cardio_nc_e_nd = 0.05;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*ne*nf*cardio_nc_e_nd/((a*b*c*d*ne*nf*cardio_nc_e_nd)+(na*nb*nc*nd*e*f*cardio_c_e_d));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String e_e_nf() {
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
        double cardio_e_e_nf = 0.64;
        double cardio_ne_e_f = 0.78;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*e*nf*cardio_e_e_nf/((a*b*c*d*e*nf*cardio_e_e_nf)+(na*nb*nc*nd*ne*f*cardio_ne_e_f));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }

    public String ne_e_f() {
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
        double cardio_ne_e_f = 0.78;
        double cardio_e_e_nf = 0.64;
        double p_tudo_especialidade;
        double p_tudo_especialidade_porc;

        p_tudo_especialidade = a*b*c*d*ne*f*cardio_ne_e_f/((a*b*c*d*ne*f*cardio_ne_e_f)+(na*nb*nc*nd*e*nf*cardio_e_e_nf));
        p_tudo_especialidade_porc = p_tudo_especialidade*100;
        String resultado = String.format("%.2f%%", p_tudo_especialidade_porc);
        return resultado;
    }
}