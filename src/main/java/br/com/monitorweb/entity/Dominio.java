package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Eduardo Balan on 21/06/2017.
 */

@Entity
//@DynamicUpdate
@Table(name = "TB_DOMINIO" , schema = "PUBLIC")
@SequenceGenerator(name = "tb_dominio_domi_id_seq", sequenceName = "public.tb_dominio_domi_id_seq")
public class Dominio extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_dominio_domi_id_seq")
    @Column(name = "domi_id")
    private Long id;

    @Column(name = "domi_nome")
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "domi_dthr_cadastro")
    private Date dtHrCadastro;

    @Column(name = "domi_observacao")
    private String observacao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    @Override
    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }
}
