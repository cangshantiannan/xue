package com.wyl.xue.admin.system.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserAddInfo {
    private String name;
    private String avatar;
    private String introduction;
    private String email;
    private String phoneNumber;
    private Long userId;
}
