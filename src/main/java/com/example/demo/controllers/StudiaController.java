package com.example.demo.controllers;

import com.example.demo.models.Studia;
import com.example.demo.models.Zayavka;
import com.example.demo.repositories.StudiaRep;
import com.example.demo.repositories.ZayavkaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/studia")
public class StudiaController {

    @Autowired
    private StudiaRep studiaRep;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Studia> studia = studiaRep.findAll();
        model.addAttribute("studia", studia);
        return "studia/index";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("studia", new Studia());
        return "studia/add-studia"; // обращение к файлу внутри темплате
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("studia") @Valid Studia newStudia,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors())
            return "studia/add-studia";
        studiaRep.save(newStudia);
        return "redirect:/studia/"; //прописывание url
    }

    @GetMapping("/search")
    public String search(@RequestParam("id") String adres,
                         Model model){
        List<Studia> studiaArrayList = studiaRep.findByAdres(adres);
        model.addAttribute("studia", studiaArrayList);
        return "/studia/index";
    }

    @GetMapping("/info-studia/{id}")
    public String read(@PathVariable("id") Long id,
                       Model model)
    {
        Optional<Studia> studia = studiaRep.findById(id);
        ArrayList<Studia> studiaArrayList = new ArrayList<>();
        studia.ifPresent(studiaArrayList::add);

        model.addAttribute("studia", studiaArrayList);
        return "studia/info-studia";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         Model model)
    {
        Studia studia = studiaRep.findById(id).orElseThrow();
        studiaRep.delete(studia);

        //newsReposytories.deleteById(id);
        return "redirect:/studia/";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudia(@PathVariable("id") Long id,
                                Model model)
    {
        Studia studia = studiaRep.findById(id).orElseThrow();
        studiaRep.delete(studia);
        return "redirect:/studia/";
    }

    @PostMapping("/edit/{id}")
    public String editStudia(@PathVariable("id") Long id, Model model,
                              @ModelAttribute("studia") @Valid Studia studia,
                              BindingResult bindingResult
    )
    {
        if(!studiaRep.existsById(id)){
            return "redirect:/studia/";
        }
        if(bindingResult.hasErrors()){
            return "studia/edit-studia";
        }
        studia.setId(id);
        studiaRep.save(studia);
        return "redirect:/studia/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model)
    {
        if (!studiaRep.existsById(id)) {
            return "redirect:/studia/";
        }
        Optional<Studia> studia = studiaRep.findById(id);
        ArrayList<Studia> studiaArrayList = new ArrayList<>();
        studia.ifPresent(studiaArrayList::add);
        model.addAttribute("studia", studiaArrayList.get(0));
        return "news/edit-studia";
    }

}
