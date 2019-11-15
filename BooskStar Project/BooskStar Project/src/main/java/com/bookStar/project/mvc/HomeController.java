package com.bookStar.project.mvc;

import com.bookStar.project.bookstar.service.BooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/home")
public class HomeController {
    private static Logger LOGGER = LoggerFactory.getLogger("HomeController");




    @RequestMapping("/")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView("books/home");
        return modelAndView;
    }}


