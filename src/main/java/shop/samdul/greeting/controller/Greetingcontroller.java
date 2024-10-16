package shop.samdul.greeting.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Greetingcontroller {
    Stack<People> PeopleStack = new Stack<>();

    @GetMapping("/greeting")
    public String greeting(

        @RequestParam(name = "name", required = false, defaultValue = "HI") String name,
        @RequestParam(name = "num", required = false, defaultValue = "0") Integer num, Model model) {
            
            People p = new People();
            p.name = name;
            p.num = num;
            PeopleStack.add(p);
            model.addAttribute("PeopleStack", PeopleStack);

            return "greeting";
        }
}
