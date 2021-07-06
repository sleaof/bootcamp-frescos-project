package com.mercadolibre.dambetan01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidField {

    private String variable;
    private String messageError;

}
