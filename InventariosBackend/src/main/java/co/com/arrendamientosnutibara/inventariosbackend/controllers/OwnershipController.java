/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.controllers;

import co.com.arrendamientosnutibara.inventariosbackend.daos.OwnershipDAO;
import co.com.arrendamientosnutibara.inventariosbackend.entities.Ownership;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.CommonResponses;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.TokenUtils;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import spark.Request;
import spark.Response;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class OwnershipController {
    
    private Gson gson;
    
    public OwnershipController(){
        this.gson = new Gson();
    }
    
    public Response getOwnership(Request req, Response res){
        try {
            String token = req.queryParams("token"); 
            int code = Integer.valueOf(req.params("code"));
            
            if(token == null){
                res.body(CommonResponses._BAD_REQUEST_BODY.toString());
                return res;
            }      
            
            TokenUtils.verifyToken(token);
            Ownership ownership = OwnershipDAO.getOwnership(code);
            
            if(ownership == null){                
                res.body(CommonResponses._OK_BUT_FAIL_BODY
                        .put("message", "Ownership doesn't exists")
                        .put("exists", false).toString());
                return res;
            }
            
            res.body(CommonResponses._OK_BODY.put("exists", true)
                    .put("ownership", gson.toJson(ownership)).toString());
            return res;
        } catch (UnsupportedEncodingException ex) {
            res.body(CommonResponses._OK_BUT_FAIL_BODY
                    .put("message", "Token encoding is not supported")
                    .toString());
            return res;
        } catch (JWTVerificationException ex) {
            res.body(CommonResponses._OK_BUT_FAIL_BODY
                    .put("message", ex.getMessage())
                    .toString());
            return res;
        } catch (NumberFormatException ex){
            res.body(CommonResponses._OK_BUT_FAIL_BODY
                    .put("message", "Code param is not an int or is null")
                    .toString());
            return res;
        }
    }

}
