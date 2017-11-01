package com.getjavajob.controller;

import com.getjavajob.entity.person.User;
import com.getjavajob.service.IService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@EnableWebMvc
@RequestMapping(value = "/")
public class Controller {

    private IService<User> service;

    public Controller() {
    }

    @Inject
    public Controller(IService<User> service) {
        this.service = service;
    }

    @RequestMapping(value = "/add")
    public ModelAndView toAddUser() {
        return new ModelAndView("/addUserForm");
    }

    @RequestMapping(value = "/saveChanges")
    public String saveChanges(@ModelAttribute("User") User changedUser) {
        System.out.println("changedUser = " + changedUser);
        this.service.update(changedUser);
        return "redirect:/show";
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(@RequestParam("userId") Long id) {
        User userById = this.service.getById(id);
        ModelAndView modelAndView = new ModelAndView("updateUser");
        modelAndView.addObject("userForUpdate", userById);
        return modelAndView;
    }


    @RequestMapping(value = "/addUserController")
    public String addNewUser(@ModelAttribute("User") User newUser) {
        this.service.insert(newUser);
        return "redirect:/add";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView showAllExistsUsers() {
        List<User> list = this.service.fetchAll();
        for (User user : list) {
            System.out.println("user = " + user);
        }
        ModelAndView modelAndView = new ModelAndView("showAll");
        modelAndView.addObject("listOfUsers", list);
        return modelAndView;
    }
}
