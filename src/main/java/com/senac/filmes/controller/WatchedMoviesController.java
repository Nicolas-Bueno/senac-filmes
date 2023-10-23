package com.senac.filmes.controller;

import com.senac.filmes.model.Filme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/filme/{id}")
    public String mostrarDetalhesFilme(@PathVariable int id, Model model){
        
        if(id >=0 && id < filmes.size()){
            Filme filmeSelecionado = filmes.get(id);
            
            Filme detalhesFilme = new Filme();
            detalhesFilme.setNome(filmeSelecionado.getNome());
            detalhesFilme.setSinopse(filmeSelecionado.getSinopse());
            detalhesFilme.setAnoLancamento(filmeSelecionado.getAnoLancamento());
            detalhesFilme.setGenero(filmeSelecionado.getGenero());
            
            model.addAttribute("detalhesFilme", detalhesFilme);
            
            return "detalhe-filme";
        }else{
            return "filme_nao_encontrado";
        }
    }
}
