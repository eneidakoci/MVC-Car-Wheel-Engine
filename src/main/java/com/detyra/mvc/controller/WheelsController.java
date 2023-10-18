package com.detyra.mvc.controller;

import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.dto.WheelsRequest;
import com.detyra.mvc.service.WheelsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/wheels")
public class WheelsController {

    @Autowired
    private WheelsService wheelsService;
    private static final String TEMPLATE_LOCATION = "plain-html/";

    @GetMapping
    public String getAllWheels(Model model) {
        List<WheelsDTO> wheelsDTOS = wheelsService.findAll();
        model.addAttribute("wheelsDTOS", wheelsDTOS);
        return TEMPLATE_LOCATION.concat("wheels-view-plain");
    }

    @GetMapping("/form")
    public String addOrUpdateWheel(Model model, @RequestParam(required = false) Integer wheelsId) {
        if(wheelsId == null){
            model.addAttribute("title", "Wheel Registration");
            model.addAttribute("wheelsForm", new WheelsDTO());
        } else {
            model.addAttribute("title", "Wheel Update");
            model.addAttribute("wheelsForm", wheelsService.findById(wheelsId));
        }
        return TEMPLATE_LOCATION.concat("wheels-view-form-plain");
    }

    @PostMapping("/form")
    public String addOrUpdateWheel(@ModelAttribute(name = "wheelsForm") @Valid WheelsDTO wheelsDTO, BindingResult result) {
        if(result.hasErrors()){
            return TEMPLATE_LOCATION.concat("wheels-view-form-plain");
        }
        if (wheelsDTO.getId() == null) {
            wheelsService.save(new WheelsRequest(wheelsDTO.getSize(), wheelsDTO.getType()));
        } else {
            wheelsService.update(wheelsDTO);
        }
        return "redirect:/wheels";
    }

    @GetMapping("/delete/{id}")
    public String deleteWheel(@PathVariable Integer id) {
        wheelsService.delete(id);
        return "redirect:/wheels";
    }
}