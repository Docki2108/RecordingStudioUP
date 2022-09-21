package com.example.demo.controllers;

import com.example.demo.models.Zayavka;
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
@RequestMapping("/zayavka")
public class ZayavkaController {
    @Autowired
    private ZayavkaRep zayavkaRep;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Zayavka> zayavka = zayavkaRep.findAll();
        model.addAttribute("zayavka", zayavka);
        return "zayavka/index";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("zayavka", new Zayavka());
        return "zayavka/add-zayavka"; // обращение к файлу внутри темплате
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("zayavka") @Valid Zayavka newZayavka,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors())
            return "zayavka/add-zayavka";
        zayavkaRep.save(newZayavka);
        return "redirect:/zayavka/"; //прописывание url
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name,
                         Model model){
        List<Zayavka> zayavkaArrayList = zayavkaRep.findByName(name);
        model.addAttribute("zayavka", zayavkaArrayList);
        return "/zayavka/index";
    }

    @GetMapping("/info-zayavka/{id}")
    public String read(@PathVariable("id") Long id,
                       Model model)
    {
        Optional<Zayavka> zayavka = zayavkaRep.findById(id);
        ArrayList<Zayavka> zayavkaArrayList = new ArrayList<>();
        zayavka.ifPresent(zayavkaArrayList::add);

        model.addAttribute("news", zayavkaArrayList);
        return "zayavka/info-zayavka";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         Model model)
    {
        Zayavka zayavka = zayavkaRep.findById(id).orElseThrow();
        zayavkaRep.delete(zayavka);

        //newsReposytories.deleteById(id);
        return "redirect:/zayavka/";
    }

    @PostMapping("/delete/{id}")
    public String deleteZayavka(@PathVariable("id") Long id,
                             Model model)
    {
        Zayavka zayavka = zayavkaRep.findById(id).orElseThrow();
        zayavkaRep.delete(zayavka);
        return "redirect:/zayavka/";
    }

    @PostMapping("/edit/{id}")
    public String editZayavka(@PathVariable("id") Long id, Model model,
                           @ModelAttribute("zayavka") @Valid Zayavka zayavka,
                           BindingResult bindingResult
    )
    {
        if(!zayavkaRep.existsById(id)){
            return "redirect:/zayavka/";
        }
        if(bindingResult.hasErrors()){
            return "zayavka/edit-zayavka";
        }
        zayavka.setId(id);
        zayavkaRep.save(zayavka);
        return "redirect:/zayavka/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model)
    {
        if (!zayavkaRep.existsById(id)) {
            return "redirect:/zayavka/";
        }
        Optional<Zayavka> zayavka = zayavkaRep.findById(id);
        ArrayList<Zayavka> zayavkaArrayList = new ArrayList<>();
        zayavka.ifPresent(zayavkaArrayList::add);
        model.addAttribute("zayavka", zayavkaArrayList.get(0));
        return "zayavka/edit-zayavka";
    }

}
