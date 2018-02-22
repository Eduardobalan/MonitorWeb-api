package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_swap" , schema = "public")
@SequenceGenerator(name = "tb_informacoes_swap_swai_id_seq", sequenceName = "public.tb_informacoes_swap_swai_id_seq")
public class InformacoesSwap extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_informacoes_swap_swai_id_seq")
    @Column(name = "swai_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "swai_dthr_cadastro")
    private Date dtHrCadastro;

    @Column(name = "swai_total")
    private Long total;

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }
}
