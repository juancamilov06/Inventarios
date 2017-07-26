/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.daos;

import co.com.arrendamientosnutibara.inventariosbackend.entities.Element;
import co.com.arrendamientosnutibara.inventariosbackend.entities.ElementMaterial;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.Database;
import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class ElementDAO {
    
    private static final Sql2o instance;
    static{
        instance = Database.getDatabaseInstance();
    }
    
    public static List<ElementMaterial> getElementsWithMaterials(){
        String sentence = "SELECT id, elemento_id AS elementId, "
                + "material_id AS materialId "
                + "FROM dbo.TblInvElementoMaterial";
        try{
            Connection connection = instance.open();
            return connection.createQuery(sentence)
                    .executeAndFetch(ElementMaterial.class);                    
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Element> getElements(){
        String sentence = "SELECT id, elemento AS element, "
                + "seccion_id AS sectionId "
                + "FROM dbo.TblInvElementos";
        try{
            Connection connection = instance.open();
            return connection.createQuery(sentence)
                    .executeAndFetch(Element.class);                    
        } catch(Exception e){
            return null;
        }
    }

}
