package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.model.Aluno;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AlunoDAO extends GenericDAO<Aluno> {

    public List<Aluno> listarPorPeriodo(String periodo) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        List<Aluno> alunos = null;
        try {
            String hql = "FROM Aluno WHERE ra = :ra";
            Query<Aluno> query = session.createQuery(hql, Aluno.class);
            query.setParameter("ra", RA);
            alunos = query.getResultList();
        } finally {
            session.close();
        }
        return alunos;
    }
}
