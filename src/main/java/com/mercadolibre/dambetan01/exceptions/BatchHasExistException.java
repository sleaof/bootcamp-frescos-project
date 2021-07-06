package com.mercadolibre.dambetan01.exceptions;

public class BatchHasExistException extends RuntimeException{

    public BatchHasExistException (String msg){
        super(msg);
    }
}
