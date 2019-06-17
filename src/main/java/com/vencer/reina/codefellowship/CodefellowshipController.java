package com.vencer.reina.codefellowship;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CodefellowshipController {

    @GetMapping("/codefellowship")
    public String getCodefellowship(){
        return "codefellowship";
    }

}
