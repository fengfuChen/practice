package com.javaCommApi;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Created by chenfengfu on 2018/1/28.
 */
public class XmlParse {


    @Test
    public void saxReader() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("./src/main/java/com/noteBook/xml.xml");
        Element root = document.getRootElement();
        System.out.println( root.getName());
        Element path = root.element("path");
        System.out.println(path.getData());

        Document doc = DocumentHelper.createDocument();
        root =  doc.addElement("empLsit");
        for(int i = 0; i< 10; i++){
            Element element = root.addElement("emp");
            element.addAttribute("id", i+"");
            element.addElement("name").addText("no"+i);
            element.addElement("age").addText(i+20+"");
            XMLWriter writer = new XMLWriter();
            FileOutputStream fos = new FileOutputStream("./src/test/java/com/lib/emp.xml");
            writer.setOutputStream(fos);
            writer.write(doc);
            writer.close();
        }
    }

    /*
    XPATH 语法
    / 根节点
    . 当前节点
    .. 当前节点父节点
    // 任意位置节点
    @  选择某个属性

    谓语条件, 路径表达式的附加条件， 写在[]中


     */

}
