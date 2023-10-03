package stslekiti.receipt.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stslekiti.receipt.entity.Property;
import stslekiti.receipt.entity.Receipt;
import stslekiti.receipt.payload.request.AddPropertyRequest;
import stslekiti.receipt.payload.response.GenericResponseDTO;
import stslekiti.receipt.repository.LandLordRepository;
import stslekiti.receipt.repository.PropertyRepository;
import stslekiti.receipt.repository.ReceiptRepository;
import stslekiti.receipt.repository.UserRepository;
import stslekiti.receipt.service.ReceiptService;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    ReceiptRepository receiptRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    @Autowired
    private LandLordRepository landLordRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository,
                              PropertyRepository propertyRepository,
                              UserRepository userRepository) {
        this.receiptRepository = receiptRepository;
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
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

//    @Override
//    public GenericResponseDTO handleAddProperty(AddPropertyRequest addPropertyRequest) {
//        Property property = new Property();
//        BeanUtils.copyProperties(addPropertyRequest, property);
//        property.setLandLord(landLordRepository.getReferenceById(addPropertyRequest.getLandLord_id()));
//        propertyRepository.save(property);
//        return new GenericResponseDTO("00", "Property added to user successfully");
//    }
}
