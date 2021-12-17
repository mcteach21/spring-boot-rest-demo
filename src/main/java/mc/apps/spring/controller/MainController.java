package mc.apps.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    private String DEFAUlT_VIEW="index";

    @GetMapping("/{page}")
    public String display(@PathVariable() String page ){
        return "".equals(page)?DEFAUlT_VIEW:page;
    }

//    @GetMapping("/" )
//    public String index(){
//        return "index";
//    }
//    @GetMapping("/about" )
//    public String about(){
//        return "about";
//    }
}
