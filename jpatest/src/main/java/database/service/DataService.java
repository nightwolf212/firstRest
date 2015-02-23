package database.service;
import info.ExpoInfo;

import java.util.ArrayList;
import java.sql.Date;

import javax.ejb.Local;

import database.entity.*;

///////////////////////////////////////////////////////////////////////
//Interface implemented by classes, which provides connection with data
///////////////////////////////////////////////////////////////////////
@Local
public interface DataService {
	public Author getAuthor(int authorId);
	public Exhibit getExhibit(int exhibitId);
	public Kit getKit(int kitId);
	public Fund getFund(int fId);
	public MovingOfExhibit getMovingOfExhibit(int movingOfExId);
	public MovingOfKit getMovingOfKit(int movingOfKitId);
	public void addAuthor(Author aut);
	public void addExhibit(Exhibit ex);
	public void addKit(Kit kt);
	public void addFund(Fund fd);
	public void addMovingOfExhibit(MovingOfExhibit me);
	public void addMovingOfKit(MovingOfKit mk);
	public void removeAutor(int authorId);
	public void removeExhibit(int exhibitId);
	public void removeKit(int kitId);
	public void removeFund(int fId);
	public void removeMovingOfExhibit(int movingOfExId);
	public void removeMovingOfKit(int movingOfKitId);
	public void updateKit(Kit kt);
	public void updateFund(Fund fd);
	public void updateExhibit(Exhibit ex);
	public ArrayList<Exhibit> getExhibitsFromKit(int kitId);
	public ArrayList<Exhibit> getExhibitsByAut(int autId);
	public ArrayList<Kit> getKitsFromFund(int fundId);
	public ArrayList<Exhibit> getExhibits();
	public ArrayList<Kit> getKits();
	public ArrayList<Fund> getFunds();
	public ArrayList<Author> getAuthors();
	public ExpoInfo getLocationOfKit(int kitId, Date d);
	public ExpoInfo getLocationOfExhibit(int exId, Date d);
	
}
