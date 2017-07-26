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
public class Section {
    
    private int id;
    private String section;
    private int typeId;

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
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the type_id
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the type_id to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

}
