package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.RelatorioViagem;

public class RelatorioViagemDAO {

    private static RelatorioViagemDAO instancia = new RelatorioViagemDAO();

    public static RelatorioViagemDAO obterInstancia() {
        return instancia;
    }

    private RelatorioViagemDAO() {
    }

    public List<RelatorioViagem> obterRelatorioViagens() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<RelatorioViagem> relatorioViagem = null;
        try {
            tx.begin();
            TypedQuery<RelatorioViagem> query = em.createQuery("select r from RelatorioViagem r", RelatorioViagem.class);
            relatorioViagem = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return relatorioViagem;
    }

    public RelatorioViagem obterRelatorioViagem(int codRelatorioViagem) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        RelatorioViagem curso = new RelatorioViagem();
        try {
            tx.begin();
            curso
                    = em.find(RelatorioViagem.class, codRelatorioViagem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return curso;
    }

    public void gravar(RelatorioViagem relatorioViagem) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(relatorioViagem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void alterar(RelatorioViagem relatorioViagem) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(relatorioViagem);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void excluir(RelatorioViagem relatorioViagem) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em
                    .remove(em.getReference(RelatorioViagem.class, relatorioViagem.getCodRelatorioViagem()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }
}
