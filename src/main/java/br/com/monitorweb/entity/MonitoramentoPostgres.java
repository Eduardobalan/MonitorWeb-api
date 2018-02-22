package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;
import br.com.monitorweb.enumeration.EnumSgdbTipoExec;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_postgres", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_postgres_dbmp_id_seq", sequenceName = "public.tb_monitoramento_postgres_dbmp_id_seq")
public class MonitoramentoPostgres extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_postgres_dbmp_id_seq")
    @Column(name = "dbmp_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scdb_id")
    private ServidorConfigDb servidorConfigDb;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "dbmp_tipo_execucao",  nullable = false)
    private EnumSgdbTipoExec tipoExecucao;

    @Column(name = "dbmp_exito")
    private int exito;

    @Column(name = "dbmp_mensagem")
    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbmp_dthr_cadastro")
    private Date dtHrCadastro;

    public Long getId() {
        return id;
    }

    public ServidorConfigDb getServidorConfigDb() {
        return servidorConfigDb;
    }

    public void setServidorConfigDb(ServidorConfigDb servidorConfigDb) {
        this.servidorConfigDb = servidorConfigDb;
    }

    public EnumSgdbTipoExec getTipoExecucao() {
        return tipoExecucao;
    }

    public void setTipoExecucao(EnumSgdbTipoExec tipoExecucao) {
        this.tipoExecucao = tipoExecucao;
    }

    public int getExito() {
        return exito;
    }

    public void setExito(int exito) {
        this.exito = exito;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    @Override
    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

