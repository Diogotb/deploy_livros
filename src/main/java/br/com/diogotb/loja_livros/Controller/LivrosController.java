package br.com.diogotb.loja_livros.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.diogotb.loja_livros.Repository.LivrosRepository;
import br.com.diogotb.loja_livros.Model.Livro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RestController
public class LivrosController {
    
    @Autowired
    LivrosRepository livrosRepository;

    @GetMapping("/livros-list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("/livros-list");
        mv.addObject("livros", livrosRepository.findAll());
        return mv ;
    }

    @PostMapping("/livros-add")
    public ModelAndView create(Livro livro) {
        ModelAndView mv = new ModelAndView("livros-add");
        livrosRepository.save(livro);
        mv.setViewName("redirect:/livros-list");
        return mv;
    }
    


    

}
