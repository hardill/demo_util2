package com.demo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tx_people")
@Accessors(chain = true)
public class Tx {
    @Id
    private int id;
    private String name;
    private String level;
    private String menpai;
    private String xiuwei;
    private String equip;
}
