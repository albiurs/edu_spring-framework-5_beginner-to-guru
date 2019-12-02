package guru.springframework.joke.controllers;

import guru.springframework.joke.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JokeController
 *
 * @author created by Urs Albisser, on 2019-12-02
 * @version 0.1
 */
@Controller		// add in the JokeController{} class as a Spring MVC controller
public class JokeController {

	// == fields ==
	private JokeService jokeService;	// use service form this controller.

	// == constructors ==
	@Autowired	// Autowire the JokeController by Spring
	public JokeController(JokeService jokeService) {
		this.jokeService = jokeService;
	}

	/**
	 * showJoke()
	 * Takes in a model.
	 * Adding an attribute to the model, called "joke", which will be a random joke String from the joke service.
	 * Returning back the view name of Chuck Norris.
	 * That is, what finally setting up the RequestMapping --> @RequestMapping({"/", ""})
	 * --> When we get a request on the context root, this method on the controller will get invoked
	 * to go to the JokeService(), get a joke, append it to the model and return it back to the view layer.
	 * @param model
	 * @return
	 */
	@RequestMapping({"/", ""})	// params: "/" and empty String "", to map out the context root
	public String showJoke(Model model) {	// @param	Append the model with a property for the joke. So the Spring Framework will pass in an instance of the model.

		// Add an attribute to the model.
		// That property is going to be from the jokeService.getJoke()
		model.addAttribute("joke", jokeService.getJoke());

		// return view name, which is "chucknorris" from our assignement
		// So we're going to be telling the Thymeleaf template engine to show the view for Chuck Norris.
		return "chucknorris";
	}
}
