/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrobuschallenge.exception;

/**
 * Exception class
 *
 * @author Jose Torrealba
 *
 */
public class ThirdPartyRequestException extends Exception {

    private static final long serialVersionUID = 75178919869352660L;

    public ThirdPartyRequestException() {
        super();
    }

    public ThirdPartyRequestException(String message) {
        super(message);
    }

    public ThirdPartyRequestException(String typeObject, String id) {
        super(String.format("No se pudo realizar la consulta", typeObject, id));
    }
}
