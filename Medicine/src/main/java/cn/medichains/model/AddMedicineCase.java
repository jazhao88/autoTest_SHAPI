package cn.medichains.model;

import lombok.Data;

@Data
public class AddMedicineCase {
    private Integer id;
    private String medicineName;
    private String tradeName;
    private String commonName;
    private String medicineAlias;
    private String medicineType;
    private String dosageForm;
    private String dgmId;
    private String dgeId;
    private String dgfId;
    private Double doseNumber;
    private String doseUnit;
    private Integer preparationNumber;
    private String preparationUnit;
    private String packagingUnit;
    private String packagingDetail;
    private String manufacturer;
    private Integer basic;
    private Integer antibiotic;
    private String antibioticType;
    private String standardCode;
    private String approvalNumber;
    private Double costPrice;
    private Double retailPrice;
    private Double resalePrice;
    private Integer scattered;
    private Double scatterPrice;
    private Double singleDose;
    private String singleDoseUnit;
    private String medicineUsage;
    private String medicineFrequency;
    private Integer minInventories;
    private Integer defaultDay;
    private String invoiceProject;
    private Integer deleteFlag;
    private String chainId;
    private String expected;

}
