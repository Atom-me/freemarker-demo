package com.atom.freemarker;

import com.atom.freemarker.utils.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * test generate HTML from string in memory.
 *
 * @author Atom
 */
public class GeneratorHtmlByStringTest {

    public static void main(String[] args) throws IOException, TemplateException {

        //定义模版，模版内容（字符串）直接将内存中的String对象放入并使用
        String templateContent = "" +
                "<html>\n" +
                "    <head></head>\n" +
                "    <body>\n" +
                "        名称：${name}\n" +
                "    </body>\n" +
                "</html>";

        String templateName = "template001";
        Map<String, Object> params = getMap();

        String s = FreemarkerUtil.processTemplateContentToString(templateName, templateContent, params);
        System.err.println(s);

        InputStream inputStream = IOUtils.toInputStream(s, "utf-8");
        FileOutputStream outputStream = new FileOutputStream("/Users/atom/temp/a.html");

        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private static Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "atom001!");
        return map;
    }

}
