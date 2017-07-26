/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.entities;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class ElementMaterial {
    
    private int id;
    private int elementId;
    private int materialId;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the elementId
     */
    public int getElementId() {
        return elementId;
    }

    /**
     * @param elementId the elementId to set
     */
    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    /**
     * @return the materialId
     */
    public int getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

}
