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
public class Ownership {
    
    private int id;
    private int canon;
    private String address;
    private double latitude;
    private double longitude;
    private String ownerName;
    private int typeId;
    private transient String type;
    private String lessee;
    private String lesseePhone;
    private String neighborhood;

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
     * @return the canon
     */
    public int getCanon() {
        return canon;
    }

    /**
     * @param canon the canon to set
     */
    public void setCanon(int canon) {
        this.canon = canon;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the lessee
     */
    public String getLessee() {
        return lessee;
    }

    /**
     * @param lessee the lessee to set
     */
    public void setLessee(String lessee) {
        this.lessee = lessee;
    }

    /**
     * @return the lesseePhone
     */
    public String getLesseePhone() {
        return lesseePhone;
    }

    /**
     * @param lesseePhone the lesseePhone to set
     */
    public void setLesseePhone(String lesseePhone) {
        this.lesseePhone = lesseePhone;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
