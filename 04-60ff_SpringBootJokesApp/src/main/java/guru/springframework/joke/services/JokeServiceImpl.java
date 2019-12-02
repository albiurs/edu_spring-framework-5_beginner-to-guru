package guru.springframework.joke.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * JokeServiceImpl
 *
 * @author created by Urs Albisser, on 2019-11-30
 * @version 0.1
 */
@Service
public class JokeServiceImpl implements JokeService {

	// == fields ==
	private final ChuckNorrisQuotes chuckNorrisQuotes;

	// == constructors ==


	public JokeServiceImpl() {
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}

	@Override
	public String getJoke() {
		return chuckNorrisQuotes.getRandomQuote();
	}
}
