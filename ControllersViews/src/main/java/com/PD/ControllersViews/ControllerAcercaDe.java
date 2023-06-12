package com.PD.ControllersViews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerAcercaDe{

    @GetMapping("/AcercaDe")
    public ModelAndView arreglo() {
        ModelAndView mav = new ModelAndView("AcercaDe");
        return mav;
    }

}