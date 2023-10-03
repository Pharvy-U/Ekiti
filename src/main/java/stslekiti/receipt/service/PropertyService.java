package stslekiti.receipt.service;

import stslekiti.receipt.payload.request.AddLandOwnerRequest;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.payload.response.InvoiceResponse;

import java.util.List;

public interface PropertyService {

    GenericResponseDTO addLandOwner(AddLandOwnerRequest addLandOwnerRequest) throws Exception;

    GenericResponseDTO addPropertyForLandOwner(AddPropertyRequest addPropertyRequest) throws Exception;

    List<InvoiceResponse> handleFetchPropertyInvoicesForLandOwner(String name) throws Exception;

    List<InvoiceResponse> handleFetchAllInvoices() throws Exception;

    InvoiceResponse handleFetchInvoice(Long id) throws Exception;
}
