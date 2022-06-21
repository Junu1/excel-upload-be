package com.example.bulkreconciliation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BulkReconciliation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TRACE_ID", nullable = false)
    private Long traceId;

    @Column(name = "REQUEST_ID", length = 50, nullable = false)
    private String requestId;

    @Column(name = "TRANSACTION_DATE",nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private String date;

    @Column(name = "CLIENT", length = 50)
    private String client;

    @Column(name = "SERVICE",length = 50, nullable = false)
    private String service;

    @Column(name = "PAYMENT_ATTRIBUTE",length = 50, nullable = false)
    private String paymentAttribute;

    @Basic(optional = false)
    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private Double amount;

    @Column(name = "VENDOR_TRANS_ID", nullable = true)
    private String vendorTransId;

    @Column(name = "STATUS", length = 50, nullable = false)
    private String status;

    @Column(name = "VENDOR_CODE", nullable = true)
    private String vendorCode;

    @Column(name = "VENDOR_TRACE_ID", nullable = true)
    private String vendorTraceId;

    @Column(name = "VENDOR_DESC", length = 50, nullable = true)
    private String vendorDesc;

    @Column(name = "REMARKS",length = 255,nullable = true)
    private String remarks;

    public void setId(Double valueOf) {
    }
}
