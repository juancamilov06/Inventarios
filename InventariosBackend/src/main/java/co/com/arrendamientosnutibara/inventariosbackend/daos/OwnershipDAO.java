/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.daos;

import co.com.arrendamientosnutibara.inventariosbackend.entities.Ownership;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class OwnershipDAO {
    
    private static final Sql2o instance;
    static{
        instance = Database.getDatabaseInstance();
    }

    public static Ownership getOwnership(int code){
        String sentence = "SELECT CodigoInmueble AS id, "
                + "DireccionInmueble AS address, ValorCanonActual AS canon, "
                + "Latitud AS latitude, Longitud AS longitud, "
                + "Tipo AS type "
                + "FROM dbo.Tblinmueble "
                + "WHERE Cod_Inmueble = :code";
        try{
            Connection connection = instance.open();
            return connection.createQuery(sentence)
                    .throwOnMappingFailure(false)
                    .addParameter("code", code)
                    .executeAndFetchFirst(Ownership.class);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }

}
