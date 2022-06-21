package com.example.bulkreconciliation.helper;

import com.example.bulkreconciliation.entity.BulkReconciliation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BulkReconciliationHelper {
    public static boolean checkExcelFormat(MultipartFile multipartFile) {
        String contentType = multipartFile.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }
    public static List<BulkReconciliation> convertExcelToListOfBulkReconciliation(InputStream is) {
        List<BulkReconciliation> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Bulk Reconciliation");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 0;

                BulkReconciliation p = new BulkReconciliation();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0:
                            Long traceId = Long.valueOf(cell.getStringCellValue());
                            System.out.println("TraceId::: " + traceId);
                            p.setTraceId(traceId);
                            break;
                        case 1:
                            String requestId = cell.getStringCellValue();
                            p.setRequestId(cell.getStringCellValue());
                            System.out.println("RequestId::" + requestId);
                            break;
                        case 2:
                            String date = cell.getStringCellValue();
                            System.out.println("Date::" + date);
                            p.setDate(cell.getStringCellValue());
                            break;
                        case 3:
                            String client = cell.getStringCellValue();
                            p.setClient(cell.getStringCellValue());
                            System.out.println("Client::" + client);
                            break;
                        case 4:
                            String service = cell.getStringCellValue();
                            System.out.println("Service::" + service);
                            p.setService(cell.getStringCellValue());
                            break;
                        case 5:
                            String paymentAttribute = cell.getStringCellValue();
                            System.out.println("PaymentAttribute::" + paymentAttribute);
                            p.setPaymentAttribute(cell.getStringCellValue());
                            break;
                        case 6:
                            Double amount = Double.valueOf(cell.getStringCellValue());
                            System.out.println("Amount::" + amount);
                            p.setAmount(amount);
                            break;
                        case 7:
                            String vendorTransId = cell.getStringCellValue();
                            System.out.println("VendorTransId::" + vendorTransId);
                            p.setVendorTransId(cell.getStringCellValue());
                            break;
                        case 8:
                            String status = cell.getStringCellValue();
                            System.out.println("Status::" + status);
                            p.setStatus(cell.getStringCellValue());
                            break;
                        case 9:
                            String vendorCode = cell.getStringCellValue();
                            System.out.println("Vendor Code::" + vendorCode);
                            p.setVendorCode(cell.getStringCellValue());
                            break;
                        case 10:
                            String vendorTraceId = cell.getStringCellValue();
                            System.out.println("Vendor Trace Id::" + vendorTraceId);
                            p.setVendorTraceId(cell.getStringCellValue());
                            break;
                        case 11:
                            String vendorDesc = cell.getStringCellValue();
                            System.out.println("Vendor Desc::" + vendorDesc);
                            p.setVendorDesc(cell.getStringCellValue());
                            break;
                        case 12:
                            String remarks = cell.getStringCellValue();
                            System.out.println("Remarks::" + remarks);
                            p.setRemarks(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
}

