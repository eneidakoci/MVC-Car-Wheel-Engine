package com.detyra.mvc.controller;

import com.detyra.mvc.CustomResponse;
import com.detyra.mvc.domain.dto.WheelsDTO;
import com.detyra.mvc.domain.dto.WheelsRequest;
import com.detyra.mvc.domain.entity.WheelsEntity;
import com.detyra.mvc.domain.mappers.WheelsMapper;
import com.detyra.mvc.filter.Filter;
import com.detyra.mvc.service.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wheels")
public class WheelsController {

    @Autowired
    private WheelsService wheelsService;

    @GetMapping("/{wheelId})")
    public ResponseEntity<WheelsDTO> findById(@PathVariable Integer wheelId) {
        return ResponseEntity.ok(wheelsService.findById(wheelId));
    }

    @PostMapping
    public Boolean save(@RequestBody WheelsRequest wheelsRequest) {
        wheelsService.save(wheelsRequest);
        return true;
    }

    /*working */
//    @GetMapping
//    public ResponseEntity<List<WheelsDTO>> getAllWheels(@RequestParam(required = false) String type, @RequestParam(required = false) String size) {
//        Filter typeFilter = new Filter("type", type, "=");
//        Filter sizeFilter = new Filter("size", size, "=");
//        return ResponseEntity.ok(wheelsService.findAll(typeFilter, sizeFilter));
//    }
    @GetMapping
    public ResponseEntity<CustomResponse<List<WheelsDTO>>> getAllWheels(@RequestParam(required = false) String type, @RequestParam(required = false) String size) {
        boolean fieldsExist = checkFieldsExist(WheelsEntity.class, "size", "type");

        if (!fieldsExist || (size == null && type == null)) {
            CustomResponse<List<WheelsDTO>> response = new CustomResponse<>("The fields that you entered do not exist in the class.", new ArrayList<>());
            return ResponseEntity.ok(response);
        }

        Filter typeFilter = new Filter("type", type, "=");
        Filter sizeFilter = new Filter("size", size, "=");

        List<WheelsDTO> wheels = wheelsService.findAll(typeFilter, sizeFilter);
        CustomResponse<List<WheelsDTO>> response = new CustomResponse<>("Data retrieved successfully.", wheels);
        return ResponseEntity.ok(response);
    }

    /**
     * for a more generic use, the actual WheelsEntity class wasnt used, but instead an instance of Class<?> , in order
     *     for it to be used on other classes too.
     */
    private boolean checkFieldsExist(Class<?> entityClass, String... fieldNames) {
        for (String fieldName : fieldNames) {
            try {
                entityClass.getDeclaredField(fieldName);//Use of Java reflections
            } catch (NoSuchFieldException e) {
                return false;
            }
        }
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<WheelsDTO> deleteWheel(@PathVariable Integer id) {
        return ResponseEntity.ok(wheelsService.delete(id));
    }

    /*
    Takes a WheelsRequest object and turns it into a WheelsEntity object which be later turned to a WheelsDTO object.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<WheelsDTO> updateWheel(@PathVariable Integer id, @RequestBody WheelsRequest wheelsRequest) {
        WheelsEntity wheelsEntity = WheelsMapper.toEntity(wheelsRequest);
        WheelsDTO wheelsDTO = WheelsMapper.toDto(wheelsEntity);
        wheelsDTO.setId(id);
        return wheelsService.update(wheelsDTO) != null ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

}
/*
 *********************************************MVC***********************************************************
 */
//    private static final String TEMPLATE_LOCATION = "plain-html/";
//
//    @GetMapping
//    public String getAllWheels(Model model) {
//        List<WheelsDTO> wheelsDTOS = wheelsService.findAll();
//        model.addAttribute("wheelsDTOS", wheelsDTOS);
//        return TEMPLATE_LOCATION.concat("wheels-view-plain");
//    }
//
//    @GetMapping("/form")
//    public String addOrUpdateWheel(Model model, @RequestParam(required = false) Integer wheelsId) {
//        if(wheelsId == null){
//            model.addAttribute("title", "Wheel Registration");
//            model.addAttribute("wheelsForm", new WheelsDTO());
//        } else {
//            model.addAttribute("title", "Wheel Update");
//            model.addAttribute("wheelsForm", wheelsService.findById(wheelsId));
//        }
//        return TEMPLATE_LOCATION.concat("wheels-view-form-plain");
//    }
//
//    @PostMapping("/form")
//    public String addOrUpdateWheel(@ModelAttribute(name = "wheelsForm") @Valid WheelsDTO wheelsDTO, BindingResult result) {
//        if(result.hasErrors()){
//            return TEMPLATE_LOCATION.concat("wheels-view-form-plain");
//        }
//        if (wheelsDTO.getId() == null) {
//            wheelsService.save(new WheelsRequest(wheelsDTO.getSize(), wheelsDTO.getType()));
//        } else {
//            wheelsService.update(wheelsDTO);
//        }
//        return "redirect:/wheels";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteWheel(@PathVariable Integer id) {
//        wheelsService.delete(id);
//        return "redirect:/wheels";
//    }
//}