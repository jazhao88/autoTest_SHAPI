package cn.medichains.model;

import lombok.Data;

@Data
public class LoginCase {
    private Integer id;
    private String phone;
    private String password;
    private String expedted;
}
