package com.atom.freemarker.controller;

import com.atom.freemarker.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Atom
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 返回course测试
     *
     * @param map
     * @return
     */
    @RequestMapping("/course")
    public String course(Map<String, Object> map) {
        //远程调用rest Template调用接口，获取页面数据模型数据
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31200/course/courseview/4028e581617f945f01617f9dabc40000", Map.class);
        Map body = forEntity.getBody();
        //putAll讲所有的key-value放入map中
        map.putAll(body);
        return "course";
    }

    /**
     * 返回banner测试
     *
     * @param map
     * @return
     */
    @RequestMapping("/banner")
    public String index_banner(Map<String, Object> map) {
        //远程调用rest Template调用接口,获取页面数据模型数据
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/5a791725dd573c3574ee333f", Map.class);
        Map model = forEntity.getBody();
        //putAll讲所有的key-value放入map中
        map.putAll(model);
        return "index_banner";
    }

    /**
     * freemarker 基本语法测试
     *
     * @param map
     * @return
     */
    @RequestMapping("/test1")
    public String test1(Map<String, Object> map) {
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
        //返回模板名称
        return "test1";
    }

}
