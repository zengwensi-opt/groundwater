package com.groundwater.support.modules.system.service.impl;




import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.deepoove.poi.XWPFTemplate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.groundwater.support.modules.common.domain.FebsResponse;
import com.groundwater.support.modules.common.exception.FebsException;
import com.groundwater.support.modules.system.domain.Test;
import com.itextpdf.text.pdf.*;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("basic")
public class WordServiceImpl {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\wensi\\Desktop\\其他类型环境监测井基本情况.xlsx");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(),file.getName(),"" ,inputStream);

        WordServiceImpl.importExcel(multipartFile);
    }

    public static void importWord()throws Exception{
        InputStream inputStream = new FileInputStream(new File("C:\\Users\\wensi\\Desktop\\11.docx"));
        XWPFDocument doc = new XWPFDocument(inputStream);
        Iterator<XWPFTable> it = doc.getTablesIterator();
        System.out.println("-------------------------------------------表格信息----------------------------------");
        if (it.hasNext()) {
            XWPFTable xwpfTable = it.next();
            // 读取每一行
            for (int i = 0; i < xwpfTable.getRows().size(); i++) {
                XWPFTableRow row = xwpfTable.getRow(i);
                if (row != null) {
                    //根据模板读取需要的数据单元格，从第二列开始读取
                    for (int j = 1; j < row.getTableCells().size(); j++) {
                        XWPFTableCell cell = row.getCell(j);
                        if (cell != null) {
                            String cellText = cell.getText();
                            System.out.println(cellText);
                        }
                    }
                }
            }

        }
        System.out.println("-------------------------------------------文本信息----------------------------------");
        List<XWPFParagraph> xwpfParagraphs = doc.getParagraphs();
        System.out.println(xwpfParagraphs.get(1).getText());
    }

    public static void exportWord() throws Exception{
        XWPFTemplate template = XWPFTemplate.compile("C:\\Users\\wensi\\Desktop\\11 - 副本.docx").render(new HashMap<String, Object>(){{
            put("code", "poi-tl Word模板引擎");
        }});
        FileOutputStream out = new FileOutputStream("C:\\Users\\wensi\\Desktop\\output.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();

    }

//    public static void exportPdf()throws Exception {
//        Map<String, String> o = new HashMap<String, String>() {{
//            put("name", "曾文斯");
//            put("project", "后台");
//        }};
//
//
//        // 模板路径
//        String templatePath = "C:\\Users\\wensi\\Desktop\\x.pdf";
//        // 生成的新文件路径
//        String newPDFPath = "C:\\Users\\wensi\\Desktop\\z.pdf";
//
//        PdfReader reader;
//        FileOutputStream out;
//        ByteArrayOutputStream bos;
//        PdfStamper stamper;
//        try {
//
//            out = new FileOutputStream(newPDFPath);// 输出流
//            reader = new PdfReader(templatePath);// 读取pdf模板
//            bos = new ByteArrayOutputStream();
//            stamper = new PdfStamper(reader, bos);
//            AcroFields form = stamper.getAcroFields();
//            //文字类的内容处理
//            for (String key : o.keySet()) {
//                String value = o.get(key);
//                form.setField(key, value);
//            }
//            stamper.setFormFlattening(false);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
//            stamper.close();
//            Document doc = new Document();
//            Font font = new Font(bf, 32);
//            PdfCopy copy = new PdfCopy(doc, out);
//            doc.open();
//            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
//            copy.addPage(importPage);
//            doc.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        } catch (DocumentException e) {
//            System.out.println(e);
//        }
//    }

    public static void importExcel(MultipartFile file) throws Exception{

        ExcelReader reader = ExcelUtil.getReader("D:\\项目资料\\地下水\\导入数据\\其他类型环境监测井基本情况（导入版).xlsx");

        List<List<Object>> all = reader.read(1,2);
        System.out.println();
    }

}
@Excel
class BasicTest {

    @ExcelField(value = "监测井留存情况", required = true, maxLength = 2)
    private String field1;

    @ExcelField(value = "经度", required = true)
    private String field2;

    @ExcelField(value = "纬度", required = true)
    private String field10;

    @ExcelField(value = "联系人姓名", required = true)
    private String field3;

//    @ExcelField(value = "建井时间", required = true)
//    private String field4;

    @ExcelField(value = "选项", required = true)
    private String field5;

    @ExcelField(value = "备注", required = true)
    private String field6;

    @ExcelField(value = "井管长度", required = true)
    private String field7;

    @ExcelField(value = "地表下xx米", required = true)
    private String field8;

    @ExcelField(value = "至xx米", required = true)
    private String field9;
//    @ExcelField(value = "填表日期", required = true)
//    private String createTime;

    @Override
    public String toString() {
        return "BasicTest{" +
                "监测井留存情况='" + field1 + '\'' +
                ", 经度='" + field2 + '\'' +
                ", 纬度='" + field10 + '\'' +
                ", 联系人姓名='" + field3 + '\'' +
//                ", 建井时间='" + field4 + '\'' +
                ", 选项='" + field5 + '\'' +
                ", 备注='" + field6 + '\'' +
                ", 井管长度='" + field7 + '\'' +
                ", 地表下xx米='" + field8 + '\'' +
                ", 至xx米='" + field9 + '\'' +
//                ", 填表日期=" + createTime +
                '}';
    }
}
