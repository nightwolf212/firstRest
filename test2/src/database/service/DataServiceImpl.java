package database.service;
import info.ExpoInfo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Configuration;

import database.entity.Author;
import database.entity.Exhibit;
import database.entity.Fund;
import database.entity.Kit;
import database.entity.MovingOfExhibit;
import database.entity.MovingOfKit;
/////////////////////////////////////////////////////////////////////////////////
// Basic Implementation of DataService
////////////////////////////////////////////////////////////////////////////////
public class DataServiceImpl implements DataService {

	
	//////////////////////////////////////////////////////////////////////////////////
	// Fields
	//////////////////////////////////////////////////////////////////////////////////
	

	//////////////////////////////////////////////////////////////////////////////////
	// Public methods
	//////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Author getAuthor(int authorId) {       
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Author x=null;
	Transaction tx = session.beginTransaction();
	x=(Author)session.createQuery("from Author where authorId='"+authorId+"'").uniqueResult();
	tx.commit();
	return x;
	}
	

	@Override
	public Exhibit getExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Exhibit x=null;
		Transaction tx = session.beginTransaction();
		x=(Exhibit)session.createQuery("from Exhibit where exhibitId='"+exhibitId+"'").uniqueResult();
		tx.commit();
		return x;
		
	}

	@Override
	public Kit getKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Kit x=null;
		Transaction tx = session.beginTransaction();
		x=(Kit)session.createQuery("from Kit where kitId='"+kitId+"'").uniqueResult();
		tx.commit();
		return x;

		
	}

@Override
	public MovingOfExhibit getMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfExhibit x=null;
		Transaction tx = session.beginTransaction();
		x=(MovingOfExhibit)session.createQuery("from MovingOfExhibit where movingOfExId='"+movingOfExId+"'").uniqueResult();
		tx.commit();
		return x;

	}

	@Override
	public MovingOfKit getMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfKit x=null;
		Transaction tx = session.beginTransaction();
		x=(MovingOfKit)session.createQuery("from MovingOfKit where movingOfKitId='"+movingOfKitId+"'").uniqueResult();
		tx.commit();
		return x;
		
	}

	@Override
	public void addAuthor(Author aut) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(aut);
		tx.commit();
		
		

	}

	@Override
	public void addExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new  Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(ex);
		tx.commit();
		
	}

	@Override
	public void addKit(Kit kt) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(kt);
		tx.commit();
		
	}

	@Override
	public void addMovingOfExhibit(MovingOfExhibit me) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(me);
		tx.commit();
		
	}

	@Override
	public void addMovingOfKit(MovingOfKit mk) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(mk);
		tx.commit();
		
	}

	@Override
	public void removeAutor(int authorId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Author aut=this.getAuthor(authorId);
		Transaction tx=session.beginTransaction();
		session.delete(aut);
		tx.commit();
	}

	@Override
	public void removeExhibit(int exhibitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Exhibit ex =this.getExhibit(exhibitId);
		Transaction tx=session.beginTransaction();
		session.delete(ex);
		tx.commit();
	}

	@Override
	public void removeKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Kit kt=this.getKit(kitId);
		Transaction tx=session.beginTransaction();
		session.delete(kt);
		tx.commit();
	}

	@Override
	public void removeMovingOfExhibit(int movingOfExId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfExhibit me=this.getMovingOfExhibit(movingOfExId);
		Transaction tx=session.beginTransaction();
		session.delete(me);
		tx.commit();
	}

	@Override
	public void removeMovingOfKit(int movingOfKitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		MovingOfKit mk=this.getMovingOfKit(movingOfKitId);
		Transaction tx=session.beginTransaction();
		session.delete(mk);
		tx.commit();

	}

	@Override
	public ArrayList<Exhibit> getExhibitsFromKit(int kitId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>) session.createQuery("from Exhibit where kitId='"+kitId+"'").list();
		tx.commit();
		return exs;
	}

	@Override
	public ArrayList<Kit> getKitsFromFund(int fundId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Kit> kts=(ArrayList<Kit>) session.createQuery("from Kit where fundId='"+fundId+"'").list();
		tx.commit();
		return kts;
	}

	@Override
	public ExpoInfo getLocationOfKit(int kitId, Date d) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		MovingOfKit mk=(MovingOfKit)session.createQuery("from MovingOfKit where kitId='"+kitId+"' and (beginDate<='"+d.toString()+"' and endDate>='"+d.toString()+"')").uniqueResult();
		ExpoInfo ei=new ExpoInfo(mk.getExpoName(),mk.getExpoAdress(),mk.getExpoPhone(),mk.getPersonName(),mk.getBeginDate(),mk.getEndDate());
		return ei;
	}

	@Override
	public ExpoInfo getLocationOfExhibit(int exId, Date d) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		MovingOfExhibit me=(MovingOfExhibit)session.createQuery("from MovingOfExhibit where exId='"+exId+"' and (beginDate<='"+d.toString()+"' and endDate>='"+d.toString()+"')").uniqueResult();
		ExpoInfo ei=new ExpoInfo(me.getExpoName(),me.getExpoAdress(),me.getExpoPhone(),me.getPersonName(),me.getBeginDate(),me.getEndDate());
		return ei;
		
	}


	@Override
	public void updateKit(Kit kt) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(kt);
		tx.commit();
		
	}


	@Override
	public void updateExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(ex);
		tx.commit();
	}


	@Override
	public void addFund(Fund fd) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(fd);
		tx.commit();

	}


	@Override
	public void removeFund(int fId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Fund fd=this.getFund(fId);
		Transaction tx=session.beginTransaction();
		session.delete(fd);
		tx.commit();	
	}


	@Override
	public void updateFund(Fund fd) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(fd);
		tx.commit();
	}
	
	@Override 
	public Fund getFund(int fId)
	{
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Fund x=null;
		Transaction tx = session.beginTransaction();
		x=(Fund)session.createQuery("from Fund where fundId='"+fId+"'").uniqueResult();
		tx.commit();
		return x;

	}


	@Override
	public ArrayList<Exhibit> getExhibits() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>)session.createQuery("from Exhibit").list();
		tx.commit();
		return exs;
	}


	@Override
	public ArrayList<Kit> getKits() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Kit> kts=(ArrayList<Kit>)session.createQuery("from Kit").list();
		tx.commit();
		return kts;
		
	}


	@Override
	public ArrayList<Fund> getFunds() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Fund> fds=(ArrayList<Fund>)session.createQuery("from Fund").list();
		tx.commit();
		return fds;
		
	}


	@Override
	public ArrayList<Author> getAuthors() {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Author> ats=(ArrayList<Author>)session.createQuery("from Author").list();
		tx.commit();
		return ats;
	}


	@Override
	public ArrayList<Exhibit> getExhibitsByAut(int autId) {
		// TODO Auto-generated method stub
		SessionFactory sessions=new Configuration().configure().buildSessionFactory();
		Session session=sessions.getCurrentSession();
		Transaction tx=session.beginTransaction();
		ArrayList<Exhibit> exs=(ArrayList<Exhibit>) session.createQuery("from Exhibit where authorId='"+autId+"'").list();
		tx.commit();
		return exs;
	
	}
	

}
