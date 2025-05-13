package br.edu.ifpr.bsi.projetodisciplina.dao;

import br.edu.ifpr.bsi.projetodisciplina.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario buscarPorEmail(String email) {
        Session session = HibernateHelper.getFabricaDeSessoes().openSession();
        Usuario usuario = null;
        try {
            String hql = "FROM Usuario WHERE email = :email";
            Query<Usuario> query = session.createQuery(hql, Usuario.class);
            query.setParameter("email", email);
            usuario = query.uniqueResult();
        } finally {
            session.close();
        }
        return usuario;
    }
}
