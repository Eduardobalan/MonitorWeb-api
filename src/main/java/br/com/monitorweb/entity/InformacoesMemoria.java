package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
@Table(name = "tb_informacoes_memoria" , schema = "public")
@SequenceGenerator(name = "tb_informacoes_memoria_memi_id_seq", sequenceName = "public.tb_informacoes_memoria_memi_id_seq")
public class InformacoesMemoria extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_informacoes_memoria_memi_id_seq")
    @Column(name = "memi_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "memi_dthr_cadastro")
    private Date dtHrCadastro;

    @Column(name = "memi_total")
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
}
