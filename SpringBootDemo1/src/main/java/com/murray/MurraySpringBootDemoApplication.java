package com.murray;

import com.murray.com.murray.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@SpringBootApplication
public class MurraySpringBootDemoApplication {

    private static Logger log = LoggerFactory.getLogger(MurraySpringBootDemoApplication.class);

    //    //读取配置文件 自定义属性 方式一
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;


    @RequestMapping("/")
    public String index(Model model) {
        log.info("\n----------------------" + bookAuthor + bookName);

        Person single = new Person("aa", 11);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }

    public static void main(String[] args) {

        SpringApplication.run(MurraySpringBootDemoApplication.class, args);
    }
}
