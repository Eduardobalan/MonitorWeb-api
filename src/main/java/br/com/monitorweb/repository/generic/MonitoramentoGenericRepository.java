package br.com.monitorweb.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;


/**
 * Classe base para repositorys do tipo Monitoramento
 *
 * @author Eduardo Balan
 *
 * @param <I>  IdType ou tipo do atributo id
 * @param <E> Entity ou entidade da aplicação
 */
@NoRepositoryBean
public interface MonitoramentoGenericRepository<E, I extends Serializable> extends JpaRepository<E, I>, QueryDslPredicateExecutor<E> {

    List<E> findByidInformacoes(Long id);
}
