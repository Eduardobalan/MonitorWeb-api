package br.com.monitorweb.enumeration;

/**
 * Created by Eduardo Balan on 13/09/2017.
 */
public enum EnumSgdb {

    POSTGRESQL("PostgreSQL");

    private String nome;

    EnumSgdb(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
