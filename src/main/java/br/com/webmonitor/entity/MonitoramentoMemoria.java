package br.com.webmonitor.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Eduardo Balan on 07/07/2017.
 */
@Entity
@Table(name = "tb_monitoramento_memoria", schema = "public")
public class MonitoramentoMemoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memm_id")
    private Long id;

    //@Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memi_id")
    private InformacoesMemoria informacoesMemoria;

    //memm_dthr_cadastro

    @Column(name = "memm_active")
    private Long active;

    @Column(name = "memm_memfree")
    private Long memfree;

    @Column(name = "memm_availabre")
    private Long availabre;

    @Column(name = "memm_buffers")
    private Long buffers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacoesMemoria getInformacoesMemoria() {
        return informacoesMemoria;
    }

    public void setInformacoesMemoria(InformacoesMemoria informacoesMemoria) {
        this.informacoesMemoria = informacoesMemoria;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getMemfree() {
        return memfree;
    }

    public void setMemfree(Long memfree) {
        this.memfree = memfree;
    }

    public Long getAvailabre() {
        return availabre;
    }

    public void setAvailabre(Long availabre) {
        this.availabre = availabre;
    }

    public Long getBuffers() {
        return buffers;
    }

    public void setBuffers(Long buffers) {
        this.buffers = buffers;
    }
}
