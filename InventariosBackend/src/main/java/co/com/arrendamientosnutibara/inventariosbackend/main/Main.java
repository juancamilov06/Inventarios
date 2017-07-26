/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.main;

import co.com.arrendamientosnutibara.inventariosbackend.controllers.AuthController;
import co.com.arrendamientosnutibara.inventariosbackend.controllers.BasicController;
import co.com.arrendamientosnutibara.inventariosbackend.controllers.OwnershipController;
import org.sql2o.Sql2o;
import static spark.Spark.*;
/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class Main {

    public static void main(String[] args){     
                       
        post("/auth", (req, res) -> {
            res.type("application/json");
            AuthController controller = new AuthController();
            return controller.login(req, res).body();
        });   
        path("/ownership", () -> {
            get("/:code", (req, res) -> {
                res.type("application/json");
                OwnershipController controller = new OwnershipController();
                return controller.getOwnership(req, res).body();
            });            
        });       
        
        get("/basic", (req, res) -> {
            res.type("application/json");
            BasicController controller = new BasicController();
            return controller.getBaseData(req, res).body();
        });
        
    }

}
