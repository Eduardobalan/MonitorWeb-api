package br.com.monitorweb.enumeration;

/**
 * Created by Eduardo Balan on 13/09/2017.
 */
public enum EnumSgdbTipoExec {

    BACKUP("Backup"), VACUUM("Vacuum");

    private String nome;

    EnumSgdbTipoExec(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
