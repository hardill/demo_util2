package com.demo.bean;

import com.demo.annotation.TransType;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-08-06 08:59
 **/
@Data
public class ValidParam {
    @NotNull
    @Size(min = 2,message = "name is null")
    private String name;
    @NotNull
    @Size(min = 1,message = "list is null")
    @Valid
    private List<Person> persons;
    @TransType(message = "参数不符合要求")
    private String type;

}
