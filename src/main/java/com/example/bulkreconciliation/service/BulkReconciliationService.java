package com.example.bulkreconciliation.service;

import com.example.bulkreconciliation.entity.BulkReconciliation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface BulkReconciliationService {
    public void save(MultipartFile multipartFile);
    public List<BulkReconciliation> getAllBulkReconciliations();

}
