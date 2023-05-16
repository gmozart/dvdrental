package com.api.dvdrental;

import com.api.dvdrental.entity.film.FilmImpl;
import com.api.dvdrental.entity.film.FilmRepository;
import com.api.dvdrental.entity.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DvdrentalApplication {

//	@Autowired
//	private FilmImpl filmImpl;
//
//	@Autowired
//	private FilmRepository filmRepository;


	public static void main(String[] args) {
		SpringApplication.run(DvdrentalApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//
//		   filmImpl.queryActorFilm(12l);
//		  //filmImpl.queryFilmCategory(12l);
//		//filmImpl.queryLanguageFilm(1l).getLanguage();
//
//	}
}
