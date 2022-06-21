package com.example.bulkreconciliation.service.impl;

import com.example.bulkreconciliation.entity.BulkReconciliation;
import com.example.bulkreconciliation.helper.BulkReconciliationHelper;
import com.example.bulkreconciliation.repository.BulkReconciliationRepository;
import com.example.bulkreconciliation.service.BulkReconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BulkReconciliationServiceImpl implements BulkReconciliationService {

    @Autowired
    private BulkReconciliationRepository bulkReconciliationRepository;

    @Override
    public void save(MultipartFile multipartFile) {
        try{
            List<BulkReconciliation> bulkReconciliations=BulkReconciliationHelper.convertExcelToListOfBulkReconciliation(multipartFile.getInputStream());
            this.bulkReconciliationRepository.saveAll(bulkReconciliations);

        } catch(IOException e){
            e.printStackTrace();

        }

    }

    @Override
    public List<BulkReconciliation> getAllBulkReconciliations() {
        return this.bulkReconciliationRepository.findAll();
    }
}
