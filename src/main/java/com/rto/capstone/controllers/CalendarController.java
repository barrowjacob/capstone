package com.rto.capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {
     @GetMapping("/calendar")
     public String CalendarController(){
         return "views/calendar";
     }
}
