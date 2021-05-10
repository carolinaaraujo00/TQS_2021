package ua.public_health.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location_Data {
    // modelo para recolher dados da api relativos à informação mais recente de um determinado concelho
    // usado também para receber informação relativa a um determinado concelho entre determinadas datas

    private String data;                  // feito
    private String concelho;              // feito
    private int confirmados_14;           // feito
    private int confirmados_1;            // feito
    private int incidencia;               // feito
    private String incidencia_categoria;  // feito
    private String incidencia_risco;      // feito
    private int casos_14dias;             // feito
    private String ars;                   // feito
    private int populacao_total;          // feito
    private int populacao_65_mais;        // feito
    private float densidade_populacional; // feito

    @JsonProperty
    private Location_Data Location_Data;

    public Location_Data getCovid19(){
        return Location_Data;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getArs() {
        return ars;
    }

    public void setArs(String ars) {
        this.ars = ars;
    }

    public int getConfirmados_14() {
        return confirmados_14;
    }

    public void setConfirmados_14(int confirmados_14) {
        this.confirmados_14 = confirmados_14;
    }

    public int getConfirmados_1() {
        return confirmados_1;
    }

    public void setConfirmados_1(int confirmados_1) {
        this.confirmados_1 = confirmados_1;
    }

    public int getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(int incidencia) {
        this.incidencia = incidencia;
    }

    public String getIncidencia_categoria() {
        return incidencia_categoria;
    }

    public void setIncidencia_categoria(String incidencia_categoria) {
        this.incidencia_categoria = incidencia_categoria;
    }

    public String getIncidencia_risco() {
        return incidencia_risco;
    }

    public void setIndicendia_risco(String incidencia_risco) {
        this.incidencia_risco = incidencia_risco;
    }

    public int getCasos_14dias() {
        return casos_14dias;
    }

    public void setCasos_14dias(int casos_14dias) {
        this.casos_14dias = casos_14dias;
    }

    public int getPopulacao_total() {
        return populacao_total;
    }

    public void setPopulacao_total(int populacao_total) {
        this.populacao_total = populacao_total;
    }

    public int getPopulacao_65_mais() {
        return populacao_65_mais;
    }

    public void setPopulacao_65_mais(int populacao_65_mais) {
        this.populacao_65_mais = populacao_65_mais;
    }

    public float getDensidade_populacional() {
        return densidade_populacional;
    }

    public void setDensidade_populacional(float densidade_populacional) {
        this.densidade_populacional = densidade_populacional;
    }
}