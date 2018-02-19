package br.com.monitorweb.service.generic;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.generic.GenericEntity;
import br.com.monitorweb.entity.Servidor;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import br.com.monitorweb.repository.generic.InformacoesGenericRepository;
import br.com.monitorweb.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.MappedSuperclass;
import java.util.List;


/**
 * Class de service InformacoesGenericService é responsavel pelos serviços genericos do tipo Informações.
 *
 * @author Eduardo Balan
 *
 * @param Entity Entidade a qual ela ira prestar o servico.
 * @param Business Business responsavel pela regras de servico da entidade.
 * @param Repository Repositorio responsavel pela Entity que vc esta utilizando.
 *
 * @throws SqlInexistenteRuntimeException
 * @throws SqlGenericRuntimeException
 *
 */
@MappedSuperclass
public class InformacoesGenericService<E extends GenericEntity, B extends GenericBO<E, R>, R extends InformacoesGenericRepository<E, Long>> {

    /* Regras de servico da Entity.*/
    @Autowired
    private B business;

    /* Repositorio responsavel pela Entity.*/
    @Autowired
    private R repository;

    /* Repositório do Servidor, a quais todas as entidades do tipo Informacoes posuem relacionamento.*/
    @Autowired
    private ServidorRepository servidorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<E> buscarPorIdServidor(@PathVariable("idServidor") Long idServidor){
        if(idServidor<=0){
            return repository.findAll();
        }

        Servidor servidorDaBusca = servidorRepository.findOne(idServidor);
        if(servidorDaBusca == null){
            throw new SqlInexistenteRuntimeException("Servidor não localizado.", null);
        }else{
            return repository.findByServidor(servidorDaBusca);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{idInformacoes}")
    public E buscarPorIdInformacoes(@PathVariable("idInformacoes") Long idMonitoramento){
        return repository.findOne(idMonitoramento);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{idInformacoes}")
    public void excluir(@PathVariable("idInformacoes") Long idInformacoes) {
        business.excluir(idInformacoes);
    }

    @RequestMapping(method = RequestMethod.POST)
    public E inserir(@RequestBody E entity) {
        return business.inserir(entity);
    }
}
