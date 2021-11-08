package com.example.AvengersBack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.desktop.SystemEventListener;

@Controller
public class MainController {

    @GetMapping("")
    public String showOnBoardPage(){
        return "index";
    }

}
