package br.com.monitorweb.service.generic;

import br.com.monitorweb.business.generic.GenericBO;
import br.com.monitorweb.entity.generic.GenericEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import java.util.List;


/**
 * Class de service GenericService é responsavel pelos servições mais genericos com poucas regras de negocio.:
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
public class GenericService<E extends GenericEntity, B extends GenericBO<E, R>, R extends JpaRepository<E, Long>> {

    /* Regras de servico da Entity.*/
    @Autowired
    private B business;

    /* Repositorio responsavel pela Entity.*/
    @Autowired
    private R repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<E> buscar(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Object buscarPorId(@PathVariable("id") Long id){
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void excluir(@PathVariable("id") Long id) {
        business.excluir(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public E inserir(@RequestBody E entitySalvar) {
        return business.inserir(entitySalvar);
    }
}
