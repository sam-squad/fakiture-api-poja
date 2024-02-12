package com.samsquad.fakitureapi.service.event;

import com.samsquad.fakitureapi.repository.BillRepository;
import com.samsquad.fakitureapi.repository.model.Bill;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill getBillByBillNumber(Integer billNumber) throws ChangeSetPersister.NotFoundException {
        return billRepository.findById(billNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public void deleteBillByBillNumber(Integer billNumber) {
        billRepository.deleteById(billNumber);
    }

    public Bill updateBill(Integer billNumber) throws ChangeSetPersister.NotFoundException {
        Bill bill = billRepository.findById(billNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return billRepository.save(bill);
    }
}
