package com.demo.controller;/**
 * Created by Administrator on 2018/12/21.
 */

import com.demo.annotation.WebLog;
import com.demo.base.BaseController;
import com.demo.base.Result;
import com.demo.bean.Tx;
import com.demo.bean.ValidParam;
import com.demo.dao.TxDao;
import com.demo.forest.MyClient;
import com.demo.function.TestFunction;
import com.dtflys.forest.http.ForestResponse;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo_util
 * @description: 测试
 * @author: Mr.Huangmvn install -Dmaven.test.skip=true
 * @create: 2018-12-21 11:49
 **/
@Controller
@Slf4j
public class TestController extends BaseController {

    //@Autowired
    //private HelloSender helloSender;
    @Resource
    private MyClient myClient;
    @Autowired
    private TestFunction testFunction;
    @Autowired
    private TxDao txDao;

    public TestController() throws IOException {
    }

    @GetMapping("hi")
    @ResponseBody
    @WebLog
    public Result testHi() {
        return successResult(Result.MSG_SUCCESS, "hello");
    }

    @GetMapping("/mq/test")
    public Result testMq() {
        //helloSender.send();
        return successResult(Result.MSG_SUCCESS, null);
    }

    @GetMapping("hello2")
    @ResponseBody
    public Result testForest() {
        ForestResponse<Result> response = myClient.simpleRequest();
        Result result = response.getResult();
        return result;
    }

    @PostMapping("check")
    @ResponseBody
    public Result testCheck(@RequestBody @Validated ValidParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数异常:{}", bindingResult.getFieldError().getDefaultMessage());
            throw new RuntimeException("参数异常:" + bindingResult.getFieldError().getDefaultMessage());
        }

        return successResult(Result.MSG_SUCCESS, "check success");
    }

    @GetMapping("test/f")
    @ResponseBody
    public Result testFunction(String key) {
        return successResult(testFunction.getCheckResultComX(key));
    }

    @GetMapping("tx2")
    public void testTx2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        test6();
    }

    public void test6() throws Exception {
        int page = 0;
        List<Tx> list = new ArrayList<>();
        while (page < 20) {
            page++;
            Document doc = Jsoup.connect("http://bang.tx3.163.com/bang/ranks?school=&role_id=0_100875&order_key" +
                    "=equ_xiuwei&server=&count=20&page=" + page).get();
            Elements rows = doc.select("table").get(0).select("tr");

            if (rows.size() == 1) {
                break;
            } else {
                for (int i = 1; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    Elements elements = row.select("td");
                    Tx tx = new Tx().setId(Integer.valueOf(elements.get(0).text()))
                            .setName(elements.get(1).text())
                            .setLevel(elements.get(4).text())
                            .setMenpai(elements.get(5).text())
                            .setEquip(elements.get(8).text())
                            .setXiuwei(elements.get(7).text());
                    list.add(tx);
                }
            }
        }
        if (!list.isEmpty()) {
            txDao.saveAll(list);
        }

    }


}
