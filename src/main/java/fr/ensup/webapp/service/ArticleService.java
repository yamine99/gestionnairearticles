package fr.ensup.webapp.service;

import fr.ensup.webapp.model.Article;
import fr.ensup.webapp.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired private ArticleRepository repo;

    public List<Article> listAll(){
        return (List<Article>) repo.findAll();
    }

     public void save(Article article){
       repo.save(article);
    }

     public void delete(int id) throws ArticleNotFoundException {

          if(repo.count() !=0){
                 repo.deleteById(id);
            }else{
            throw new ArticleNotFoundException("Article non trouvée avec l' "+id);
          }

      }


     public Article get(int id) throws ArticleNotFoundException {
        Optional<Article> result=  repo.findById(id);

        if(result.isPresent()){
            return result.get();
        }
            throw new ArticleNotFoundException("Article non trouvée avec l' "+id);

      }


    public class ArticleNotFoundException extends Throwable {
        public ArticleNotFoundException(String message) {
            super(message);
        }
    }
}
