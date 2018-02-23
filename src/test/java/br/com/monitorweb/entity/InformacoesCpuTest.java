package br.com.monitorweb.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.monitorweb.entity.factoryTetst.equalComparandoObjetoTest;


@RunWith(MockitoJUnitRunner.class)
public class InformacoesCpuTest {

    @Test
    public void equalObjetoTest(){
        equalComparandoObjetoTest("br.com.monitorweb.entity.Dominio","br.com.monitorweb.entity.InformacoesCpu");
    }
}
