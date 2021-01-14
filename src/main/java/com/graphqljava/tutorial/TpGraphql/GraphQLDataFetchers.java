package com.graphqljava.tutorial.TpGraphql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;


import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {
	
	private static List<Map<String, String>>movies = Arrays.asList(
			ImmutableMap.<String, String> builder()
			.put("id_movie","movie_1")
			.put("titreFrancais","le cinquième élément")
			.put("titreOriginal","The Fifth Element")
			.put("dateSortie","1997")
			.put("realisateur","Luc Besson")
			.put("etat", "terminé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_movie","movie_2")
			.put("titreFrancais","Avatar")
			.put("titreOriginal","Avatar")
			.put("dateSortie","2009")
			.put("realisateur","James Cameron")
			.put("etat", "terminé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_movie","movie_3")
			.put("titreFrancais","ready player one")
			.put("titreOriginal","ready player one")
			.put("dateSortie","2018")
			.put("realisateur","Steven Spielberg")
			.put("etat", "terminé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_movie","movie_4")
			.put("titreFrancais","Passengers")
			.put("titreOriginal","Passengers")
			.put("dateSortie","2016")
			.put("realisateur","Morten Tyldum")
			.put("etat", "terminé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_movie","movie_5")
			.put("titreFrancais","la grande vadrouille")
			.put("titreOriginal","la grande vadrouille")
			.put("dateSortie","1966")
			.put("realisateur","Gerard Oury")
			.put("etat", "terminé")
			.build()
	);
	
	private static List<Map<String, String>> roles = Arrays.asList(
            ImmutableMap.of("acteur", "acteur_2",
                    "movie", "movie_1",
                    "role", "Korben Dallas dans le cinquième élément"),
            ImmutableMap.of("acteur", "acteur_5",
                    "movie", "movie_2",
                    "role", "Jake Sully dans Avatar"),
            ImmutableMap.of("acteur", "acteur_1",
                    "movie", "movie_4",
                    "role", "Aurora dans Passengers"),
            ImmutableMap.of("acteur", "acteur_3",
                    "movie", "movie_3",
                    "role", "Parzival dans Ready Player One"),
            ImmutableMap.of("acteur", "acteur_4",
                    "movie", "movie_5",
                    "role", "chef d'orchestre dans la grande vadrouille")
           
    );
	
	private static List<Map<String, String>>acteurs = Arrays.asList(
			ImmutableMap.<String, String> builder()
			.put("id_acteur","acteur_1")
			.put("nom","Lawrence")
			.put("prenom","Jennifer")
			.put("dateNaissance","15 aout 1990")
			.put("dateMort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_acteur","acteur_2")
			.put("nom","Willis")
			.put("prenom","Bruce")
			.put("dateNaissance","19 mars 1955")
			.put("dateMort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_acteur","acteur_3")
			.put("nom","Tye")
			.put("prenom","Sheridan")
			.put("dateNaissance","11 novembre 1996")
			.put("dateMort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_acteur","acteur_4")
			.put("nom","de Funes")
			.put("prenom","Louis")
			.put("dateNaissance","31 juillet 1914")
			.put("dateMort","27 janvier 1983")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_acteur","acteur_5")
			.put("nom","Worthington")
			.put("prenom","Sam")
			.put("dateNaissance","2 aout 1976")
			.put("dateMort","non décédé")
			.build()
	);
	
	private static List<Map<String, String>>realisateurs = Arrays.asList(
			ImmutableMap.<String, String> builder()
			.put("id_realisateur","realisateur_1")
			.put("nom","Besson")
			.put("prenom","Luc")
			.put("date de naissance","18 mars 1959")
			.put("date mort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_realisateur","realisateur_2")
			.put("nom","Cameron")
			.put("prenom","James")
			.put("date de naissance","16 aout 1954")
			.put("date mort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_realisateur","realisateur_3")
			.put("nom","Spielberg")
			.put("prenom","Steven")
			.put("date de naissance","18 décembre 1946")
			.put("date mort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_realisateur","realisateur_4")
			.put("nom","Tyldum")
			.put("prenom","Morten")
			.put("date de naissance","19 mai 1967")
			.put("date mort","non décédé")
			.build(),
			ImmutableMap.<String, String> builder()
			.put("id_realisateur","realisateur_5")
			.put("nom","Oury")
			.put("prenom","Gerard")
			.put("date de naissance","29 avril 1919")
			.put("date mort","19 juillet 2006")
			.build()
	);
	
	
	
	
	
	public DataFetcher getMoviesDataFetcher() {
        return dataFetchingEnvironment -> {
            return movies;   
        };
    }
	
	

	public DataFetcher getRealisateurFetcher() {
		// TODO Auto-generated method stub
		return dataFetchingEnvironment -> {
            String id_realisateur = dataFetchingEnvironment.getArgument("id_realisateur");
            return realisateurs
                    .stream()
                    .filter(realisateur -> realisateur.get("id_realisateur").equals(id_realisateur))
                    .findFirst()
                    .orElse(null);
        };
	}

	public DataFetcher getActeurFetcher() {
		// TODO Auto-generated method stub
		return dataFetchingEnvironment -> {
            String id_acteur = dataFetchingEnvironment.getArgument("id_acteur");
            return acteurs
                    .stream()
                    .filter(acteur -> acteur.get("id_acteur").equals(id_acteur))
                    .findFirst()
                    .orElse(null);
        };
	}
	
	public DataFetcher getActorsByMovie() {
        // TODO Auto-generated method stub
        return dataFetchingEnvironment -> {
            String id_movie = dataFetchingEnvironment.getArgument("id_movie");
            List<Map<String, String>> actorForMovie = null;
            roles.stream().filter(role -> role.get("movie").equals(id_movie)).forEach(
                    role->actorForMovie.add(acteurs.stream().filter(acteur -> acteur.get("id_acteur").equals(role.get("acteur"))).findFirst().orElse(null))
            );
            return actorForMovie;
        };
    }
	
	
}
