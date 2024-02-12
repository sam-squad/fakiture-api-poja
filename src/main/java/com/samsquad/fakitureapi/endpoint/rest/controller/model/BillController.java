package com.samsquad.fakitureapi.endpoint.rest.controller.model;

import com.samsquad.fakitureapi.repository.model.Bill;
import com.samsquad.fakitureapi.service.event.BillService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BillController {
    private BillService billService;

    @PostMapping("/bill")
    public Bill addBill(@RequestBody Bill bill) {
        Bill addedBill = billService.addBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBill).getBody();
    }

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/bill/{billNumber}")
    public Bill getBillById(@PathVariable Integer billNumber) throws ChangeSetPersister.NotFoundException {
        return billService.getBillByBillNumber(billNumber);
    }
    @PutMapping("/bill/{billNumber}")
    public Bill updateBill(@PathVariable Integer billNumber) throws ChangeSetPersister.NotFoundException {
        return billService.updateBill(billNumber);
    }
    @DeleteMapping("/bill/{billNumber}")
    public void deleteBill(@PathVariable Integer billNumber){
        billService.deleteBillByBillNumber(billNumber);
    }

}


