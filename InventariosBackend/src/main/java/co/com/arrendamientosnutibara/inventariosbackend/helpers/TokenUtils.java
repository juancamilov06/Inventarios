/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.helpers;

import co.com.arrendamientosnutibara.inventariosbackend.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class TokenUtils {
    
    public static String generateAuthToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");            
            return JWT.create()
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withIssuer("nutibara_API")
                    .withClaim("user", new JSONObject()
                            .put("CodUser", user.getNameUser())
                            .put("NameUser", user.getCodUser()).toString())
                    .withNotBefore(new Date(System.currentTimeMillis()))
                    .withExpiresAt(DateUtils.addMonths(new Date(), 3))      
                    .sign(algorithm);
        } catch (IllegalArgumentException | UnsupportedEncodingException ex) {
            return null;
        }
    }
    
    public static User verifyToken(String token) 
            throws UnsupportedEncodingException, JWTVerificationException{
        
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("nutibara_API")
                .build();
        DecodedJWT decoded = verifier.verify(token);              
        return new Gson().fromJson(decoded.getClaim("user").asString()
                , User.class);        
    }
    

}
