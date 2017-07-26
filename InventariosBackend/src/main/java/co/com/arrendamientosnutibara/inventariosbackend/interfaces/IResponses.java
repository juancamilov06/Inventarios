/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.arrendamientosnutibara.inventariosbackend.interfaces;

import spark.Response;

/**
 *
 * @author jva807
 */
public interface IResponses {
    public Response okResponse(Response res);
    public Response internalServerErrorResponse(Response res);
    public Response badRequestResponse(Response res);
    public Response unauthorizedResponse(Response res);
}
