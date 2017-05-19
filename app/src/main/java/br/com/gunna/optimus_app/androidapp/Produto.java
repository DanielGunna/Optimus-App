package br.com.gunna.optimus_app.androidapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Daniel on 19/05/17.
 */

public class Produto implements Serializable {

    @Expose
    @SerializedName("value")
    private Integer valorProduto;
    @Expose
    @SerializedName("name")
    private String nomeProduto;
    @Expose
    @SerializedName("desc")
    private String descProduto;


    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Integer valorProduto) {
        this.valorProduto = valorProduto;
    }
}
