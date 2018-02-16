package br.com.monitorweb.service;

import br.com.monitorweb.GenericTest;
import br.com.monitorweb.exception.SqlInexistenteRuntimeException;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Eduardo Balan on 27/06/2017.
 */

@DatabaseSetup(value = ServidorConfigServerTest.DATASET, type = DatabaseOperation.INSERT)
public class ServidorConfigServerTest extends GenericTest {

    protected static final String DATASET = "classpath:/datasets/service/ServidorConfig.xml";

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscarTodosTest() throws Exception {
        mockMvc.perform(get("/servidor/0/servidorconfiguracoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].dtHrAlteracao", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].dtHrCadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$[0].intervaloCpu", is(15)))
                .andExpect(jsonPath("$[0].intervaloMemoria", is(20)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)));
    }

    @Test
    public void buscarTodosPorServidorTest() throws Exception {
        mockMvc.perform(get("/servidor/1/servidorconfiguracoes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].servidor.id", is(1)))
                .andExpect(jsonPath("$[0].intervaloCpu", is(15)))
                .andExpect(jsonPath("$[0].intervaloMemoria", is(20)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].servidor.id", is(1)))
                .andExpect(jsonPath("$[1].intervaloCpu", is(10)))
                .andExpect(jsonPath("$[1].intervaloMemoria", is(25)));
    }

    @Test
    public void buscarPorIdTest() throws Exception {
        mockMvc.perform(get("/servidor/0/servidorconfiguracoes/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.dtHrCadastro", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.servidor.id", is(1)))
                .andExpect(jsonPath("$.intervaloCpu", is(10)))
                .andExpect(jsonPath("$.intervaloMemoria", is(25)));
    }

    @Test
    public void inserirTodoObjetoTest() throws Exception {

        mockMvc.perform(post("/servidor/0/servidorconfiguracoes/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{ " +
                        " \"nome\" : \"Novo Registro\" ," +
                        " \"servidor\":{\"id\":2}," +
                        " \"dtHrAlteracao\" : \"2017-02-28T04:00:00.000+0000\" ," +
                        " \"intervaloMemoria\" : 100 ," +
                        " \"intervaloSwap\" : 101 ," +
                        " \"hostMonitoramento\" : \"192.168.1.111\" ," +
                        " \"hostMonitoramento2\" : \"192.168.1.112\" ," +
                        " \"ip\" : \"10.1.1.10\" ," +
                        " \"intervaloLeituraConfiguracoes\" : 103 ," +
                        " \"intervaloLeituraConfiguracoesDb\" : 104 ," +
                        " \"porta\" : 999 ," +
                        " \"porta2\" : 998 ," +
                        " \"intervaloCpu\" : 105 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(4)))
                .andExpect(jsonPath("$.servidor.id", is(2)))
                .andExpect(jsonPath("$.dtHrAlteracao", is("2017-02-28T04:00:00.000+0000")))
                .andExpect(jsonPath("$.intervaloMemoria", is(100)))
                .andExpect(jsonPath("$.intervaloSwap", is(101)))
                .andExpect(jsonPath("$.hostMonitoramento", is("192.168.1.111")))
                .andExpect(jsonPath("$.hostMonitoramento2", is("192.168.1.112")))
                .andExpect(jsonPath("$.intervaloLeituraConfiguracoes", is(103)))
                .andExpect(jsonPath("$.intervaloLeituraConfiguracoesDb", is(104)))
                .andExpect(jsonPath("$.porta", is(999)))
                .andExpect(jsonPath("$.porta2", is(998)))
                .andExpect(jsonPath("$.intervaloCpu", is(105)));
    }

    @Test
    public void deletarTest() throws Exception {
        mockMvc.perform(delete("/servidor/0/servidorconfiguracoes/3"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/servidor/0/servidorconfiguracoes/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    //----------------  Exception ----------------------------

    @Test
    public void deletarIdInexistenteTest() throws Exception {

        Exception expt = mockMvc.perform(delete("/servidor/0/servidorconfiguracoes/999999"))
                .andExpect(status().isInternalServerError())
                .andReturn().getResolvedException();

        Assert.assertTrue(expt.getClass().isAssignableFrom(SqlInexistenteRuntimeException.class));
        Assert.assertTrue(expt.getMessage().equals("Registro não encontrado na base de dados."));
    }
}


