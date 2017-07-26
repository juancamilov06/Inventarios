/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.entities;

public class User{    
    
    private String CodUser;
    private String NameUser; 

    public String getCodUser() {
        return CodUser;
    }
    
    public void setCodUser(String CodUser) {
        this.CodUser = CodUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }
}
