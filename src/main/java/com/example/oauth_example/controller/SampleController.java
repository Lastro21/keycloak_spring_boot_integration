package com.example.oauth_example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @RequestMapping(value = "/api/anonymous", method = RequestMethod.GET)
    public ModelAndView getAnonymousInfo() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anonymous");
        return modelAndView;
    }

    @RequestMapping(value = "/api/producer", method = RequestMethod.GET)
    @PreAuthorize("hasRole('PRODUCER')")
    public ModelAndView getAdminInfo() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("producer");
        return modelAndView;
    }

    @RequestMapping(value = "/api/consumer", method = RequestMethod.GET)
    @PreAuthorize("hasRole('CONSUMER')")
    public ModelAndView getUserInfo() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("consumer");
        return modelAndView;
    }

    @RequestMapping(value = "/api/both", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('PRODUCER', 'CONSUMER')")
    public ModelAndView getBoth() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("full");
        return modelAndView;
    }

    @RequestMapping(value = "/ui", method = RequestMethod.GET)
    public ModelAndView getUi() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("full");
        return modelAndView;
    }

}
