package com.atom.freemarker.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Atom
 **/
@Data
public class Student {
    private String name;
    private int age;
    private Date birthday;
    private Float money;
    private List<Student> friends;
    private Student bestFriend;
}
