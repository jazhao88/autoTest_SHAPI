package cn.medichains.model;

import lombok.Data;

@Data
public class Medicine {
    private String medicine_id;
    private String medicine_code;
    private String medicine_name;
    private String trade_name;
    private String common_name;
    private String medicine_alias;
    private String medicine_type;
    private String dosage_form;
    private String dgm_id;
    private String dge_id;
    private String dgf_id;
    private Double dose_number;
    private String dose_unit;
    private Integer preparation_number;
    private String preparation_unit;
    private String packaging_unit;
    private String packaging_detail;
    private String manufacturer;
    private Integer basic;
    private Integer antibiotic;
    private String antibiotic_type;
    private String standard_code;
    private String approval_number;
    private Double cost_price;
    private Double retail_price;
    private Double resale_price;
    private Integer scattered;
    private Double scatter_price;
    private Double single_dose;
    private String single_dose_unit;
    private String medicine_usage;
    private String medicine_frequency;
    private Integer min_inventories;
    private Integer default_day;
    private String invoice_project;
    private Integer delete_flag;
    private String chain_id;
}
