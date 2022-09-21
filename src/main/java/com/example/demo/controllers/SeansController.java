package com.example.demo.controllers;

import com.example.demo.models.Seans;
import com.example.demo.models.Zayavka;
import com.example.demo.repositories.SeansRep;
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
@RequestMapping("/seans")
public class SeansController {

    @Autowired
    private SeansRep seansRep;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Seans> seans = seansRep.findAll();
        model.addAttribute("seans", seans);
        return "seans/index";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("seans", new Seans());
        return "seans/add-seans"; // обращение к файлу внутри темплате
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("seans") @Valid Seans newSeans,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors())
            return "seans/add-seans";
        seansRep.save(newSeans);
        return "redirect:/seans/"; //прописывание url
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String dataivremya,
                         Model model){
        List<Seans> seansArrayList = seansRep.findByDataivremya(dataivremya);
        model.addAttribute("seans", seansArrayList);
        return "/seans/index";
    }

    @GetMapping("/info-seans/{id}")
    public String read(@PathVariable("id") Long id,
                       Model model)
    {
        Optional<Seans> seans = seansRep.findById(id);
        ArrayList<Seans> seansArrayList = new ArrayList<>();
        seans.ifPresent(seansArrayList::add);

        model.addAttribute("seans", seansArrayList);
        return "seans/info-seans";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         Model model)
    {
        Seans seans = seansRep.findById(id).orElseThrow();
        seansRep.delete(seans);

        //newsReposytories.deleteById(id);
        return "redirect:/seans/";
    }

    @PostMapping("/delete/{id}")
    public String deleteSeans(@PathVariable("id") Long id,
                                Model model)
    {
        Seans seans = seansRep.findById(id).orElseThrow();
        seansRep.delete(seans);
        return "redirect:/seans/";
    }

    @PostMapping("/edit/{id}")
    public String editSeans(@PathVariable("id") Long id, Model model,
                              @ModelAttribute("seans") @Valid Seans seans,
                              BindingResult bindingResult
    )
    {
        if(!seansRep.existsById(id)){
            return "redirect:/seans/";
        }
        if(bindingResult.hasErrors()){
            return "seans/edit-seans";
        }
        seans.setId(id);
        seansRep.save(seans);
        return "redirect:/seans/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model)
    {
        if (!seansRep.existsById(id)) {
            return "redirect:/seans/";
        }
        Optional<Seans> seans = seansRep.findById(id);
        ArrayList<Seans> seansArrayList = new ArrayList<>();
        seans.ifPresent(seansArrayList::add);
        model.addAttribute("zayavka", seansArrayList.get(0));
        return "news/edit-seans";
    }
}
