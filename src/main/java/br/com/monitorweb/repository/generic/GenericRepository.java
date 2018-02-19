package br.com.monitorweb.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 * Classe base para Repositorys
 *
 * @author Eduardo Balan
 *
 * @param <I>  IdType ou tipo do atributo id
 * @param <E> Entity ou entidade da aplicação
 */
@NoRepositoryBean
public interface GenericRepository<E, I extends Serializable> extends JpaRepository<E, I>, QueryDslPredicateExecutor<E> {


}
