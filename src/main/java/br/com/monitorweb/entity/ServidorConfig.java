package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/09/2017.
 */
@Entity
@Table(name = "tb_servidor_config", schema = "public")
@SequenceGenerator(name = "tb_servidor_config_serv_id_seq", sequenceName = "public.tb_servidor_config_serv_id_seq")
public class ServidorConfig extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_servidor_config_serv_id_seq")
    @Column(name = "serc_id")
    private Long id;

    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_cadastro")
    private Date dtHrCadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_alteracao")
    private Date dtHrAlteracao;

    @Column(name = "serc_intervalo_leitura_configuracoes", columnDefinition = "integer default 60")
    private Long intervaloLeituraConfiguracoes;

    @Column(name = "serc_intervalo_leitura_configuracoes_db", columnDefinition = "integer default 60")
    private Long intervaloLeituraConfiguracoesDb;

    @Column(name = "serc_intervalo_cpu", columnDefinition = "integer default 1")
    private Long intervaloCpu;

    @Column(name = "serc_intervalo_mem", columnDefinition = "integer default 1")
    private Long intervaloMemoria;

    @Column(name = "serc_intervalo_swap", columnDefinition = "integer default 1")
    private Long intervaloSwap;

    @Column(name = "serc_host_monitoramento")
    private String hostMonitoramento;

    @Column(name = "serc_host_monitoramento_2")
    private String hostMonitoramento2;

    @Column(name = "serc_porta", columnDefinition = "integer default 8081")
    private Long porta;

    @Column(name = "serc_porta2", columnDefinition = "integer default 8080")
    private Long porta2;


    // Getter and Setter
    @Override
    public Long getId() {
        return id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }

    public Date getdtHrAlteracao() {
        return dtHrAlteracao;
    }

    public void setdtHrAlteracao(Date dtHrAlteracao) {
        this.dtHrAlteracao = dtHrAlteracao;
    }

    public Long getIntervaloCpu() {
        return intervaloCpu;
    }

    public void setIntervaloCpu(Long intervaloCpu) {
        this.intervaloCpu = intervaloCpu;
    }

    public Long getIntervaloMemoria() {
        return intervaloMemoria;
    }

    public void setIntervaloMemoria(Long intervaloMemoria) {
        this.intervaloMemoria = intervaloMemoria;
    }

    public Long getIntervaloSwap() {
        return intervaloSwap;
    }

    public void setIntervaloSwap(Long intervaloSwap) {
        this.intervaloSwap = intervaloSwap;
    }

    public String getHostMonitoramento() {
        return hostMonitoramento;
    }

    public void setHostMonitoramento(String hostMonitoramento) {
        this.hostMonitoramento = hostMonitoramento;
    }

    public String getHostMonitoramento2() {
        return hostMonitoramento2;
    }

    public void setHostMonitoramento2(String hostMonitoramento2) {
        this.hostMonitoramento2 = hostMonitoramento2;
    }

    public Long getIntervaloLeituraConfiguracoes() {
        return intervaloLeituraConfiguracoes;
    }

    public void setIntervaloLeituraConfiguracoes(Long intervaloLeituraConfiguracoes) {
        this.intervaloLeituraConfiguracoes = intervaloLeituraConfiguracoes;
    }

    public Long getIntervaloLeituraConfiguracoesDb() {
        return intervaloLeituraConfiguracoesDb;
    }

    public void setIntervaloLeituraConfiguracoesDb(Long intervaloLeituraConfiguracoesDb) {
        this.intervaloLeituraConfiguracoesDb = intervaloLeituraConfiguracoesDb;
    }

    public Long getPorta() {
        return porta;
    }

    public void setPorta(Long porta) {
        this.porta = porta;
    }

    public Long getPorta2() {
        return porta2;
    }

    public void setPorta2(Long porta2) {
        this.porta2 = porta2;
    }

    @Override
    public void setId(Long id){
        this.id = id;
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
