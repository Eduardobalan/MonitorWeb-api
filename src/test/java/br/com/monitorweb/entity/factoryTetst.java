package br.com.monitorweb.entity;

import br.com.monitorweb.entity.generic.GenericEntity;
import br.com.monitorweb.exception.GenericRuntimeException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class factoryTetst {


    public static void equalComparandoObjetoTest(String nomeClassePrincipal, String nomeClasseSecundaria){
        try{

            Object obj = Class.forName(nomeClassePrincipal).newInstance();
            GenericEntity var1 = (GenericEntity) obj;
            var1.setId(1L);

            Object obj2 = Class.forName(nomeClassePrincipal).newInstance();
            GenericEntity var2 = (GenericEntity) obj2;
            var2.setId(1L);

            Object obj3 = Class.forName(nomeClassePrincipal).newInstance();
            GenericEntity var3 = (GenericEntity) obj3;
            var3.setId(2L);



            Object obj4 = Class.forName(nomeClasseSecundaria).newInstance();
            GenericEntity var4 = (GenericEntity) obj4;
            var4.setId(1L);

            Object obj5 = Class.forName(nomeClasseSecundaria).newInstance();
            GenericEntity var5 = (GenericEntity) obj5;
            var5.setId(2L);


            assertTrue(var1.equals(var2));
            assertFalse(var1.equals(var3));
            assertFalse(var1.equals(var4));
            assertFalse(var1.equals(var4));

        }catch (Exception e){
            throw new GenericRuntimeException(e.getMessage(), e.getCause());
        }
    }
}
