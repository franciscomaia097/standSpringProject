package com.example.stand.Controllers;

import com.example.stand.Models.Model;
import com.example.stand.Services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/create")
    public Model createModel(@RequestBody Model model) {
        return modelService.createModel(model);
    }

    @GetMapping("/{id}")
    public Model getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @GetMapping("/all")
    public Iterable<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @PutMapping("/update/{id}")
    public Model updateModel(@PathVariable Long id, @RequestBody Model model) {
        model.setId(id);
        return modelService.updateModel(model);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }
}