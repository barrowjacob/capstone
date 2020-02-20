package com.rto.capstone.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rto.capstone.models.Booking;
import com.rto.capstone.models.User;
import com.rto.capstone.repositories.BookingRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CalendarController {

    private BookingRepository bookingDao;

    public CalendarController(BookingRepository bookingDao) {
        this.bookingDao = bookingDao;
    }


    //show calendar
    @GetMapping("/calendar")
    public String showCalendar(){
        return "views/calendar_test";
    }

    //view all bookings from db in json format
    @GetMapping(value = "/bookings.json")
    public
    @ResponseBody
    Iterable<Booking> getAllBookingsInJSONFormat() {
        return bookingDao.findAll();
    }



    //post info from form to db for booking
//    @PostMapping(path = "/booking/create")


//    @GetMapping("/getBookings.json")
//    @CrossOrigin
//    @ResponseBody
//    public String getBookings(){
//        String bookings = "";
//        Path jsonPath = Paths.get("/bookings.json");
//        try {
//            List<String> jsonContent = Files.readAllLines(jsonPath);
//            for(String line : jsonContent){
//                bookings += line;
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return bookings;
//    }



    //post to db
//    @GetMapping("/booking/create")
//    public String createForm(Model m){
//        m.addAttribute("booking", new Booking());
//        return "test";
//    }




//    @PostMapping("/calendar/json")
//    @ResponseBody
//    public String PostCalendarController() throws ParseException {
//
//        Booking booking = new Booking();
//
//        String sDate = "2020-03-21";
//        String eDate = "2020-03-23";
//
//        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
//
//        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);
//
//        booking.setDateStart(startDate);
//        booking.setDateEnd(endDate);
//        booking.setAddress("900 Navarro, San Antonio, TX 78243");
//
//
//        bookingDao.save(booking);
//
//
//        return "test";
//    }






//    //currently returns an empty arr lol
//    @GetMapping("/getBookingDates.json")
//    @ResponseBody
//    public List<Map<String, String>> getBookingDates()
//    {
//        List<Map<String, String>> events = new ArrayList<>();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        Iterable<Booking> bookings = bookingDao.findAll();
//
//
//        for(Booking booking : bookings)
//        {
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("title", booking.getAddress());
//            map.put("start", simpleDateFormat.format(booking.getDateStart()));
//            map.put("end", simpleDateFormat.format(booking.getDateEnd()));
//        }
//
//        return events;
//
//    }















}
