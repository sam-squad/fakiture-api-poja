package com.samsquad.fakitureapi.service.event;

import com.samsquad.fakitureapi.repository.BillLineRepository;
import com.samsquad.fakitureapi.repository.model.BillLine;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillLineService {

    private final BillLineRepository billLineRepository;

    public BillLine addBillLine(BillLine billLine) {
        return billLineRepository.save(billLine);
    }

    public BillLine getBillLineByBillLineNumber(Integer billLineNumber) throws ChangeSetPersister.NotFoundException {
        return billLineRepository.findById(billLineNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<BillLine> getByBillNumber(int billNumber) {
        return billLineRepository.findByBillNumber(billNumber);
    }

    public List<BillLine> getAllBillLines() {
        return billLineRepository.findAll();
    }

    public void deleteBillLineByBillLineNumber(Integer billLineNumber) {
        billLineRepository.deleteById(billLineNumber);
    }

    public BillLine updateBillLine(Integer billLineNumber) throws ChangeSetPersister.NotFoundException {
        BillLine billLine = billLineRepository.findById(billLineNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return billLineRepository.save(billLine);
    }
}
