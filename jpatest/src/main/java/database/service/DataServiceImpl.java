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
	@PersistenceContext(name="BaseJPA")	
	public EntityManager em;
	//////////////////////////////////////////////////////////////////////////////////
	// Public methods
	//////////////////////////////////////////////////////////////////////////////////

	//@Override
	public Author getAuthor(int authorId) {
		// TODO Auto-generated method stub
			Author a=em.find(Author.class,authorId);
			return a;
	}

	//@Override
	public Exhibit getExhibit(int exhibitId) {
		// TODO Auto-generated method stub
			Exhibit e=em.find(Exhibit.class,exhibitId);
			return e;
	}

	//@Override
	public Kit getKit(int kitId) {
		// TODO Auto-generated method stub
			Kit k=em.find(Kit.class,kitId);
			return k;
	}

	//@Override
	public Fund getFund(int fId) {
		// TODO Auto-generated method stub
		Fund f=em.find(Fund.class,fId);
		return f;
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
			em.merge(aut);
			em.flush();
			
	}

	//@Override
	public void addExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
			em.merge(ex);
			em.flush();
				
	}

	//@Override
	public void addKit(Kit kt) {
		// TODO Auto-generated method stub
			em.merge(kt);
			em.flush();
			
	}
	
	//@Override
	public void addFund(Fund fd) {
		// TODO Auto-generated method stub
		em.merge(fd);
		em.flush();
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
			Author a=em.find(Author.class, authorId);
			em.remove(a);
			em.flush();
		
	}

	//@Override
	public void removeExhibit(int exhibitId) {
		// TODO Auto-generated method stub
			Exhibit e=em.find(Exhibit.class, exhibitId);
			em.remove(e);
			em.flush();
		
	}

	//@Override
	public void removeKit(int kitId) {
		// TODO Auto-generated method stub
			Kit k=em.find(Kit.class, kitId);
			em.remove(k);
			em.flush();
	
	}

	//@Override
	public void removeFund(int fId) {
		// TODO Auto-generated method stub
			Fund f=em.find(Fund.class, fId);
		em.remove(f);
		em.flush();
	
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
		//EntityManager em=emf.createEntityManager();
		em.merge(kt);
		em.flush();

	}

	//@Override
	public void updateFund(Fund fd) {
		// TODO Auto-generated method stub
		em.merge(fd);
		em.flush();

	}

	//@Override
	public void updateExhibit(Exhibit ex) {
		// TODO Auto-generated method stub
		em.merge(ex);
		em.flush();

	}

	//@Override
	public ArrayList<Exhibit> getExhibitsFromKit(int kitId) {
		// TODO Auto-generated method stub
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getFromKit").setParameter("kitId", kitId).getResultList());

	}

	//@Override
	public ArrayList<Exhibit> getExhibitsByAut(int autId) {
		// TODO Auto-generated method stub
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getFromAuthor").setParameter("autId", autId).getResultList());

	}

	//@Override
	public ArrayList<Kit> getKitsFromFund(int fundId) {
		// TODO Auto-generated method stub
		
		return listToArrayListKit(em.createNamedQuery("kits.getFromFund").setParameter("fundId", fundId).getResultList());

	}

	//@Override
	public ArrayList<Exhibit> getExhibits() {
		// TODO Auto-generated method stub
		return listToArrayListExhibit(em.createNamedQuery("exhibits.getAll").getResultList());

	}

	//@Override
	public ArrayList<Kit> getKits() {
		// TODO Auto-generated method stub
		return listToArrayListKit(em.createNamedQuery("kits.getAll").getResultList());

	}

	//@Override
	public ArrayList<Fund> getFunds() {
		// TODO Auto-generated method stub
			return listToArrayListFund(em.createNamedQuery("funds.getAll").getResultList());
	
		
		
	}

	//@Override
	public ArrayList<Author> getAuthors() {
		// TODO Auto-generated method stub
		return listToArrayListAuthor(em.createNamedQuery("authors.getAll").getResultList());

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
