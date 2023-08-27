package stslekiti.receipt.service.impl;

import org.springframework.stereotype.Service;
import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.GenericResponseDTO;
import stslekiti.receipt.repository.ReceiptRepository;
import stslekiti.receipt.service.ReceiptService;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public GenericResponseDTO handleFetchAllInvoicesRequest() {
        List<Receipt> invoices = receiptRepository.findAll();
        return new GenericResponseDTO("00", "Invoices fetched successfully", invoices);
    }

    @Override
    public Receipt handleFetchInvoiceRequest(Long id) {
        return receiptRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Invoice with id {" + id + "} not found"));
    }

    @Override
    public GenericResponseDTO handlePopulateDB() {
        return null;
    }
}
