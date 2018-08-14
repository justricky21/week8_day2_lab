package db;

import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;
    private static Transaction transaction;

    public static List<Film> getFilmByGenre(Enum genre){
      session = HibernateUtil.getSessionFactory().openSession();
      List<Film> results = null;
      try {
          Criteria cr = session.createCriteria(Film.class);
          cr.add(Restrictions.eq("genre", genre));
          results = cr.list();
      } catch( HibernateException ex) {
          ex.printStackTrace();
        } finally {
          session.close();
        }
        return results;
    }
}
