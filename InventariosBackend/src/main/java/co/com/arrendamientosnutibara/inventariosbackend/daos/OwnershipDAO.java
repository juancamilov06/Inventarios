/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.daos;

import co.com.arrendamientosnutibara.inventariosbackend.entities.Ownership;
import co.com.arrendamientosnutibara.inventariosbackend.enums.SAPTypes;
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
        String sentence = "SELECT inmueble.Cod_Inmueble AS id"
                + ", inmueble.DireccionInmueble AS address"
                + ", inmueble.ValorCanonActual AS canon"
                + ", inmueble.Latitud AS latitud"
                + ", inmueble.Longitud AS longitud, inmueble.Tipo AS type"
                + ", inmueble.Barrio AS neighborhood, terceros.Nombre + ' ' "
                + "+ terceros.ApellidoUno AS ownerName "
                + "FROM SAP.dbo.Tblinmueble AS inmueble " 
                + "JOIN SAP.dbo.Tblidentificacion AS identificacion " 
                + "ON identificacion.Cod_Inm = inmueble.Cod_Inmueble " 
                + "JOIN SAP.dbo.[Tblmaestro de terceros] AS terceros " 
                + "ON identificacion.NumeroIdentificacion = "
                + "terceros.NumeroIdentificacion " 
                + "WHERE inmueble.Cod_Inmueble =  :code";
        try{
            Connection connection = instance.open();
            Ownership ownership = connection.createQuery(sentence)
                    .throwOnMappingFailure(false)
                    .addParameter("code", code)
                    .executeAndFetchFirst(Ownership.class);
            if(ownership != null){
                return mapType(ownership);
            }
            return null;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    
    public static Ownership getReturnedOwnership(int code){
        String sentence = "SELECT inmueble.Cod_Inmueble AS id"
                + ", inmueble.DireccionInmueble AS address"
                + ", inmueble.ValorCanonActual AS canon"
                + ", inmueble.Latitud AS latitud"
                + ", inmueble.Longitud AS longitud, inmueble.Tipo AS type"
                + ", inmueble.Barrio AS neighborhood, terceros.Nombre + ' ' "
                + "+ terceros.ApellidoUno AS ownerName "
                + "FROM SAP.dbo.Tblinmueble AS inmueble " 
                + "JOIN SAP.dbo.TblHistoricoIdentificacion AS identificacion " 
                + "ON identificacion.Cod_Inm = inmueble.Cod_Inmueble " 
                + "JOIN SAP.dbo.[Tblmaestro de terceros] AS terceros " 
                + "ON identificacion.NumeroIdentificacion = "
                + "terceros.NumeroIdentificacion " 
                + "WHERE inmueble.Cod_Inmueble =  :code";
        try{
            Connection connection = instance.open();
            Ownership ownership = connection.createQuery(sentence)
                    .throwOnMappingFailure(false)
                    .addParameter("code", code)
                    .executeAndFetchFirst(Ownership.class);
            if(ownership != null){
                return mapType(ownership);
            }
            return null;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    
    private static Ownership mapType(Ownership ownership){
        String tipo = ownership.getType();
        if(SAPTypes.DWELLING.contains(tipo)){
            ownership.setTypeId(1);
            return ownership;
        }
        if(SAPTypes.SHOPS.contains(tipo)) {
            ownership.setTypeId(2);
            return ownership;
        }
        if(tipo.equals("OFICINA")){
            ownership.setTypeId(3);
            return ownership;
        }
        ownership.setTypeId(4);
        return ownership;
    }

}
