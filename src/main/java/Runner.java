import db.DBHelper;
import models.Director;
import models.Film;

import java.util.List;

public class Runner {

    public static void main(String[] args) {



        Director quentin = new Director("Quentin Tarantino");
        DBHelper.save(quentin);
        Director kubrick = new Director("Stanley Kubrick");
        DBHelper.save(kubrick);



        Film pulp = new Film("Pulp Fiction", 10, quentin);
        DBHelper.save(pulp);

        Film basterds = new Film("Inglorius Basterds", 21, quentin);
        DBHelper.save(basterds);

        Film shining = new Film("The Shining,", 7, kubrick);
        DBHelper.save(shining);

        Film orange = new Film("The Mechanical Orange", 18, kubrick);
        DBHelper.save(orange);

        List<Film> films = DBHelper.getAll(Film.class);
        List<Director> directors = DBHelper.getAll(Director.class);

        Film foundFilm = DBHelper.findById(3, Film.class);

        foundFilm.setAgeRating(105);
        DBHelper.update(foundFilm);
//
//        Film anotherFoundFilm = DBHelper.findById(2, Film.class);
//        DBHelper.delete(anotherFoundFilm);

    }
}
