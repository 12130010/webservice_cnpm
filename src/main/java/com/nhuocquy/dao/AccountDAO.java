package com.nhuocquy.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;

public class AccountDAO extends DAO<Account, Long>{

	public AccountDAO(Class<Account> entytiClass) {
		super(entytiClass);
	}
	public Account login(String username, String password) throws DAOException{
		Session session = HibernateUtil.openSession();
		Account ac = null;
		Transaction transaction = null;
		String sql = "from Account as ac where ac.username = :name and ac.password = :pass";
		Query query = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			query = session.createQuery(sql);
			query.setParameter("name", username);
			query.setParameter("pass", password);
			ac = (Account) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
		return ac;
	}
	public static void main(String[] args) {
		AccountDAO accountDAO = new AccountDAO(Account.class);
		try {
			System.out.println(accountDAO.login("nhuocquy", "nhuocquy"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		HibernateUtil.shutdown();
	}
}
