package fr.ensup.webapp.controller;



import fr.ensup.webapp.model.Article;
import fr.ensup.webapp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {


  @Autowired private ArticleService service;


    @GetMapping("/")
    public String showArticlList(Model model){
        List<Article> listArticles = service.listAll();

        model.addAttribute("listeArticles", listArticles);


        return "index";
    }

    @GetMapping("/add")
      public String ShowNewAddArticl(Model model, RedirectAttributes ra){
          model.addAttribute("article", new Article());
          String [] types = {"Accessoire", "Cosmétique", "Vêtement", "Gadget", "Outil", "Matérial informatique" };
          model.addAttribute("categories", types);
          model.addAttribute("pageTitle", "Ajouter un article");
          return "article_form";
    }

      @PostMapping("/add/save")
      public String SaveArticle(Article article,  RedirectAttributes ra){
            service.save(article);
            ra.addFlashAttribute("message", "Un nouveau article a été ajouté !");

      return "redirect:/";
    }


    @GetMapping("/update/{id}")
      public String UpdateArticle(@PathVariable("id") int id, Model model, RedirectAttributes ra){
          String [] types = {"Accessoire", "Cosmétique", "Vêtement", "Gadget", "Outil", "Matérial informatique" };
          model.addAttribute("categories", types);

            try{
               Article article = service.get(id);
                 model.addAttribute("article", article);
                 model.addAttribute("pageTitle", "Editer l'article : "+id );
                return "article_form";
            }catch (ArticleService.ArticleNotFoundException e){
                  ra.addFlashAttribute("message", e.getMessage());
                   return "redirect:/";
            }

    }


       @GetMapping("/delete/{id}")
      public String DeleteArticle(@PathVariable("id") int id, RedirectAttributes ra){

        try{
            service.delete(id);
            ra.addFlashAttribute("message", "l' article avec l'id "+id +" a été supprimé !");
            return "redirect:/";
        }catch (ArticleService.ArticleNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
            }


    }


}
