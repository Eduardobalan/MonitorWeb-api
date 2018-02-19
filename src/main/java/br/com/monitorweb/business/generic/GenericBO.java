package br.com.monitorweb.business.generic;

import br.com.monitorweb.entity.generic.GenericEntity;
import br.com.monitorweb.exception.SqlGenericRuntimeException;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * Class GenericBO é a classe responsável  por regras de negocio, genéricos e simples como:
 * Inserção em uma base de dados, remoção da base de dados, e update.
 *
 * @author Eduardo Balan
 *
 * @param Entity Entidade a qual ela ira prestar o servico.
 * @param Repository Repositorio responsavel pela Entity que vc esta utilizando.
 *
 * @throws SqlInexistenteRuntimeException
 * @throws SqlGenericRuntimeException
 */
@MappedSuperclass
public class GenericBO <E extends GenericEntity, R extends JpaRepository<E, Long>> {

    /* Repositorio responsavel pela Entity */
    @Autowired
    private R repository;

    /**
     * Metodo responsável pelas regras de negocio genéricas da inserção.
     *
     * @author Eduardo Balan
     *
     * @param E Entidade que sera persistida no banco de dados.
     *
     * @throws SqlGenericRuntimeException
     *
     * return Entity persistida no banco de dados.
     */
    public E inserir(E entityNova){
        try{
            entityNova.setDtHrCadastro(new Date());
            return repository.save(entityNova);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

    /**
     * Metodo responsável pelas regras de negocio genéricas da exclusão.
     *
     * @author Eduardo Balan
     *
     * @param Long id da entidade que sera removida do banco de dados.
     *
     * @throws SqlInexistenteRuntimeException
     * @throws SqlGenericRuntimeException
     *
     * return void.
     */
    public void excluir(Long idEntity){
        E entityPersistidaNoDB = repository.findOne(idEntity);
        if(entityPersistidaNoDB == null){
            throw new SqlInexistenteRuntimeException("Registro não encontrado na base de dados.", null);
        }
        try{
            repository.delete(idEntity);
        }catch (Exception e){
            throw new SqlGenericRuntimeException(e);
        }
    }

}
