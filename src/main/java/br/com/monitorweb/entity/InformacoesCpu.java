package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_cpu", schema = "public")
@SequenceGenerator(name = "tb_informacoes_cpu_cpui_id_seq", sequenceName = "public.tb_informacoes_cpu_cpui_id_seq")
public class InformacoesCpu extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_informacoes_cpu_cpui_id_seq")
    @Column(name = "cpui_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Column(name = "cpui_nome")
    private String nome;

    @Column(name = "cpui_cache_size")
    private Long cacheSize;

    @Column(name = "cpui_cpu_cores")
    private Long cpuCores;

    //Numero de cores Virtuais
    @Column(name = "cpui_siblings")
    private Long siblings;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cpui_dthr_cadastro")
    private Date dtHrCadastro;

    public Long getId() {
        return id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Long cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Long getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Long getSiblings() {
        return siblings;
    }

    public void setSiblings(Long siblings) {
        this.siblings = siblings;
    }

    public Date getDtHrCadastro() {
        return dtHrCadastro;
    }

    public void setDtHrCadastro(Date dtHrCadastro) {
        this.dtHrCadastro = dtHrCadastro;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
