/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.helpers;

import org.sql2o.Sql2o;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class Database {
    
    private static Sql2o databaseInstance;
    
    public static Sql2o getDatabaseInstance(){
        databaseInstance = new Sql2o("jdbc:sqlserver://192.168.0.4:1433;"
                + "databaseName=SAP"
                , "UsrInventarios"
                , "nutibara");
        return databaseInstance;
    }

}
