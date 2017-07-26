/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.arrendamientosnutibara.inventariosbackend.helpers;

import org.eclipse.jetty.server.Response;
import org.json.JSONObject;

/**
 *
 * @author Juan Camilo Villa Amaya
 */
public class CommonResponses {
    
    public static JSONObject _BAD_REQUEST_BODY = new JSONObject()
            .put("success", false)
            .put("code", Response.SC_BAD_REQUEST)
            .put("message", "Bad Request");
    
    public static JSONObject _INTERNAL_ERROR_BODY = new JSONObject()
            .put("success", false)
            .put("code", Response.SC_INTERNAL_SERVER_ERROR)
            .put("message", "Internal server error, try again later");
    
    public static JSONObject _OK_BUT_FAIL_BODY = new JSONObject()
            .put("success", false)
            .put("code", Response.SC_OK);
    
    public static JSONObject _OK_BODY = new JSONObject()
            .put("success", true)
            .put("code", Response.SC_OK);

}
