/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pc2mb.controller;


import com.example.pc2mb.repository.AutorRepository;
import com.example.pc2mb.entity.Libro;
import com.example.pc2mb.repository.EditorialRepository;
import com.example.pc2mb.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LibroController {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private AutorRepository autorRepository;
    @RequestMapping("/librs")
    public String libs(Model model) {
        model.addAttribute("librs", libroRepository.findAll());
        return "librs";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("eds", editorialRepository.findAll());
        model.addAttribute("auts",autorRepository.findAll());
        return "add";
    }
    @RequestMapping("/add")
    public String Guardar(@RequestParam String nombre,@RequestParam int idaut,@RequestParam int ided,Model model) {
        Libro lib = new Libro();
        lib.setNombre(nombre);
        lib.setIdautor(idaut);
        lib.setIdeditorial(ided);
        libroRepository.insert(lib);
        return "redirect:/librs";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        libroRepository.deleteById(id);
        return "redirect:/librs";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("lib", libroRepository.readLibro(id));
        model.addAttribute("eds", editorialRepository.findAll());
        model.addAttribute("auts",autorRepository.findAll());
        return "edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String nombre,
                        @RequestParam int idautor,@RequestParam int ideditorial) {
        System.out.println(id+"/"+nombre+"/"+idautor+"/"+ideditorial);
        Libro lib= libroRepository.readLibro(id);
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroRepository.update(lib);
        return "redirect:/librs";
    }
}
