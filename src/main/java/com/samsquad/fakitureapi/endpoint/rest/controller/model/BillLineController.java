package com.samsquad.fakitureapi.endpoint.rest.controller.model;

import com.samsquad.fakitureapi.repository.model.BillLine;
import com.samsquad.fakitureapi.service.event.BillLineService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BillLineController {
    private final BillLineService billLineService;

    @PostMapping("/billLine")
    public ResponseEntity<BillLine> addBillLine(@RequestBody BillLine billLine) {
        BillLine addedBillLine = billLineService.addBillLine(billLine);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBillLine);
    }

    @GetMapping("/billLines")
    public List<BillLine> getAllBillLines() {
        return billLineService.getAllBillLines();
    }

    @GetMapping("/billLine/{billLineNumber}")
    public BillLine getBillLineById(@PathVariable Integer billLineNumber) throws ChangeSetPersister.NotFoundException {
        return billLineService.getBillLineByBillLineNumber(billLineNumber);
    }

    @PutMapping("/billLine/{billLineNumber}")
    public BillLine updateBillLine(@PathVariable Integer billLineNumber) throws ChangeSetPersister.NotFoundException {
        return billLineService.updateBillLine(billLineNumber);
    }

    @DeleteMapping("/billLine/{billLineNumber}")
    public void deleteBillLine(@PathVariable Integer billLineNumber) {
        billLineService.deleteBillLineByBillLineNumber(billLineNumber);
    }
}

