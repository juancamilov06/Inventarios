/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.controllers;

import co.com.arrendamientosnutibara.inventariosbackend.entities.User;
import co.com.arrendamientosnutibara.inventariosbackend.daos.AuthDAO;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.CommonResponses;
import co.com.arrendamientosnutibara.inventariosbackend.helpers.TokenUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

/**
 *
 * @author Juan Camilo Villa Amaya
 * Puto El que lo lea
 */
public class AuthController{
    
    public Response login(Request req, Response res){
        String code = getCodeParam(req.body());
        if(code == null){            
            res.body(CommonResponses._BAD_REQUEST_BODY.toString());
            return res;
        }
        User user = AuthDAO.login(code);
        return resolveResponse(user, res);
    }
    
    private Response resolveResponse(User user, Response res){
        if(user == null){
            res.body(CommonResponses._OK_BUT_FAIL_BODY
                    .put("message", "Login failed, user not found").toString());
            return res;
        }    
        
        String token = TokenUtils.generateAuthToken(user);
        if(token == null){
            res.body(CommonResponses._INTERNAL_ERROR_BODY
                    .put("message", "Login failed, token unresolved").toString());
            return res;
        }
        
        res.body(CommonResponses._OK_BODY
                    .put("token", token).toString());
        return res;
    }
    
    
    private String getCodeParam(String req){
        JSONObject object = new JSONObject(req);
        try{
            return object.getString("code");
        } catch(JSONException e){
            return null;
        }
    }   
}
