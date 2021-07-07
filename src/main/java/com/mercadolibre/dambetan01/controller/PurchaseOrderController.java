package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;
import com.mercadolibre.dambetan01.service.crud.IPurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/v1")
@RestController
public class PurchaseOrderController {

    private IPurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(IPurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/fresh-products/orders/")
    public ResponseEntity<List<ProductResponseDTO>> selectedProductsFromOrderId(@RequestParam("orderId") Long orderId) {
        if (orderId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(purchaseOrderService.findProductsByOrderId(orderId), HttpStatus.OK);
    }

    @PostMapping("/fresh-products/orders/")
    public ResponseEntity<TotalPriceResponseDTO> createOrder(@Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        purchaseOrderService.create(purchaseOrderDTO);
        return new ResponseEntity<>(purchaseOrderService.calcTotalValue(purchaseOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping("/fresh-products/orders")
    public ResponseEntity<PurchaseOrderDTO> updateProductsById(@RequestParam("orderId") Long orderId, @Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        if (orderId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        purchaseOrderDTO.setPurchaseOrderId(orderId);
        return new ResponseEntity<>(purchaseOrderService.update(purchaseOrderDTO), HttpStatus.OK);
    }
}
