package gymhum.de;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Film1;

@Controller
public class FilmController {
    
    ArrayList<Film1> filme; 

    public FilmController() {
        setFilme(new ArrayList<>());
        getFilme().add(new Film1("Matrix 1", 12, 123));
        getFilme().add(new Film1("Matrix 1", 12, 123));
        getFilme().add(new Film1("Matrix 1", 12, 123));
        getFilme().add(new Film1("Matrix 1", 12, 123));
        
    }

    @GetMapping("/filme")
    public String showFilme(@RequestParam(name="activePage", required = false, defaultValue = "filme") String activePage, Model model){
        model.addAttribute("activePage", "filme");
        model.addAttribute("filme", getFilme());
        return "index.html";
    }

    @RequestMapping("/addfilme")
    public String addPerson(@RequestParam(name="filmTitel", required = true, defaultValue = "null") String filmTitel, @RequestParam(name="filmFsk", required = true, defaultValue = "null") int filmFsk, @RequestParam(name="filmLaenge", required = true, defaultValue = "null") int filmLaenge, @RequestParam(name="activePage", required = false, defaultValue = "filme_add") String activePage, Model model){
        getFilme().add(new Film1(filmTitel, filmFsk, filmLaenge));
        return "redirect: /filme";
    }

    @GetMapping("/delfilmprep")
    public String delFilmPrep(@RequestParam(name="activePage", required = true, defaultValue = "filme_delete") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("activePage", "filme_delete");
        model.addAttribute("person", getFilme(id));
        model.addAttribute("id", id);
        return "index.html";
    }

    @GetMapping("/delfilmefinal")
    public String delFilmeFinal(@RequestParam(name="activePage", required = true, defaultValue = "filme") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        removeFilme(getFilme(id));
        return "redirect:/filme";
    }

    @GetMapping("/addfilmprep")
    public String addFilmPrep(@RequestParam(name="activePage", required = false, defaultValue = "filme_add_prep") String activePage, Model model){
        model.addAttribute("activePage", "filme_add_prep");
        return "index.html";
    }

    @GetMapping("/updatefilmprep")
    public String updateFilmePrep(@RequestParam(name="activePage", required = false, defaultValue = "filme_update") String activePage, @RequestParam(name="id", required = true) int id, Model model){
        model.addAttribute("film", getFilme(id));
        model.addAttribute("id", id);
        model.addAttribute("activePage", "filme_update");
        return "index.html";
    }

    @RequestMapping("/updatefilm")
    public String updateFilme(@RequestParam(name="filmTitel", required = true, defaultValue = "null") String filmTitel, @RequestParam(name="filmFsk", required = true, defaultValue = "null") int filmFsk, @RequestParam(name="filmLaenge", required = true, defaultValue = "null") int filmLaenge, @RequestParam(name="id", required = true) int id, @RequestParam(name="activePage", required = false, defaultValue = "filme_add") String activePage, Model model){
        Film1 film = getFilme(id);
        film.setTitel(filmTitel);
        film.setFsk(filmFsk);
        film.setLaenge(filmLaenge);
        return "redirect:/filme";
    }

    public void removeFilme(Film1 film){
        getFilme().remove(film);
    }


    public void setFilme(ArrayList<Film1> filme) {
        this.filme = filme;
    }

    public ArrayList<Film1> getFilme() {
        return filme;
    }

    public Film1 getFilme(int index) {
        return getFilme().get(index);
    }
}
