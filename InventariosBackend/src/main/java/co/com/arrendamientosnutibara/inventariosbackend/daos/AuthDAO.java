/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.daos;

import co.com.arrendamientosnutibara.inventariosbackend.entities.User;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class AuthDAO{
    
    private static final Sql2o instance;
    static{
        instance = Database.getDatabaseInstance();
    }

    public static User login(String code){
        String sentence = "SELECT CodUser, NameUser "
                + "FROM dbo.TblUsuariosSIRECA_Loguin "
                + "WHERE CodUser = :code";
        try{
            Connection connection = instance.open();
            return connection.createQuery(sentence)
                    .addParameter("code", code)
                    .executeAndFetchFirst(User.class);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    
}
