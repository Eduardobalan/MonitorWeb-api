package br.com.monitorweb.entity;

import br.com.monitorweb.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_monitoramento_postgres_informacoes", schema = "public")
@SequenceGenerator(name = "tb_monitoramento_postgres_informacoes_dbip_id_seq", sequenceName = "public.tb_monitoramento_postgres_informacoes_dbip_id_seq")
public class MonitoramentoPostgresInformacoes extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_monitoramento_postgres_informacoes_dbip_id_seq")
    @Column(name = "dbip_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scid_id")
    private ServidorConfigInformacoesDb servidorConfigInformacoesDb;

    @Column(name = "dbip_listen_addresses")
    private String listenAddresses;

    @Column(name = "dbip_port")
    private String port;

    @Column(name = "dbip_max_connections")
    private String maxConnections;

    @Column(name = "dbip_ssl")
    private String ssl;

    @Column(name = "dbip_shared_buffers")
    private String sharedBuffers;

    @Column(name = "dbip_temp_buffers")
    private String tempBuffers;

    @Column(name = "dbip_work_mem")
    private String workMem;

    @Column(name = "dbip_maintenance_work_mem")
    private String maintenanceWorkMem;

    @Column(name = "dbip_replacement_wort_tuples")
    private String replacementWortTuples;

    @Column(name = "dbip_max_stack_depth")
    private String maxStackDepth;

    @Column(name = "dbip_max_prepared_transactions")
    private String maxPreparedTransactions;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbip_dthr_cadastro")
    private Date dtHrCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServidorConfigInformacoesDb getServidorConfigInformacoesDb() {
        return servidorConfigInformacoesDb;
    }

    public void setServidorConfigInformacoesDb(ServidorConfigInformacoesDb servidorConfigInformacoesDb) {
        this.servidorConfigInformacoesDb = servidorConfigInformacoesDb;
    }

    public String getListenAddresses() {
        return listenAddresses;
    }

    public void setListenAddresses(String listenAddresses) {
        this.listenAddresses = listenAddresses;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    public String getWorkMem() {
        return workMem;
    }

    public void setWorkMem(String workMem) {
        this.workMem = workMem;
    }

    public String getMaxPreparedTransactions() {
        return maxPreparedTransactions;
    }

    public String getSharedBuffers() {
        return sharedBuffers;
    }

    public void setSharedBuffers(String sharedBuffers) {
        this.sharedBuffers = sharedBuffers;
    }

    public String getTempBuffers() {
        return tempBuffers;
    }

    public void setTempBuffers(String tempBuffers) {
        this.tempBuffers = tempBuffers;
    }

    public void setMaxPreparedTransactions(String maxPreparedTransactions) {
        this.maxPreparedTransactions = maxPreparedTransactions;
    }

    public String getMaintenanceWorkMem() {
        return maintenanceWorkMem;
    }

    public void setMaintenanceWorkMem(String maintenanceWorkMem) {
        this.maintenanceWorkMem = maintenanceWorkMem;
    }

    public String getReplacementWortTuples() {
        return replacementWortTuples;
    }

    public void setReplacementWortTuples(String replacementWortTuples) {
        this.replacementWortTuples = replacementWortTuples;
    }

    public String getMaxStackDepth() {
        return maxStackDepth;
    }

    public void setMaxStackDepth(String maxStackDepth) {
        this.maxStackDepth = maxStackDepth;
    }

    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }
}
