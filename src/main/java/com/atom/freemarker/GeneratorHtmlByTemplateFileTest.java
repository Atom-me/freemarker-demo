package com.atom.freemarker;

import com.atom.freemarker.model.Student;
import com.atom.freemarker.utils.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * test generate HTML from ftl.
 *
 * @author Atom
 */
public class GeneratorHtmlByTemplateFileTest {

    public static void main(String[] args) throws IOException, TemplateException {
        Map<String, Object> params = getMap();
        String s = FreemarkerUtil.processString("test1.ftl", params);
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

        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());

        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);
        stu2.setBirthday(new Date());

        //创建一个朋友列表
        List<Student> friends = new ArrayList<>();
        friends.add(stu1);

        //给第二个学生设置朋友列表
        stu2.setFriends(friends);
        stu2.setBestFriend(stu1);

        List<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        //向数据模型放数据
        map.put("studentList", stuList);


        //准备map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        //向数据模型放数据
        //map.put("stu1",stu1);
        //向数据模型放数据
        map.put("stuMap", stuMap);
        map.put("point", 102920122);
        return map;
    }
}
