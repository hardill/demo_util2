package com;

import com.demo.bean.Address;
import com.demo.bean.AddressDTO;
import com.demo.bean.Student;
import com.demo.bean.StudentDTO;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

    @Bean("myDozerMapper")
    public Mapper dozerMapper(){
        Mapper mapper = DozerBeanMapperBuilder.create()
                //指定 dozer mapping 的配置文件(放到 resources 类路径下即可)，可添加多个 xml 文件，用逗号隔开
                //.withMappingFiles("dozerBeanMapping.xml")
                .withMappingBuilder(beanMappingBuilder())           
                .build();
        return mapper;
    }

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                // 个性化配置添加在此
                mapping(Student.class, StudentDTO.class, TypeMappingOptions.wildcard(true),
                        TypeMappingOptions.dateFormat("yyyy-MM-dd"))
                        .exclude("mobile")
                        //.fields("address", "addr");
                 .fields("courses[0].teacherName", "counsellor");
                mapping(Address.class, AddressDTO.class)
                        .fields("detail", "detailAddr");
            }    
        };
    }
}