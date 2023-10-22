package com.senac.filmes.controller;

import com.senac.filmes.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Nicolas
 */
@Controller
public class WatchedMoviesController {
    
    @GetMapping("/cadastro")
    public String cadastrarFilme(Model model){
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String receberCadastro(Model model, @ModelAttribute Filme filme){
        model.addAttribute("filme", filme);
        return "filme";
    }
}
