package com.exampleProcessorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exampleProcessorApplication.CsvProcessorService;
public class CsvProcessorController {
    @Autowired
    private CsvProcessorService csvProcessorService;

    // Endpoint que recibe la ruta del archivo CSV
    @PostMapping("/process")
    public ResponseEntity<String> processCsv(@RequestParam("filePath") String filePath) {
        String result = csvProcessorService.processCsv(filePath);
        return ResponseEntity.ok(result);
    }
}

