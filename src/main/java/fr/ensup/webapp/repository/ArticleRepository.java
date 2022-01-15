package fr.ensup.webapp.repository;

import fr.ensup.webapp.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer>  {


}
