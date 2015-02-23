package database.service;
import info.ExpoInfo;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import database.entity.Author;
import database.entity.Exhibit;
import database.entity.Fund;
import database.entity.Kit;
import database.entity.MovingOfExhibit;
import database.entity.MovingOfKit;
/////////////////////////////////////////////////////////////////////////////////
// Basic Implementation of DataService
////////////////////////////////////////////////////////////////////////////////
@Stateless
public class DataServiceImpl implements DataService {

	
	//////////////////////////////////////////////////////////////////////////////////
	// Fields
	//////////////////////////////////////////////////////////////////////////////////
	@PersistenceUnit(unitName="BaseJPA")	
	public EntityManagerFactory emf;
	//@PersistenceContext(unitName="BaseJPA")	
	//public EntityManager em;
	//////////////////////////////////////////////////////////////////////////////////
	// Public methods
	//////////////////////////////////////////////////////////////////////////////////

	//@Override
	public Author getAuthor(int authorId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Author a=em.find(Author.class,authorId);
			//em.flush();
			return a;
		}
		finally{em.close();}
	}

	//@Override
	public Exhibit getExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Exhibit e=em.find(Exhibit.class,exhibitId);
			//em.flush();
			return e;
		}
		finally{em.close();}
	}

	//@Override
	public Kit getKit(int kitId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Kit k=em.find(Kit.class,kitId);
			//em.flush();
			return k;
			}
		finally{em.close();}
	}

	//@Override
	public Fund getFund(int fId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		Fund f=em.find(Fund.class,fId);
		return f;
		}
		finally{em.close();}
	}

	//@Override
	public MovingOfExhibit getMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public MovingOfKit getMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void addAuthor(Author aut) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			em.merge(aut);
			em.flush();
			
		}
		finally{em.close();}
		
	}

	//@Override
	public void addExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			em.merge(ex);
			em.flush();
			
		}
		finally{em.close();}
		
	}

	//@Override
	public void addKit(Kit kt) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			em.merge(kt);
			em.flush();
			
		}
		finally{em.close();}
		
	}
	
	//@Override
	public void addFund(Fund fd) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			
		
		em.merge(fd);
		em.flush();
		}
		finally{em.close();}
	}

	//@Override
	public void addMovingOfExhibit(MovingOfExhibit me) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void addMovingOfKit(MovingOfKit mk) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void removeAutor(int authorId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Author a=em.find(Author.class, authorId);
			em.remove(a);
			em.flush();
		}
		finally{em.close();}
		
	}

	//@Override
	public void removeExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Exhibit e=em.find(Exhibit.class, exhibitId);
			em.remove(e);
			em.flush();
		}
		finally{em.close();}
		
	}

	//@Override
	public void removeKit(int kitId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
			Kit k=em.find(Kit.class, kitId);
			em.remove(k);
			em.flush();
		}
		finally{em.close();}

	}

	//@Override
	public void removeFund(int fId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{

		Fund f=em.find(Fund.class, fId);
		em.remove(f);
		em.flush();
		}
		finally{em.close();}

	}

	//@Override
	public void removeMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void removeMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void updateKit(Kit kt) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{

		em.merge(kt);
		em.flush();
		}
		finally{em.close();}

	}

	//@Override
	public void updateFund(Fund fd) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{

		em.merge(fd);
		em.flush();
		}
		finally{em.close();}

	}

	//@Override
	public void updateExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		em.merge(ex);
		em.flush();
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Exhibit> getExhibitsFromKit(int kitId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getFromKit").setParameter("kitId", kitId).getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Exhibit> getExhibitsByAut(int autId) {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getFromAuthor").setParameter("autId", autId).getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Kit> getKitsFromFund(int fundId) {
		// TODO Auto-generated method stub
		
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListKit(em.createNamedQuery("kits.getFromFund").setParameter("fundId", fundId).getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Exhibit> getExhibits() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getAll").getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Kit> getKits() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListKit(em.createNamedQuery("kits.getAll").getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ArrayList<Fund> getFunds() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListFund(em.createNamedQuery("funds.getAll").getResultList());
		}
		finally{em.close();}

		
		
	}

	//@Override
	public ArrayList<Author> getAuthors() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		try{
		return listToArrayListAuthor(em.createNamedQuery("authors.getAll").getResultList());
		}
		finally{em.close();}

	}

	//@Override
	public ExpoInfo getLocationOfKit(int kitId, Date d) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public ExpoInfo getLocationOfExhibit(int exId, Date d) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	
	//@Override
	public Author getAuthor(int authorId) {       
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Author x=null;
	Transaction tx = session.beginTransaction();
	x=(Author)session.createQuery("from Author where authorId='"+authorId+"'").uniqueResult();
	tx.commit();
	sessions.close();
	return x;
	}
	

	//@Override
	public Exhibit getExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Exhibit x=null;
		Transaction tx = session.beginTransaction();
		x=(Exhibit)session.createQuery("from Exhibit where exhibitId='"+exhibitId+"'").uniqueResult();
		tx.commit();
		sessions.close();
		return x;
		
	}

	//@Override
	public Kit getKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Kit x=null;
		Transaction tx = session.beginTransaction();
		x=(Kit)session.createQuery("from Kit where kitId='"+kitId+"'").uniqueResult();
		tx.commit();
		sessions.close();
		return x;

		
	}

//@Override
	public MovingOfExhibit getMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfExhibit x=null;
		Transaction tx = session.beginTransaction();
		x=(MovingOfExhibit)session.createQuery("from MovingOfExhibit where movingOfExId='"+movingOfExId+"'").uniqueResult();
		tx.commit();
		sessions.close();
		return x;

	}

	//@Override
	public MovingOfKit getMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfKit x=null;
		Transaction tx = session.beginTransaction();
		x=(MovingOfKit)session.createQuery("from MovingOfKit where movingOfKitId='"+movingOfKitId+"'").uniqueResult();
		tx.commit();
		sessions.close();
		return x;
		
	}

	//@Override
	public void addAuthor(Author aut) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(aut);
		tx.commit();
		sessions.close();
		

	}

	//@Override
	public void addExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new  Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(ex);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void addKit(Kit kt) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(kt);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void addMovingOfExhibit(MovingOfExhibit me) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(me);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void addMovingOfKit(MovingOfKit mk) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(mk);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void removeAutor(int authorId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Author aut=this.getAuthor(authorId);
		Transaction tx=session.beginTransaction();
		session.delete(aut);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void removeExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Exhibit ex =this.getExhibit(exhibitId);
		Transaction tx=session.beginTransaction();
		session.delete(ex);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void removeKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Kit kt=this.getKit(kitId);
		Transaction tx=session.beginTransaction();
		session.delete(kt);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void removeMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfExhibit me=this.getMovingOfExhibit(movingOfExId);
		Transaction tx=session.beginTransaction();
		session.delete(me);
		tx.commit();
		sessions.close();
	}

	//@Override
	public void removeMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfKit mk=this.getMovingOfKit(movingOfKitId);
		Transaction tx=session.beginTransaction();
		session.delete(mk);
		tx.commit();
		sessions.close();
	}

	//@Override
	public ArrayList<Exhibit> getExhibitsFromKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>) session.createQuery("from Exhibit where kitId='"+kitId+"'").list();
		tx.commit();
		sessions.close();
		return exs;
	}

	//@Override
	public ArrayList<Kit> getKitsFromFund(int fundId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Kit> kts=(ArrayList<Kit>) session.createQuery("from Kit where fundId='"+fundId+"'").list();
		tx.commit();
		sessions.close();
		return kts;
	}

	//@Override
	public ExpoInfo getLocationOfKit(int kitId, Date d) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		MovingOfKit mk=(MovingOfKit)session.createQuery("from MovingOfKit where kitId='"+kitId+"' and (beginDate<='"+d.toString()+"' and endDate>='"+d.toString()+"')").uniqueResult();
		ExpoInfo ei=new ExpoInfo(mk.getExpoName(),mk.getExpoAdress(),mk.getExpoPhone(),mk.getPersonName(),mk.getBeginDate(),mk.getEndDate());
		sessions.close();
		return ei;
	}

	//@Override
	public ExpoInfo getLocationOfExhibit(int exId, Date d) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		MovingOfExhibit me=(MovingOfExhibit)session.createQuery("from MovingOfExhibit where exId='"+exId+"' and (beginDate<='"+d.toString()+"' and endDate>='"+d.toString()+"')").uniqueResult();
		ExpoInfo ei=new ExpoInfo(me.getExpoName(),me.getExpoAdress(),me.getExpoPhone(),me.getPersonName(),me.getBeginDate(),me.getEndDate());
		sessions.close();
		return ei;
		
	}


	//@Override
	public void updateKit(Kit kt) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(kt);
		tx.commit();
		sessions.close();
	}


	//@Override
	public void updateExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(ex);
		tx.commit();
		sessions.close();
	}


	//@Override
	public void addFund(Fund fd) {
		// TODO Auto-generated method stub
		/*
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(fd);
		tx.commit();
		sessions.close();
		*/
	
	
	
	/*
		em.getTransaction().begin();
		em.merge(fd);
		em.getTransaction().commit();
	}


	//@Override
	public void removeFund(int fId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Fund fd=this.getFund(fId);
		Transaction tx=session.beginTransaction();
		session.delete(fd);
		tx.commit();	
		sessions.close();
	}


	//@Override
	public void updateFund(Fund fd) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(fd);
		tx.commit();
		sessions.close();
	}
	
	//@Override 
	public Fund getFund(int fId)
	{
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Fund x=null;
		Transaction tx = session.beginTransaction();
		x=(Fund)session.createQuery("from Fund where fundId='"+fId+"'").uniqueResult();
		tx.commit();
		sessions.close();
		return x;

	}


	//@Override
	public ArrayList<Exhibit> getExhibits() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>)session.createQuery("from Exhibit").list();
		tx.commit();
		sessions.close();
		return exs;
	}


	//@Override
	public ArrayList<Kit> getKits() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Kit> kts=(ArrayList<Kit>)session.createQuery("from Kit").list();
		tx.commit();
		sessions.close();
		return kts;
		
	}


	//@Override
	public ArrayList<Fund> getFunds() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Fund> fds=(ArrayList<Fund>)session.createQuery("from Fund").list();
		tx.commit();
		sessions.close();
		return fds;
		
	}


	//@Override
	public ArrayList<Author> getAuthors() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Author> ats=(ArrayList<Author>)session.createQuery("from Author").list();
		tx.commit();
		sessions.close();
		return ats;
	}


	//@Override
	public ArrayList<Exhibit> getExhibitsByAut(int autId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>) session.createQuery("from Exhibit where authorId='"+autId+"'").list();
		tx.commit();
		sessions.close();
		return exs;
	
	}
	
	
*/
	////////////////////////////////////////////////////////////////////////////////////////
	// Private methods
	////////////////////////////////////////////////////////////////////////////////////////
	private ArrayList<Fund> listToArrayListFund(List p)
	{
		ArrayList<Fund> res=new ArrayList<Fund>();
		for(Object i :p)
		{
			res.add((Fund)i);
		}
		return res;
	}
	private ArrayList<Kit> listToArrayListKit(List p)
	{
		ArrayList<Kit> res=new ArrayList<Kit>();
		for(Object i :p)
		{
			res.add((Kit)i);
		}
		return res;
	}
	private ArrayList<Exhibit> listToArrayListExhibit(List p)
	{
		ArrayList<Exhibit> res=new ArrayList<Exhibit>();
		for(Object i :p)
		{
			res.add((Exhibit)i);
		}
		return res;
	}
	private ArrayList<Author> listToArrayListAuthor(List p)
	{
		ArrayList<Author> res=new ArrayList<Author>();
		for(Object i :p)
		{
			res.add((Author)i);
		}
		return res;
	}
}
