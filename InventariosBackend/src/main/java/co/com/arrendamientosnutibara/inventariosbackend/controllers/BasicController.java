/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.controllers;

import co.com.arrendamientosnutibara.inventariosbackend.daos.ElementDAO;
import co.com.arrendamientosnutibara.inventariosbackend.daos.MaterialDAO;
import co.com.arrendamientosnutibara.inventariosbackend.daos.SectionDAO;
import co.com.arrendamientosnutibara.inventariosbackend.daos.TypeDAO;
import co.com.arrendamientosnutibara.inventariosbackend.entities.Type;
import co.com.arrendamientosnutibara.inventariosbackend.entities.User;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.CommonResponses;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.TokenUtils;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class BasicController {
        
    public Response getBaseData(Request req, Response res){
        try{
            JSONObject base = new JSONObject();
            base.put("types", TypeDAO.getTypes());
            base.put("sections", SectionDAO.getSections());
            base.put("elements", ElementDAO.getElements());
            base.put("materials", MaterialDAO.getMaterials());
            base.put("elements_has_materials", ElementDAO.getElementsWithMaterials());
            res.body(CommonResponses._OK_BODY.put("data", base).toString());
            return res;
        } catch (JSONException e){
            res.body(CommonResponses._INTERNAL_ERROR_BODY.toString());
            return res;
        }
    }
    
    /*public Response getBaseData(Request req, Response res){
        ry {
            String token = req.queryParams("token"); 
            if(token == null){
                res.body(CommonResponses._BAD_REQUEST_BODY.toString());
                return res;
            }            
            User user = TokenUtils.verifyToken(token);
            System.out.println("User: " + user.getCodUser());
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
        }try {
            String token = req.queryParams("token"); 
            if(token == null){
                res.body(CommonResponses._BAD_REQUEST_BODY.toString());
                return res;
            }            
            User user = TokenUtils.verifyToken(token);
            System.out.println("User: " + user.getCodUser());
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
        }
    }    */

}
