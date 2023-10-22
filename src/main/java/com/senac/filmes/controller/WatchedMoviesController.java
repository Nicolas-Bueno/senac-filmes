package com.senac.filmes.controller;

import com.senac.filmes.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
