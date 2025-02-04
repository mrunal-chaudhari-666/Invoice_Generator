package com.example.invoicegenerator.task.service;

import com.example.invoicegenerator.task.ResourceNotFoundException;
import com.example.invoicegenerator.task.entities.Invoice;
import com.example.invoicegenerator.task.entities.Item;
import com.example.invoicegenerator.task.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice createInvoice(Invoice invoice) {

            for (Item item : invoice.getItems()) {
                item.setInvoice(invoice);
            }

        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with ID: " + id));
    }
}

