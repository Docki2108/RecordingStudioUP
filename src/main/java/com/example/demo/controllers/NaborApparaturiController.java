package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
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
@RequestMapping("/nabor")
public class NaborApparaturiController {

    @Autowired
    private NaborApparaturiRep naborApparaturiRep;
    @Autowired
    private MicrofonRep microfonRep;
    @Autowired
    private MiksherniyPultRep miksherniyPultRep;
    @Autowired
    private MonitoriRep monitoriRep;
    @Autowired
    private NaushnikiRep naushnikiRep;
    @Autowired
    private PORep poRep;

    @GetMapping("/")
    public String index(Model model){
        Iterable<NaborApparaturi> naborApparaturis = naborApparaturiRep.findAll();
        Iterable<Microfon> microfons = microfonRep.findAll();
        Iterable<MiksherniyPult> miksherniyPults = miksherniyPultRep.findAll();
        Iterable<Monitori> monitoris = monitoriRep.findAll();
        Iterable<Naushniki> naushnikis = naushnikiRep.findAll();
        Iterable<PO> poReps = poRep.findAll();

        model.addAttribute("naborApparaturis", naborApparaturis);
        model.addAttribute("microfons", microfons);

        return "naborApparaturi/index";
    }

    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("naborApparaturi", new NaborApparaturi());
        return "naborApparaturi/add-naborApparaturi"; // обращение к файлу внутри темплате
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("naborApparaturi") @Valid NaborApparaturi naborApparaturi,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors())
            return "naborApparaturi/add-naborApparaturi";
        naborApparaturiRep.save(new NaborApparaturi());
        return "redirect:/naborApparaturi/"; //прописывание url
    }

    @GetMapping("/search")
    public String search(@RequestParam("id") String id,
                         Model model){
        List<NaborApparaturi> naborApparaturiListArrayList = naborApparaturiRep.findById(id);
        model.addAttribute("zayavka", naborApparaturiListArrayList);
        return "/naborApparaturi/index";
    }

    @GetMapping("/info-naborApparaturi/{id}")
    public String read(@PathVariable("id") Long id,
                       Model model)
    {
        Optional<NaborApparaturi> naborApparaturi = naborApparaturiRep.findById(id);
        ArrayList<NaborApparaturi> naborApparaturisArrayList = new ArrayList<>();
        naborApparaturi.ifPresent(naborApparaturisArrayList::add);

        model.addAttribute("naborApparaturi", naborApparaturisArrayList);
        return "naborApparaturi/info-naborApparaturi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         Model model)
    {
        NaborApparaturi naborApparaturi = naborApparaturiRep.findById(id).orElseThrow();
        naborApparaturiRep.delete(naborApparaturi);

        //newsReposytories.deleteById(id);
        return "redirect:/naborApparaturi/";
    }

    @PostMapping("/delete/{id}")
    public String deleteNaborApparaturi(@PathVariable("id") Long id,
                                Model model)
    {
        NaborApparaturi naborApparaturi = naborApparaturiRep.findById(id).orElseThrow();
        naborApparaturi.delete(naborApparaturi);
        return "redirect:/naborApparaturi/";
    }

    @PostMapping("/edit/{id}")
    public String editNaborApparaturi(@PathVariable("id") Long id, Model model,
                              @ModelAttribute("naborApparaturi") @Valid NaborApparaturi naborApparaturi,
                              BindingResult bindingResult
    )
    {
        if(!naborApparaturiRep.existsById(id)){
            return "redirect:/naborApparaturi/";
        }
        if(bindingResult.hasErrors()){
            return "naborApparaturi/edit-naborApparaturi";
        }
        naborApparaturi.setId(id);
        naborApparaturiRep.save(naborApparaturi);
        return "redirect:/naborApparaturi/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model)
    {
        if (!naborApparaturiRep.existsById(id)) {
            return "redirect:/naborApparaturi/";
        }
        Optional<NaborApparaturi> naborApparaturi = naborApparaturiRep.findById(id);
        ArrayList<NaborApparaturi> naborApparaturiArrayList = new ArrayList<>();
        naborApparaturi.ifPresent(naborApparaturiArrayList::add);
        model.addAttribute("naborApparaturi", naborApparaturiArrayList.get(0));
        return "news/edit-naborApparaturi";
    }
}
