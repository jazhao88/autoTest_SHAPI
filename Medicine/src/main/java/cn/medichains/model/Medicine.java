package cn.medichains.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Medicine {
    private String medicineId;
    private String medicineCode;//药品编码
    private String medicineName;//药品名称
    private String trade_name;//商品名
    private String common_name;//通用名
    private String medicineAlias;//药品别名
    private String medicineType;//药品分类
    private String dosageForm;//剂型
    private String dgmId;//药品大分类
    private String dgeId;//药品子分类
    private String dgfId;//药品小分类
    private BigDecimal doseNumber;//剂量数
    private String doseUnit;//剂量单位
    private Integer preparationNumber;//制剂数
    private String preparationUnit;//制剂单位
    private String packagingUnit;//包装单位
    private String packagingDetail;//包装规格
    private String manufacturer;//生产厂家
    private Integer basic;//是否国家基本药物(0:不是,1:是)
    private Integer antibiotic;//是否抗生素(0:不是,1:是)
    private String antibioticType;//抗菌药物分类
    private String standardCode;//本位码
    private String approvalNumber;//批准文号
    private BigDecimal costPrice;//成本价
    private BigDecimal retailPrice;//处方价
    private BigDecimal resalePrice;//零售价
    private Integer scattered;//处方是否拆零(0:不拆零,1:拆零)
    private BigDecimal scatterPrice;//处方拆零价
    private Integer minInventories;//最小单位最低库存量
    private BigDecimal singleDose;//单次用量
    private String singleDoseUnit;//单次用量单位code
    private Integer defaultDay;//默认使用天数
    private String medicineUsage;//药品用法
    private String medicineFrequency;//用药频率
    private String invoiceProject;//发票项目
    private Integer deleteFlag;//删除标识(0:未删除,1:已删除)/
    private String chainId;//集团id
}
