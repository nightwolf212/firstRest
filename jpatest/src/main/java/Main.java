import database.entity.Author;
import database.service.DataService;
import database.service.DataServiceImpl;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataServiceImpl ds=new DataServiceImpl();
		Author x=new Author();
		x.setAuthorName("1212ccccccccccccccccc121233");
		x.setBirth("1999-12-12");
		x.setCountry("a123123123s");
		ds.addAuthor(x);
	}

}
