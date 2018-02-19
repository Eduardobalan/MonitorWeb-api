package br.com.monitorweb.enumeration;

/**
 * Created by Eduardo Balan on 13/09/2017.
 */
public enum EnumSexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String sexo;

    EnumSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return this.sexo;
    }


}
