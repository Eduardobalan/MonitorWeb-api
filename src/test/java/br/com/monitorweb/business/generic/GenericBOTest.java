package br.com.monitorweb.business.generic;


import br.com.monitorweb.entity.Usuario;
import br.com.monitorweb.exception.SqlGenericRuntimeException;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import br.com.monitorweb.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GenericBOTest {

    @InjectMocks
    private GenericBO<br.com.monitorweb.entity.Usuario, UsuarioRepository> genericBo;

    @Mock
    private UsuarioRepository repository;


    @Test
    public void inserirExceptionTest() {
        Usuario entityNova = new Usuario();
        entityNova.setId(1l);

        Mockito.doThrow(SqlGenericRuntimeException.class).when(repository).save(entityNova);

        try {
            genericBo.inserir(entityNova);
        } catch (SqlGenericRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Exception DB -> null"));
        }
    }

    @Test
    public void excluirExceptionTest() {
        Usuario entityTest = new Usuario();
        entityTest.setId(1l);

        Mockito.when(repository.findOne(entityTest.getId())).thenReturn(null);

        try {
            genericBo.excluir(entityTest.getId());
        } catch (SqlInexistenteRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Registro não encontrado na base de dados."));
        }
    }

    @Test
    public void excluirExceptionAoDeletarDoBancoTest() {
        Usuario entityTest = new Usuario();
        entityTest.setId(1l);

        Mockito.when(repository.findOne(entityTest.getId())).thenReturn(entityTest);

        Mockito.doThrow(SqlGenericRuntimeException.class).when(repository).delete(entityTest.getId());

        try {
            genericBo.excluir(entityTest.getId());
        } catch (SqlGenericRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Exception DB -> null"));
        }
    }
}
