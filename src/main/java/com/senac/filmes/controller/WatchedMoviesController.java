package com.senac.filmes.controller;

import com.senac.filmes.model.Filme;
import java.util.ArrayList;
import java.util.List;
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
    private List<Filme> filmes = new ArrayList();
    
    @GetMapping("/cadastro")
    public String cadastrarFilme(Model model){
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String receberCadastro(Model model, @ModelAttribute Filme filme){
        filmes.add(filme);
        model.addAttribute("filmes", filme);
        return "filme";
    }
    
    @GetMapping("/filme")
    public String mostrarFilme(Model model){
        model.addAttribute("filmes", filmes);
        return "filme";
    }
}
