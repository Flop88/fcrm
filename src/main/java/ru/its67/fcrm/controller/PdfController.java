package ru.its67.fcrm.controller;


import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.repos.PdfRepo;
import ru.its67.fcrm.service.PdfService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class PdfController {

    @Autowired
    private PdfRepo repository;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/getPdf")
    public List<Message> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return pdfService.exportReport(format);
    }
}
