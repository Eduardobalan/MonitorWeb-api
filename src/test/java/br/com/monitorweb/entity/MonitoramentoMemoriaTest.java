package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.monitorweb.entity.factoryTetst.equalComparandoObjetoTest;

@RunWith(MockitoJUnitRunner.class)
public class MonitoramentoMemoriaTest{

    @Test
    public void equalObjetoTest(){
        equalComparandoObjetoTest("br.com.monitorweb.entity.MonitoramentoMemoria","br.com.monitorweb.entity.Dominio");
    }
}

