package stslekiti.receipt.service;

import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.GenericResponseDTO;


public interface ReceiptService {
    public GenericResponseDTO handleFetchAllInvoicesRequest();

    public Receipt handleFetchInvoiceRequest(Long id);

    public GenericResponseDTO handlePopulateDB();
}
