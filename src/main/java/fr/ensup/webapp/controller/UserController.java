package fr.ensup.webapp.controller;


import fr.ensup.webapp.model.User;
import fr.ensup.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

  @Autowired
  private UserService service;

   @GetMapping("/login")
    public String ShowLoginPage(Model model){
            model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/register")
    public String ShowRegisterPage(Model model){
            model.addAttribute("user", new User());
        return "registre";
    }

    @PostMapping("/register/user/save")
      public String SaveUser(User user, RedirectAttributes ra){
            service.save(user);
            ra.addFlashAttribute("message", "Un nouveau user a été ajouté !");

      return "redirect:/login";
    }

    @PostMapping("/login/user/")
      public String getUser(User user,  RedirectAttributes ra ){
           if(!service.get(user).isEmpty()){
               return "redirect:/";
           }else {
                 ra.addFlashAttribute("message", "User non trouvé!");
               return "redirect:/login";
           }


      }
}
