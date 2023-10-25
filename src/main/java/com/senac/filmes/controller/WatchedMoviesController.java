package com.senac.filmes.controller;

import com.senac.filmes.model.Analise;
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
    private List<Analise> analises = new ArrayList();
    
    @GetMapping("/cadastro")
    public String cadastrarFilme(Model model){
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }
    
    @PostMapping("/cadastro")
    public String receberCadastro(Model model, @ModelAttribute Filme filme){
        filmes.add(filme);
        model.addAttribute("filmes", filmes);
        return "filme";
    }
    
    @GetMapping("/filme")
    public String mostrarFilme(Model model){
        model.addAttribute("filmes", filmes);
        return "filme";
    }
    
    @GetMapping("/filme/{id}")
public String mostrarDetalhesFilme(@PathVariable int id, Model model) {
    Filme filmeSelecionado = buscarFilmePorId(id);

    if (filmeSelecionado != null) {
        model.addAttribute("detalhesFilme", filmeSelecionado);
        return "detalhe-filme";
    } else {
        return "filme_nao_encontrado";
    }
}

    
    @GetMapping("/adiciona-analise/{id}")
    public String mostrarFormularioAnalise(@PathVariable int id, Model model) {
        // Lógica para mostrar o formulário de adição de análise
        Filme filme = filmes.get(id);
        Analise analise = new Analise();
        analise.setFilme(filme);
        
        model.addAttribute("analise", analise);
        return "adiciona-analise";
    }
    
    @PostMapping("/adiciona-analise/{id}")
    public String salvarAnalise(Model model, @ModelAttribute Analise analise, @ModelAttribute Filme filme) {
    analises.add(analise);
    filmes.add(filme);
    model.addAttribute("detalhesFilme", filme);
    model.addAttribute("detalhesAnalise", analise);
        System.out.println(filme.getId());
    return "redirect:/filme-com-analise/" + filme.getId();
}

    
    @GetMapping("/filme-com-analise/{id}")
    public String mostrarDetalhesFilmeComAnalise(@PathVariable int id, Model model) {
    // Lógica para carregar detalhes do filme e análise
        if(id >=0 && id < filmes.size()){
            Filme filmeSelecionado = filmes.get(id);
            Analise analiseAssociada = encontrarAnalisePorFilme(filmeSelecionado);
            
            Filme detalhesFilme = new Filme();
            detalhesFilme.setNome(filmeSelecionado.getNome());
            detalhesFilme.setSinopse(filmeSelecionado.getSinopse());
            detalhesFilme.setAnoLancamento(filmeSelecionado.getAnoLancamento());
            detalhesFilme.setGenero(filmeSelecionado.getGenero());
            
            Analise detalhesAnalise = new Analise();
            detalhesAnalise.setTextoAnalise(analiseAssociada.getTextoAnalise());
            detalhesAnalise.setNota(analiseAssociada.getNota());
            
            model.addAttribute("detalhesFilme", detalhesFilme);
            model.addAttribute("detalhesAnalise", detalhesAnalise);
            
            return "filme-com-analise";
        } else{
            return "filme_nao_encontrado";
        }
}
    public Analise encontrarAnalisePorFilme(Filme filmeSelecionado) {
        for (Analise analise : analises) {
            if (analise.getFilme().getId() == filmeSelecionado.getId()) {
                return analise;
            }
        }
        return null; // Retorna null se não encontrar a análise para o filme
    }
    
    public Filme buscarFilmePorId(int id) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                return filme; // Retorna o filme com o ID correspondente
            }
        }
        return null; // Retorna null se nenhum filme com o ID for encontrado
    }


}
