package com.example.gps.model;

public class ModelEndereco {

    private Integer idModelEndereco;
    private String nomeLocal;
    private ModelCEP modelCEP;
    private String pais;


    public ModelEndereco() {

    }

    public Integer getIdModelEndereco() {
        return idModelEndereco;
    }

    public void setIdModelEndereco(Integer idModelEndereco) {
        this.idModelEndereco = idModelEndereco;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public ModelCEP getModelCEP() {
        return modelCEP;
    }

    public void setModelCEP(ModelCEP modelCEP) {
        this.modelCEP = modelCEP;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
