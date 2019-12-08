package ru.its67.fcrm.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.repos.PdfRepo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfService {

        @Autowired
        private PdfRepo pdfRepo;


        public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
            String path = "/Users//maksim/Desktop/";
            List<Message> employees = pdfRepo.findAll();
            //load file and compile it
            File file = ResourceUtils.getFile("classpath:pdf/aktpriema.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Java Techie");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (reportFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "employees.html");
            }
            if (reportFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "employees.pdf");
            }

            return "report generated in path : " + path;
        }

}
