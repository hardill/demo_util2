package com.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class DemoUtilApplicationTests {

  public static void main(String[] args) throws Exception {
	  //
	  int length = "中a国".length();
	  Class.forName("com.mysql.cj.jdbc.Driver") ;
	  String url = "jdbc:mysql://rm-bp167v39m44a2ygxqo.mysql.rds.aliyuncs.com/sharan_erp?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	  String username = "pppcar" ;
	  String password = "3pcardbmms12#" ;
	  Connection con = DriverManager.getConnection(url , username , password );
	  Statement stmt = con.createStatement();
	  String sql="SELECT a.order_no orderNo,a.customer_company_name customerCompanyName,a.shipping_ref_no " +
			  "shippingRefNo,a.id id,a.contact_person contactPhone,a.contact_person contactPerson,a.order_date " +
			  "orderDate,a.receive_address receiveAddress,t.name as carrierName,u.user_name as checkUserName," +
			  " case a.reason_type when 'DO_SO' then '销售出库' when 'DO_MD' then '撮合出库' when 'DO_RT' then '反品入库' " +
			  "when 'DO_OTHER' then '其他出库' else '' End as reasonTypeName ,case a.shipping_type when '0' then '自提' " +
			  "when '1' then '发物流' when '2' then '送货上门' else '' end as shippingTypeName,a2.order_no origOrderNo," +
			  "a2.salesman_name salesmanName,a2.remark salesRemark,u2.user_name createUserName,a2.order_date soDate " +
			  "FROM t_order_head a LEFT OUTER JOIN t_order_line b on a.id = b.order_head_id " +
			  "LEFT OUTER JOIN t_sku_master c on b.sku_id = c.id " +
			  "LEFT OUTER JOIN t_type t on a.carrier_id = t.id LEFT OUTER JOIN t_user u on a.check_user_Id = u.id " +
			  "LEFT OUTER JOIN t_user u2 on a.create_user_Id = u2.id LEFT OUTER JOIN t_order_head a2 on a2.id = a.ref_order_id " +
			  "WHERE (a.tenant_id=1 AND a.order_type = 'DO' and a.status > 0 and a.reason_type != 'DO_OTHER' )" +
			  " GROUP BY a.id ORDER BY a.create_time desc LIMIT 10 ";
	  long l = System.currentTimeMillis();
	  ResultSet rs = stmt.executeQuery(sql) ;
	  System.out.println(System.currentTimeMillis()-l);
	  System.out.println(rs.getRow());
  }

	@Test
	public void contextLoads() {
		log.info("hello boot");
	}

}
