package com.example.intro_to_web;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void helloSpring(PrintWriter printWriter) {
        System.out.println("Hello Web");
        printWriter.println("Hello Web in Browser");
    }

    @RequestMapping({ "/", "/home" })
    public String home() {
        return "home";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("name", "JT");
        model.addAttribute("ph", "7008014038");
        return "contact";
    }

    // @RequestMapping(value= "/form", method = RequestMethod.GET)
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    // @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute Student student, Model model) {
        model.addAttribute("stud", student);
        return "details";
    }

    @GetMapping("/multi-submit")
    public String showStudents(Model model) {
        Student student1 = new Student("Asutosh", 101);
        Student student2 = new Student("Rakesh", 102);
        Student student3 = new Student("Kuldeep", 103);

        model.addAttribute("students", List.of(student1, student2, student3));
        return "details";
    }
}
