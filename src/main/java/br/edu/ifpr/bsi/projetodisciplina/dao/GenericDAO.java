package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.helpers.HibernateHelper;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO <Entidade> {
    private Class<Entidade> classe;

    public GenericDAO(){
        this.classe = (Class<Entidade>)((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void inserir(Entidade entidade){
        Transaction transacao = null;
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();

        try {
            transacao = session.beginTransaction();
            session.persist(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            System.out.println("Ocorreu um erro ao inserir os dados.");
        } finally {
            session.close();
        }
    }

    public void remover(Entidade entidade){
        Transaction transacao = null;
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();

        try {
            transacao = session.beginTransaction();
            session.remove(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            erro.printStackTrace();
            System.out.println("Ocorreu um erro ao remover os dados.");
        } finally {
            session.close();
        }
    }

    public List<Entidade> listar(){
        List<Entidade> resultado = null;
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Entidade> criteria = builder.createQuery(classe);
            Root<Entidade> root = criteria.from(classe);
            criteria.select(root);
            resultado = session.createQuery(criteria).getResultList();
        } catch (RuntimeException erro) {
            // Não precisa fazer rollback
            // Porque não
            System.out.println("Ocorreu um erro ao listar os dados.");
        } finally {
            session.close();
        }
        return resultado;
    }
}
