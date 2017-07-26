/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.daos;

import co.com.arrendamientosnutibara.inventariosbackend.entities.Type;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.Database;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class TypeDAO {
    
    private static final Sql2o instance;
    static{
        instance = Database.getDatabaseInstance();
    }
    
    public static List<Type> getTypes(){
        String sentence = "SELECT id, tipo AS type "
                + "FROM dbo.TblInvTipo";
        try{
            Connection connection = instance.open();
            return connection.createQuery(sentence)
                    .executeAndFetch(Type.class);                    
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
