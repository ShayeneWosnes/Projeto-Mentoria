package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.helpers.HibernateHelper;
import br.edu.ifpr.bsi.projetodisciplina.model.Mentoria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class MentoriaDAO extends GenericDAO<Mentoria> {

    public List<Mentoria> listarPorData(LocalDateTime data) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        List<Mentoria> mentorias = null;
        try {
            String hql = "FROM Mentoria WHERE dataHora = :data";
            Query<Mentoria> query = session.createQuery(hql, Mentoria.class);
            query.setParameter("data", data);
            mentorias = query.getResultList();
        } finally {
            session.close();
        }
        return mentorias;
    }
}
