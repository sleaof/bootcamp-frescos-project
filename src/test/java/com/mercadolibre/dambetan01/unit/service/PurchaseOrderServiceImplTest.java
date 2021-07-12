package com.mercadolibre.dambetan01.unit.service;

import com.mercadolibre.dambetan01.dtos.ProductBatchOrderDTO;
import com.mercadolibre.dambetan01.dtos.PurchaseOrderDTO;
import com.mercadolibre.dambetan01.dtos.response.ProductResponseDTO;
import com.mercadolibre.dambetan01.dtos.response.TotalPriceResponseDTO;
import com.mercadolibre.dambetan01.enums.OrderStatus;
import com.mercadolibre.dambetan01.enums.ProductCategory;
import com.mercadolibre.dambetan01.exceptions.NotFoundException;
import com.mercadolibre.dambetan01.model.*;
import com.mercadolibre.dambetan01.repository.BatchHasPurchaseOrderRepository;
import com.mercadolibre.dambetan01.repository.BuyerRepository;
import com.mercadolibre.dambetan01.repository.ProductRepository;
import com.mercadolibre.dambetan01.repository.PurchaseOrderRepository;
import com.mercadolibre.dambetan01.service.crud.IBatchHasPurchaseOrder;
import com.mercadolibre.dambetan01.service.crud.IBatchService;
import com.mercadolibre.dambetan01.service.crud.impl.PurchaseOrderServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PurchaseOrderServiceImplTest {
    PurchaseOrderRepository purchaseOrderRepository = Mockito.mock(PurchaseOrderRepository.class);
    ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    IBatchHasPurchaseOrder batchHasPurchaseOrder = Mockito.mock(IBatchHasPurchaseOrder.class);
    IBatchService batchService = Mockito.mock(IBatchService.class);
    BuyerRepository buyerRepository = Mockito.mock(BuyerRepository.class);
    BatchHasPurchaseOrderRepository batchHasPurchaseOrderRepository = Mockito.mock(BatchHasPurchaseOrderRepository.class);

    PurchaseOrderServiceImpl service;

    PurchaseOrder purchaseOrder;
    PurchaseOrder p = null;
    PurchaseOrderDTO purchaseOrderDTO;
    List<PurchaseOrder> listOfPurchaseOrders  = new ArrayList<>();
    List<JSONObject> listOfPurchaseOrdersByProduct  = new ArrayList<>();
    Buyer buyer;
    Product product;

    @BeforeEach
    void setUp() throws JSONException {
        this.service = new PurchaseOrderServiceImpl(purchaseOrderRepository,
                productRepository,
                batchHasPurchaseOrder,
                batchService,
                buyerRepository,
                new ModelMapper(),
                batchHasPurchaseOrderRepository);

        buyer = new Buyer(1L, "comprador 1");
        product = new Product(1L, "Carne", 0.0, LocalDate.of(2021, 7, 12), 20F, ProductCategory.FROZEN, null);
        List<ProductBatchOrderDTO> productBatchOrderDTOs = new ArrayList<>();
        List<BatchHasPurchaseOrder> batchHasPurchaseOrders = new ArrayList<>();

        batchHasPurchaseOrders.add(new BatchHasPurchaseOrder(1L, 2, purchaseOrder, new Batch()));
        productBatchOrderDTOs.add(new ProductBatchOrderDTO(1L, 2));

        purchaseOrder = new PurchaseOrder(1L, new Date(), OrderStatus.PROCESSING, batchHasPurchaseOrders, buyer);
        purchaseOrderDTO = new PurchaseOrderDTO(1L, new Date(), OrderStatus.PROCESSING, 1L, productBatchOrderDTOs);

        listOfPurchaseOrders.add(new PurchaseOrder(1L, new Date(), OrderStatus.PROCESSING, batchHasPurchaseOrders, buyer));
        listOfPurchaseOrders.add(new PurchaseOrder(2L, new Date(), OrderStatus.PROCESSING, batchHasPurchaseOrders, buyer));

        JSONObject object = new JSONObject();

        object.put("productId", 1L);
        object.put("productName", "Carne");
        object.put("quantity", 6);

        listOfPurchaseOrdersByProduct.add(object);
    }

    @Test
    void purchaseOrderCreate() {
        when(buyerRepository.findById(1L)).thenReturn(Optional.ofNullable(buyer));
        PurchaseOrderDTO purchaseOrderCreate = service.create(purchaseOrderDTO);
        verify(purchaseOrderRepository).save(any());
    }

    @Test
    void purchaseOrderUpdate() {
        when(purchaseOrderRepository.findById(1L)).thenReturn(java.util.Optional.of(purchaseOrder));
        when(buyerRepository.findById(1L)).thenReturn(Optional.ofNullable(buyer));
        PurchaseOrderDTO purchaseOrderUpdate = service.update(purchaseOrderDTO);
        verify(purchaseOrderRepository).save(any());
    }

    @Test
    void purchaseOrderDeleteException() {
        when(purchaseOrderRepository.findById(100L)).thenReturn(Optional.ofNullable(p));
        assertThrows(NotFoundException.class, () -> service.delete(100L),
                "Não foi encontrada nenhuma ordem de compra com este Id: 100");
    }

    @Test
    void purchaseOrderDelete() {
        when(purchaseOrderRepository.findById(1L)).thenReturn(java.util.Optional.of(purchaseOrder));
        service.delete(1L);
        verify(purchaseOrderRepository).deleteById(1L);
    }

    @Test
    void findByIdException() {
        when(purchaseOrderRepository.findById(100L)).thenReturn(Optional.ofNullable(p));
        assertThrows(NotFoundException.class, () -> service.findById(100L),
                "Não foi encontrado nenhum produto com este Id: 100");
    }

    @Test
    void findById() {
        when(purchaseOrderRepository.findById(1L)).thenReturn(java.util.Optional.of(purchaseOrder));
        PurchaseOrderDTO purchaseOrderDTO = service.findById(1L);
        assertEquals(1L, purchaseOrderDTO.getPurchaseOrderId());
    }

    @Test
    void findAll() {
        when(purchaseOrderRepository.findAll()).thenReturn(listOfPurchaseOrders);
        List<PurchaseOrderDTO> purchaseOrderDTOList = service.findAll();
        assertEquals(2L, purchaseOrderDTOList.get(1).getPurchaseOrderId());
    }

//    @Test
//    void findProductsByOrderId() {
//        when(purchaseOrderRepository.findProductsFromOrderById(1L)).thenReturn(listOfPurchaseOrdersByProduct);
//        List<ProductResponseDTO> productResponseDTOs = service.findProductsByOrderId(1L);
//        assertEquals("Carne", productResponseDTOs.get(0).getProductName());
//    }

    @Test
    void calcTotalValue() {
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));
        TotalPriceResponseDTO totalPriceResponseDTO = service.calcTotalValue(purchaseOrderDTO);
        assertEquals(new TotalPriceResponseDTO(40.0), totalPriceResponseDTO);
    }
}
