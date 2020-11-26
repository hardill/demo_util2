package com.demo.dao;

import com.demo.bean.Tx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface TxDao extends JpaRepository<Tx, Serializable>,
        JpaSpecificationExecutor<Tx> {

}
