package fr.laerce.cinema.web;

import fr.laerce.cinema.dao.RoleDao;
import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    RoleDao roleDao;

    @PostMapping("/add")
    public String submit( @ModelAttribute Role role){
        roleDao.save(role);
        return "redirect:/film/mod/"+role.getFilm ().getId ();
    }
    @GetMapping("/delete/{id}")
    public String delete( @PathVariable Long id){
        Film film = roleDao.findById (id).get ().getFilm ();
        roleDao.deleteById (id);
        return "redirect:/film/mod/"+film.getId ();
    }
}
