package br.com.monitorweb.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SqlInexistenteRuntimeExceptionTest {

    @Test
    public void exceptionRecebendoValorTest() {
        try {
            throw new SqlInexistenteRuntimeException("TESTE");
        } catch (SqlInexistenteRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("TESTE"));
        }
    }

    @Test
    public void exceptionRecebendoExceptionTest() {
        try {
            throw new SqlInexistenteRuntimeException(new Exception("TESTE"));
        } catch (SqlInexistenteRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("TESTE"));
        }
    }

    @Test
    public void exceptionRecebendoValorECausaTest() {
        try {
            throw new SqlInexistenteRuntimeException("TESTE", null);
        } catch (SqlInexistenteRuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("TESTE"));
        }
    }
}
