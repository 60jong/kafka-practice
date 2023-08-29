package site._60jong.kafkaselectcolor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/select/color")
@Controller
public class SelectColorController {

    @GetMapping("")
    public String viewSelectColor() {
        return "select-color.html";
    }
}
