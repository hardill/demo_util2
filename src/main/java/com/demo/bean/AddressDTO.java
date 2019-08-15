package com.demo.bean;

import lombok.Data;

@Data
public class AddressDTO {
    // 省
    private String province;
    // 市
    private String city;
    // 区
    private String district;
    // 详细
    private String detailAddr;
}