package com.demo.util; /**
 * Created by Administrator on 2018/11/7.
 */

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: mirai_parent
 * @description: excel工具类
 * @author: Mr.Huang
 * @create: 2018-11-07 16:56
 **/
@Slf4j
public class ExcelUtils {
    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

    /**
     * 创建excel
     *
     * @param dataMap
     * @param type
     * @return
     */
    public static File createExcel(Map<?, ?> dataMap, String type, String ftlName, String filePath) throws IOException {

        Configuration configuration = new Configuration();
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //ftl模板文件
        configuration.setClassForTemplateLoading(ExcelUtils.class, "/templates");
        //获取模板
        Template template = configuration.getTemplate(ftlName);
        String name = "temp" + (int) (Math.random() * 100000) + ".xls";
        File file = new File(name);
        //Template template = allTemplates.get(type);

        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return file;
    }

    /**
     * 导出数据到excel
     *
     * @param request
     * @param response
     * @param valueName 模板中参数名
     * @param data      数据
     * @param type      类型
     * @param ftlName   模板名,包括文件类名
     * @param filePath  模板路径
     */
    public static void exportExcel(HttpServletRequest request, HttpServletResponse response, String valueName, Object
            data, String type, String ftlName, String filePath,String fileName) {
        Map<String, Object> map = new HashMap<>();
        map.put(valueName, data);
        File file = null;
        InputStream inputStream = null;
        ServletOutputStream out = null;
        try {
            request.setCharacterEncoding("UTF-8");
            file = createExcel(map, type, ftlName, filePath);//调用创建excel帮助类
            inputStream = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msexcel");
            String name = fileName + (int) (Math.random() * 100) + ".xls";
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode(name,
                    "UTF-8"));
            out = response.getOutputStream();
            byte[] buffer = new byte[512]; // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Excel文件的内容输出到浏览器中
            while ((bytesToRead = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            out.flush();
        } catch (Exception e) {
            log.error("导出数据到excel异常");
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (file != null)
                file.delete(); // 删除临时文件
        }
    }
}
