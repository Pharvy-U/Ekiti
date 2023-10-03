package stslekiti.receipt.service;

import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;


public interface ReceiptService {
    public GenericResponseDTO handleFetchAllInvoicesRequest();

    public Receipt handleFetchInvoiceRequest(Long id);

//    public GenericResponseDTO handleAddProperty(AddPropertyRequest addPropertyRequest);
}
