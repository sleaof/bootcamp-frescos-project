package com.mercadolibre.dambetan01.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1")
@RestController
public class InboundOrderController {

    @PostMapping("/fresh-products/inbounded/")
    public String createInboundOrder(){
        return "Criando um lote nove";
    }

    @PutMapping("/fresh-products/inbounded/")
    public String upadateInboundOrder(){
        return "Atualizou os lotes";
    }
}
