package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.model.Professor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProfessorDAO extends GenericDAO<Professor> {

    public List<Professor> listarPorArea(String area) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        List<Professor> professores = null;
        try {
            String hql = "FROM Professor WHERE area = :area";
            Query<Professor> query = session.createQuery(hql, Professor.class);
            query.setParameter("area", area);
            professores = query.getResultList();
        } finally {
            session.close();
        }
        return professores;
    }
}
