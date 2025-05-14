package org.example.l2s.service;

import jakarta.annotation.PostConstruct;
import org.example.l2s.model.Supplier;
import org.example.l2s.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    public Supplier getSupplierById(int id) {
        return supplierRepository.getById(id);
    }


}
