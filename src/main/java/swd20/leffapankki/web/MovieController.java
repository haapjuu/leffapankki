package swd20.leffapankki.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.leffapankki.domain.Movie;
import swd20.leffapankki.domain.MovieRepo;
import swd20.leffapankki.domain.CategoryRepo;

@Controller
public class MovieController {
	
		@Autowired
		MovieRepo movieRepo;
		@Autowired
		CategoryRepo categoryRepo;
		
		@RequestMapping(value="/index", method=RequestMethod.GET)
		public String listMovies() {
			return "";
		}
		
		@RequestMapping(value="/movielist", method = RequestMethod.GET)
		public String getAllMovies(Model model) {
			model.addAttribute("movies", movieRepo.findAll());
			return "movielist";
		}
		
		@RequestMapping(value="/movies", method = RequestMethod.GET)
		public @ResponseBody List<Movie> movieListRest(){		
			return (List<Movie>) movieRepo.findAll();
		}
		
		@RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Movie> findBookRest(@PathVariable("id") Long movieId){
			return movieRepo.findById(movieId);
		}
		
		
		@RequestMapping(value = "/newmovie", method = RequestMethod.GET)
		public String getNewMovieForm(Model model) {
			model.addAttribute("movie", new Movie());
			model.addAttribute("categories", categoryRepo.findAll());
			
			return "addmovie";
		}
		
		@RequestMapping(value = "/deletemovie/{id}", method = RequestMethod.GET)
		public String deleteMovie(@PathVariable("id") Long movieId) {
			movieRepo.deleteById(movieId);
			return "redirect:../movielist";
		}
		
		@RequestMapping(value = "/editmovie/{id}", method = RequestMethod.GET)
		public String getNewEditForm(@PathVariable("id") Long movieId, Model model) {
			model.addAttribute("movie", movieRepo.findById(movieId));
			model.addAttribute("categories", categoryRepo.findAll());
			return "editmovie";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveMovie(@ModelAttribute Movie movie) {
			movieRepo.save(movie);
			return "redirect:/movielist";
		}
		
		@RequestMapping(value="/login")
	    public String login() {	
	        return "login";
		}
}
