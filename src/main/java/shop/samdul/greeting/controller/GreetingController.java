package shop.samdul.greeting.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.samdul.model.People;


@Controller
public class GreetingController {
    private Stack<People> names = new Stack<>();

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "HI") String name,
            // @RequestParam(name = "num", required = false, defaultValue = "0") int num,
            Model model) {

        People p = new People();
        p.name = name;
        p.num = names.size() + 1;
        names.add(p);
        model.addAttribute("names", names);
        return "greeting";
    }
}
