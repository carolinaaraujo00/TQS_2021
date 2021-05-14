package ua.public_health.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19_Information {
    // modelo para recolher dados da api relativos à informação mais recente de um determinado concelho
    // usado também para receber informação relativa a um determinado concelho entre determinadas datas

    private String data;
    private String concelho;
    private String ars;
    private int confirmados_14;
    private int confirmados_1;
    private int incidencia;
    private String incidencia_categoria;
    private String incidencia_risco;
    private int casos_14dias;
    private int populacao_total;
    private int populacao_65_mais;
    private double densidade_populacional;

}
