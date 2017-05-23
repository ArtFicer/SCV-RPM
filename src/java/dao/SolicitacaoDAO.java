package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Solicitacao;

public class SolicitacaoDAO {

    private static SolicitacaoDAO instancia = new SolicitacaoDAO();

    public static SolicitacaoDAO obterInstancia() {
        return instancia;
    }

    private SolicitacaoDAO() {
    }

    public List<Solicitacao> obterSolicitacoes() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Solicitacao> solicitacoes = null;
        try {
            tx.begin();
            TypedQuery<Solicitacao> query = em.createQuery("select s from Solicitacao s", Solicitacao.class);
            solicitacoes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return solicitacoes;

    }

    public Solicitacao obterSolicitacao(int codSolicitacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Solicitacao solicitacao = new Solicitacao();
        try {
            tx.begin();
            solicitacao = em.find(Solicitacao.class, codSolicitacao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return solicitacao;
    }

    public void gravar(Solicitacao solicitacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(solicitacao);
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

    public void alterar(Solicitacao solicitacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(solicitacao);
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

    public void excluir(Solicitacao solicitacao) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Solicitacao.class, solicitacao.getCodSolicitacao()));
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
