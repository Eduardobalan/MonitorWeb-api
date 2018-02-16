package br.com.monitorweb.entity;

import br.com.monitorweb.entity.Generic.GenericEntity;
import br.com.monitorweb.enumeration.EnumSgdb;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/09/2017.
 */
@Entity
@Table(name = "tb_servidor_config_informacoes_db", schema = "public")
@SequenceGenerator(name = "tb_servidor_config_informacoes_db_scid_id_seq", sequenceName = "public.tb_servidor_config_informacoes_db_scid_id_seq")
public class ServidorConfigInformacoesDb extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_servidor_config_informacoes_db_scid_id_seq")
    @Column(name = "scid_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scid_dthr_cadastro")
    private Date dtHrCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scid_dthr_alteracao")
    private Date dtHrAlteracao;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "scid_nome_sgdb")
    private EnumSgdb nomeSgdb;

    @Column(name = "scid_path_main")
    private String pathMain;

    @Column(name = "scid_intervalo_exec", columnDefinition = "integer default 3600")
    private Long intervaloExec;

    @Column(name = "scid_ativo", columnDefinition = "boolean default true")
    private Boolean ativo;

    // Getter and Setter

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @Override
    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    @Override
    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }

    public Date getdtHrAlteracao() {
        return dtHrAlteracao;
    }

    public void setdtHrAlteracao(Date dtHrAlteracao) {
        this.dtHrAlteracao = dtHrAlteracao;
    }

    public EnumSgdb getNomeSgdb() {
        return nomeSgdb;
    }

    public void setNomeSgdb(EnumSgdb nomeSgdb) {
        this.nomeSgdb = nomeSgdb;
    }

    public String getPathMain() {
        return pathMain;
    }

    public void setPathMain(String pathMain) {
        this.pathMain = pathMain;
    }

    public Long getIntervaloExec() {
        return intervaloExec;
    }

    public void setIntervaloExec(Long intervaloExec) {
        this.intervaloExec = intervaloExec;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
