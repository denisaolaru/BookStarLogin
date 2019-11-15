package com.bookStar.project.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

//
//}
//@Controller
//@RequestMapping("/contact")
//public class ContactController {
//
//    private static Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
//
//    @Autowired
//    private ContactService contactService;
//
//
//
//    @RequestMapping("")
//    public ModelAndView listAll() {
//        ModelAndView result = new ModelAndView("contact/list");
//
//        Collection<Contact> contact = contactService.listAll();
//
//        result.addObject("contact messages", contact);
//
//        return result;
//    }
//
//
//
//    @RequestMapping("/add")
//    public ModelAndView add() {
//        ModelAndView modelAndView = new ModelAndView("contact/add");
//        modelAndView.addObject("contact", new Contact ());
//        return modelAndView;
//    }
//
//
//
//    @RequestMapping("/delete")
//    public String delete(long id) {
//        contactService.delete(id);
//        return "redirect:/contact";
//    }
//
//    @RequestMapping("/save")
//    public ModelAndView save(@Valid Contact contact,
//                             BindingResult bindingResult) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        if (!bindingResult.hasErrors()) {
//            try {
//                contactService.save(contact);
//                RedirectView redirectView = new RedirectView("/contact");
//                modelAndView.setView(redirectView);
//            } catch (ValidationException ex) {
//
//                LOGGER.error("validation error", ex);
//
//                List<String> errors = new LinkedList<> ();
//                errors.add(ex.getMessage());
//                modelAndView = new ModelAndView("contact/add");
//                modelAndView.addObject("errors", errors);
//                modelAndView.addObject("contact", contact);
//            }
//
//        } else {
//            List<String> errors = new LinkedList<>();
//
//            for ( FieldError error :
//                    bindingResult.getFieldErrors()) {
//                errors.add(error.getField() + ":" + error.getCode());
//            }
//
//            modelAndView = new ModelAndView("contact/add");
//            modelAndView.addObject("errors", errors);
//            modelAndView.addObject("contact", contact);
//        }
//
//        return modelAndView;
//    }
//
//
//}

import com.bookStar.project.bookstar.domain.Contact;
import com.bookStar.project.bookstar.service.ContactService;
import com.bookStar.project.bookstar.service.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

//@Controller
//public class ContactController {
//    @RequestMapping("/contact")
//    public ModelAndView contact() {
//        ModelAndView modelAndView = new ModelAndView("contact/contact");
//        return modelAndView;
//    }
@Controller
@RequestMapping("/contact")
public class ContactController {

    private static Logger LOGGER = LoggerFactory.getLogger("ContactController");


    @Autowired
    private ContactService contactService;


    @RequestMapping("")
    public ModelAndView listAll() {
        ModelAndView modelAndView = new ModelAndView("/contact");
        return modelAndView;
    }




    @RequestMapping("/save")
    public ModelAndView save(@Valid Contact contact,
                             BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()) {
            try {
                contactService.save(contact);
                RedirectView redirectView = new RedirectView("/contact/add");
                modelAndView.setView(redirectView);
            } catch (ValidationException ex) {

                LOGGER.error("validation error", ex);

                List<String> errors = new LinkedList<>();
                errors.add(ex.getMessage());
                modelAndView = new ModelAndView("contact/add");
                modelAndView.addObject("errors", errors);
                modelAndView.addObject("contact", contact);
            }

        } else {
            List<String> errors = new LinkedList<>();

            for (FieldError error :
                    bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ":" + error.getCode());
            }

            modelAndView = new ModelAndView("contact/add");
            modelAndView.addObject("errors", errors);
            modelAndView.addObject("contact", contact);
        }

        return modelAndView;
    }
    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("contact/add");
        modelAndView.addObject("contact", new Contact ());
        return modelAndView;
    }

//    @RequestMapping("/search/{title}")
//    public ModelAndView search(@RequestParam(value="title", required = false) String title){
//        ModelAndView modelAndView = new ModelAndView("books/search");
//        Collection<Books> books = booksService.search(title);
//        modelAndView.addObject("books", books);
//        return modelAndView;
//    }
}
