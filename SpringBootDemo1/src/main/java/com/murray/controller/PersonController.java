package com.murray.controller;        import com.murray.model.Person;        import org.springframework.web.bind.annotation.RequestMapping;        import org.springframework.web.bind.annotation.RequestMethod;        import org.springframework.web.bind.annotation.RestController;/** * Created by chujulong on 2017/2/14. * 返回JSON Demo */@RestController@RequestMapping("/person")public class PersonController {    @RequestMapping(value = "/",method = RequestMethod.POST)    public Person user() {        Person single = new Person("aa", 11);        return single;    }}