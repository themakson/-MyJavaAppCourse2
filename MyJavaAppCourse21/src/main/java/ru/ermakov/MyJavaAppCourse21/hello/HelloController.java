package ru.ermakov.MyJavaAppCourse21.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "name", defaultValue = "") String s) {

        ArrayList<String> people = new ArrayList<String>();
        // добавим в список ряд элементов
        people.add(0,"Tom");
        people.add(1,"Alice");
        people.add(2,"Kate");
        people.add(3,"Sam");

        return String.format("Hello %s!", people);
    }

}
