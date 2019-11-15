package com.bookStar.project.mvc;


import com.bookStar.project.bookstar.domain.Books;
import com.bookStar.project.bookstar.service.BooksService;
import com.bookStar.project.bookstar.service.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private static Logger LOGGER = LoggerFactory.getLogger("BooksController");


    @Autowired
    private BooksService booksService;

    @RequestMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView("books/genre/all");
        Collection<Books> books = booksService.listAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping("/adventure")
    public ModelAndView adventure(){
        ModelAndView modelAndView = new ModelAndView("books/genre/adventure");
        Collection<Books> books = booksService.listAdventure();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/drama")
    public ModelAndView drama(){
        ModelAndView modelAndView = new ModelAndView("books/genre/drama");
        Collection<Books> books = booksService.listDrama();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping("/fantasy")
    public ModelAndView fantasy(){
        ModelAndView modelAndView = new ModelAndView("books/genre/fantasy");
        Collection<Books> books = booksService.listFantasy();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/horror")
    public ModelAndView horror(){
        ModelAndView modelAndView = new ModelAndView("books/genre/horror");
        Collection<Books> books = booksService.listHorror();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/mystery")
    public ModelAndView mystery(){
        ModelAndView modelAndView = new ModelAndView("books/genre/mystery");
        Collection<Books> books = booksService.listMystery();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/poetry")
    public ModelAndView poetry(){
        ModelAndView modelAndView = new ModelAndView("books/genre/poetry");
        Collection<Books> books = booksService.listPoetry();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/romance")
    public ModelAndView romance(){
        ModelAndView modelAndView = new ModelAndView("books/genre/romance");
        Collection<Books> books = booksService.listRomance();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    @RequestMapping("/SF")
    public ModelAndView scienceFiction(){
        ModelAndView modelAndView = new ModelAndView("books/genre/SF");
        Collection<Books> books = booksService.listSF();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    /*@RequestMapping("/product-details/{id}")
    public ModelAndView productDetails(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("books/single_product/Hamlet");
        Books book = booksService.get(id);
        modelAndView.addObject("books", book);
        return modelAndView;
    }*/

    @RequestMapping("/single/{id}")
    public ModelAndView single() {
        ModelAndView modelAndView = new ModelAndView("books/single_product/Hamlet");
        Collection<Books> books = booksService.listAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }


    @RequestMapping("/table")
    public ModelAndView table() {
        ModelAndView result = new ModelAndView("books/table");
        Collection<Books> books = booksService.listAll();
        result.addObject("books", books);

        return result;
    }


    @RequestMapping("/contact")
    public ModelAndView contact() {
        ModelAndView modelAndView = new ModelAndView("books/contact");
       /* modelAndView.addObject("books", new books());*/
        return modelAndView;
    }
    @RequestMapping("/product")
    public ModelAndView product() {
        ModelAndView modelAndView = new ModelAndView("books/product");
        Collection<Books> books = booksService.listAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }



    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("books/add");
        modelAndView.addObject("books", new Books());
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(long id) {
        Books books = booksService.get(id);
        ModelAndView modelAndView = new ModelAndView("books/add");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(long id) {
        booksService.delete(id);
        return "redirect:/books/table";
    }

    @RequestMapping("/save")
    public ModelAndView save(@Valid Books books,
                             BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()) {
            try {
                booksService.save(books);
                RedirectView redirectView = new RedirectView("/books/table");
                modelAndView.setView(redirectView);
            } catch (ValidationException ex) {

                LOGGER.error("validation error", ex);

                List<String> errors = new LinkedList<>();
                errors.add(ex.getMessage());
                modelAndView = new ModelAndView("books/add");
                modelAndView.addObject("errors", errors);
                modelAndView.addObject("books", books);
            }

        } else {
            List<String> errors = new LinkedList<>();

            for (FieldError error :
                    bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ":" + error.getCode());
            }

            modelAndView = new ModelAndView("books/add");
            modelAndView.addObject("errors", errors);
            modelAndView.addObject("books", books);
        }

        return modelAndView;
    }

    @RequestMapping("/search/{title}")
    public ModelAndView search(@RequestParam(value="title", required = false) String title){
        ModelAndView modelAndView = new ModelAndView("books/search");
        Collection<Books> books = booksService.search(title);
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
