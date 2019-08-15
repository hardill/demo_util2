package com.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    // 省
    private String province;
    // 市
    private String city;
    // 区
    private String district;
    // 详细
    private String detail;
}