package stslekiti.receipt.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import stslekiti.receipt.entity.LandLord;
import stslekiti.receipt.entity.Property;
import stslekiti.receipt.payload.request.AddLandOwnerRequest;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.payload.response.InvoiceResponse;
import stslekiti.receipt.repository.LandLordRepository;
import stslekiti.receipt.repository.PropertyRepository;
import stslekiti.receipt.service.PropertyService;
import stslekiti.receipt.util.InvoicePayloadBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    LandLordRepository landLordRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public GenericResponseDTO addLandOwner(AddLandOwnerRequest addLandOwnerRequest) throws Exception{
        // might want to account for the possibility that the landowner already exists.
//        LandLord landLord = new LandLord();

        System.out.println("This is the request: " + addLandOwnerRequest + "\n\n");

        LandLord landLord = LandLord.builder().firstName(addLandOwnerRequest.getFirstName())
                .lastName(addLandOwnerRequest.getLastName())
                .phone(addLandOwnerRequest.getPhone())
                .email(addLandOwnerRequest.getEmail())
                .address(addLandOwnerRequest.getAddress()).build();

//        BeanUtils.copyProperties(addLandOwnerRequest, landLord);

        System.out.println("This is the entity: " + landLord + "\n\n");

        landLordRepository.save(landLord);
        return new GenericResponseDTO("00", "Land owner created successfully");
    }

    @Override
    public GenericResponseDTO addPropertyForLandOwner(AddPropertyRequest addPropertyRequest) throws Exception {
        Property property = new Property();
        BeanUtils.copyProperties(addPropertyRequest, property);
        LandLord landLord = landLordRepository.getReferenceById(addPropertyRequest.getLandLord_id());

//        property.setLandLord(landLord);
        landLord.getProperties().add(property);

        propertyRepository.save(property);
        landLordRepository.save(landLord);
        return new GenericResponseDTO("00", "Property added successfully");
    }

    @Override
    public List<InvoiceResponse> handleFetchPropertyInvoicesForLandOwner(String name) throws Exception {
        List<LandLord> invoices = landLordRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);

//        List<InvoiceResponse> responses = new ArrayList<>();
//        invoices.forEach(invoice -> {
//            InvoiceResponse invoiceResponse = new InvoiceResponse();
//            BeanUtils.copyProperties(invoice, invoiceResponse);
//            BeanUtils.copyProperties(invoice.getProperties(), invoiceResponse);
//            responses.add(invoiceResponse);
//        });

        return InvoicePayloadBuilder.multipleLandOwnersInvoiceBuilder(invoices);
    }

    @Override
    public List<InvoiceResponse> handleFetchAllInvoices() throws Exception {
        List<LandLord> invoices = landLordRepository.findAll();

        System.out.println("This is the invoices: " + invoices + "\n\n");

//        List<InvoiceResponse> responses = new ArrayList<>();
//        invoices.forEach(invoice -> {
//            InvoiceResponse invoiceResponse = new InvoiceResponse();
//            BeanUtils.copyProperties(invoice, invoiceResponse);
//            BeanUtils.copyProperties(invoice.getProperties(), invoiceResponse);
//            responses.add(invoiceResponse);
//        });

        List<InvoiceResponse> responses = InvoicePayloadBuilder.multipleLandOwnersInvoiceBuilder(invoices);

        System.out.println(responses);

        return responses;
    }

    @Override
    public InvoiceResponse handleFetchInvoice(Long id) throws Exception {
        LandLord invoice = landLordRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        InvoiceResponse invoiceResponse = new InvoiceResponse();

        BeanUtils.copyProperties(invoice, invoiceResponse);
        BeanUtils.copyProperties(invoice.getProperties(), invoiceResponse);

        return invoiceResponse;
    }
}
