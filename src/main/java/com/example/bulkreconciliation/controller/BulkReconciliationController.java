package com.example.bulkreconciliation.controller;

import com.example.bulkreconciliation.entity.BulkReconciliation;
import com.example.bulkreconciliation.helper.BulkReconciliationHelper;
import com.example.bulkreconciliation.service.BulkReconciliationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
public class BulkReconciliationController {
    @Autowired
    private BulkReconciliationService bulkReconciliationService;

    @PostMapping("/bulkreconciliation/upload")
    public ResponseEntity<?> upload(@RequestParam("multipartFile") MultipartFile multipartFile){
        if(BulkReconciliationHelper.checkExcelFormat(multipartFile)){
            this.bulkReconciliationService.save(multipartFile);
            return  ResponseEntity.ok("File uploaded and data saved");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
    }
    @GetMapping("/bulkreconciliation")
    public List<BulkReconciliation> getAllBulkReconciliation() {
        return this.bulkReconciliationService.getAllBulkReconciliations();
    }
}
