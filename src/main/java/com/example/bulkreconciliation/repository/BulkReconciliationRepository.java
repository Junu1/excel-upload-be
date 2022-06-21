package com.example.bulkreconciliation.repository;

import com.example.bulkreconciliation.entity.BulkReconciliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulkReconciliationRepository extends JpaRepository<BulkReconciliation,Long> {
}
