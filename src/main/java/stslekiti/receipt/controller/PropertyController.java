package stslekiti.receipt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stslekiti.receipt.payload.request.AddLandOwnerRequest;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.payload.response.InvoiceResponse;
import stslekiti.receipt.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("add-land-owner")
    public ResponseEntity<GenericResponseDTO> addLandOwner(@RequestBody AddLandOwnerRequest addLandOwnerRequest) throws Exception {
        GenericResponseDTO responseDTO = propertyService.addLandOwner(addLandOwnerRequest);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("add-property")
    public ResponseEntity<GenericResponseDTO> addProperty(@RequestBody AddPropertyRequest addPropertyRequest) throws Exception {
        GenericResponseDTO responseDTO = propertyService.addPropertyForLandOwner(addPropertyRequest);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("invoice/fetch/all")
    public ResponseEntity<List<InvoiceResponse>> fetchAllInvoices() throws Exception {
        List<InvoiceResponse> response = propertyService.handleFetchAllInvoices();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("invoice/search/{name}")
    public ResponseEntity<List<InvoiceResponse>> fetchPropertyInvoicesForLandOwner(@PathVariable String name) throws Exception {
        List<InvoiceResponse> response = propertyService.handleFetchPropertyInvoicesForLandOwner(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("invoice/fetch/{id}")
    public ResponseEntity<InvoiceResponse> generatePropertyInvoice(@PathVariable Long id) throws Exception {
        InvoiceResponse response = propertyService.handleFetchInvoice(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
