package myMuseum;
import info.ExpoInfo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import database.entity.Author;
import database.entity.Exhibit;
import database.entity.Fund;
import database.entity.Kit;
import database.entity.MovingOfExhibit;
import database.entity.MovingOfKit;
import database.service.DataService;
import database.service.DataServiceImpl;
@Path("")
public class webServ {
    
    @Path("/greeting")
    @GET
    public String message() {
        return "Hi REST!";
    }

    @POST
    public String lowerCase(final String message) {
        return "Hi REST!".toLowerCase();
    }

    @Path("/author/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addAuthor (@FormParam("fio") String fio,@FormParam("datey") String datey,@FormParam("datem") String datem,@FormParam("dated") String dated,@FormParam("country") String country)
    {
    	
    	Author x=new Author();
    	x.setAuthorName(fio);
    	x.setBirth(datey.concat("-").concat(datem).concat("-").concat(dated));
    	x.setCountry(country);
    	DataService ds=new DataServiceImpl();
    	ds.addAuthor(x);	
    	return fio;
    }
    @Path("/exhibit/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addExhibit (@FormParam("kitId") String kitId,@FormParam("ename") String ename,@FormParam("datey") String datey, @FormParam("autId") String autId,@FormParam("respName") String respName)
    {
    Exhibit e=new Exhibit();
    e.setAuthorId(Integer.parseInt(autId));
    e.setCreateDate(datey);
    e.setExhibitName(ename);
    e.setRespName(respName);
    e.setKitId(Integer.parseInt(autId));
    e.setFree(true);
    DataService ds=new DataServiceImpl();
    ds.addExhibit(e);
    return ename;	
    }
    @Path("/kit/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addKit (@FormParam("kname") String kname,@FormParam("fundId") String fundId)
    {
    	Kit kt=new Kit();
    	kt.setFree(true);
    	kt.setFundId(Integer.parseInt(fundId));
    	kt.setKitName(kname);
    	DataService ds=new DataServiceImpl();
    	ds.addKit(kt);
    	return kname;	
    }
    @Path("/fund/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addFund (@FormParam("fname") String fname)
    {
    	Fund f=new Fund();
    	f.setFundName(fname);
    	DataService ds=new DataServiceImpl();
    	ds.addFund(f);
    	return fname;	
    }
    @Path("/moving/exhibit/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addMovingOfExhibit (@FormParam("exId") String exId,@FormParam("dateyb") String dateyb,@FormParam("datemb") String datemb,@FormParam("datedb") String datedb,@FormParam("dateye") String dateye,@FormParam("dateme") String dateme,@FormParam("datede") String datede, @FormParam("expoAddr") String expoAddr,@FormParam("expoName") String expoName,@FormParam("expoPhone") String expoPhone,@FormParam("persName") String persName)
    {
    	MovingOfExhibit me=new MovingOfExhibit();
    	Date db=new Date(0);
    	db=Date.valueOf(dateyb.concat("-").concat(datemb).concat("-").concat(datedb));
    	Date de=new Date(0);
    	de=Date.valueOf(dateye.concat("-").concat(dateme).concat("-").concat(datede));
    	me.setBeginDate(db);
    	me.setEndDate(de);
    	me.setExpoAdress(expoAddr);
    	me.setExpoName(expoName);
    	me.setExpoPhone(expoPhone);
    	me.setPersonName(persName);
    	me.setExhibitId(Integer.parseInt(exId));
    	DataService ds=new DataServiceImpl();
    	Exhibit ex=ds.getExhibit(Integer.parseInt(exId));
    	ex.setFree(false);
    	ds.updateExhibit(ex);
    	ds.addMovingOfExhibit(me);
    	return expoName;
    }
    @Path("/moving/kit/add")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addMovingOfKit (@FormParam("kitId") String ktId,@FormParam("dateyb") String dateyb,@FormParam("datemb") String datemb,@FormParam("datedb") String datedb,@FormParam("dateye") String dateye,@FormParam("dateme") String dateme,@FormParam("datede") String datede, @FormParam("expoAddr") String expoAddr,@FormParam("expoName") String expoName,@FormParam("expoPhone") String expoPhone,@FormParam("persName") String persName)
    {
    	MovingOfKit mk=new MovingOfKit();
    	Date db=new Date(0);
    	db=Date.valueOf(dateyb.concat("-").concat(datemb).concat("-").concat(datedb));
    	Date de=new Date(0);
    	de=Date.valueOf(dateye.concat("-").concat(dateme).concat("-").concat(datede));
    	mk.setBeginDate(db);
    	mk.setEndDate(de);
    	mk.setExpoAdress(expoAddr);
    	mk.setExpoName(expoName);
    	mk.setExpoPhone(expoPhone);
    	mk.setPersonName(persName);
    	mk.setKitId(Integer.parseInt(ktId));
    	DataService ds=new DataServiceImpl();
    
    	Kit kt=ds.getKit(Integer.parseInt(ktId));
    	kt.setFree(false);
    	ds.updateKit(kt);
    	ds.addMovingOfKit(mk);
    	return expoName;
    }
    @Path("/author/{id}")
    @GET
    public String getAuthor(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	Author x=ds.getAuthor(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    		return x.toString();
    }
    @Path("/exhibit/{id}")
    @GET
    public String getExhibit(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	Exhibit x=ds.getExhibit(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    	{
    		Kit kd=ds.getKit(x.getKitId());
    		Author at=ds.getAuthor(x.getAuthorId());
    		return x.toString().concat(kd.toString()).concat(at.toString());
    	}
    }
    @Path("/fund/{id}")
    @GET
    public String getFund(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	Fund x=ds.getFund(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    		
    		return x.toString();
    }
    @Path("/kit/{id}")
    @GET
    public String message(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	Kit x=ds.getKit(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    	{
    		Fund f=ds.getFund(x.getFundId());
    		return x.toString().concat(f.toString());
    	}
    }
    @Path("/moving/exhibit/{id}")
    @GET
    public String getMovingOfExhibit(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	MovingOfExhibit x=ds.getMovingOfExhibit(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    		return x.toString();
    }
    @Path("/moving/kit/{id}")
    @GET
    public String getMovingOfKit(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	MovingOfKit x=ds.getMovingOfKit(Integer.parseInt(id));
    	if(x==null)
    		return "-1";
    	else
    		return x.toString();
    
    }
    
    @Path("/author/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeAuthor (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeAutor(Integer.parseInt(id));
    
    }
    
    @Path("/exhibit/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeExhibit (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeExhibit(Integer.parseInt(id));
    }
   
    @Path("/fund/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeFund (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeFund(Integer.parseInt(id));
    }
    @Path("/kit/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeKit (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeKit(Integer.parseInt(id));
    
    }
    @Path("/moving/exhibit/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeMovingOfExhibit (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeMovingOfExhibit(Integer.parseInt(id));
        }
    @Path("/moving/kit/remove")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void removeMovingOfKit (@FormParam("id") String id)
    {
    	DataService ds=new DataServiceImpl();
    	ds.removeMovingOfKit(Integer.parseInt(id));
    
    }
    
    @Path("/exhibit/update")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String updateExhibit (@FormParam("eId") String eId,@FormParam("ename") String ename,@FormParam("datey") String datey, @FormParam("autId") String autId,@FormParam("respName") String respName)
    {
    	DataService ds=new DataServiceImpl();
    	Exhibit e=ds.getExhibit(Integer.parseInt(eId));
    	e.setAuthorId(Integer.parseInt(autId));
    	e.setCreateDate(datey);
    	e.setExhibitName(ename);
    	e.setRespName(respName);
    	ds.updateExhibit(e);
    	return ename;	
    }

    @Path("/kit/update")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String updateKit (@FormParam("kId") String kId,@FormParam("kname") String kname,@FormParam("fundId") String fundId)
    {
    	DataService ds=new DataServiceImpl();
    	Kit kt=ds.getKit(Integer.parseInt(kId));;
    	kt.setFundId(Integer.parseInt(fundId));
    	kt.setKitName(kname);
    	ds.updateKit(kt);
    	return kname;	
    }
    @Path("/fund/update")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String updateFund (@FormParam("fId") String fId, @FormParam("fname") String fname)
    {
    	DataService ds=new DataServiceImpl();
    	Fund f=ds.getFund(Integer.parseInt(fId));
    	f.setFundName(fname);
    	ds.updateFund(f);
    	return fname;	
    }
    /*
    @Path("/kit/location")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    public String getKitLocation(@FormParam("kId") String kId,@FormParam("datey") String datey,@FormParam("datem") String datem,@FormParam("dated") String dated) {
    	DataService ds=new DataServiceImpl();
    	Date d=new Date(0);
    	d=Date.valueOf(datey.concat("-").concat(datem).concat("-").concat(dated));
    	ExpoInfo ei=ds.getLocationOfKit(Integer.parseInt(kId), d);
    	if(ei==null)
    		return "-1";
    	else
    		return ei.toString();
    
    }
    @Path("/exhibit/location")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    public String getExibitLocation(@FormParam("eId") String eId,@FormParam("datey") String datey,@FormParam("datem") String datem,@FormParam("dated") String dated) {
    	DataService ds=new DataServiceImpl();
    	Date d=new Date(0);
    	d=Date.valueOf(datey.concat("-").concat(datem).concat("-").concat(dated));
    	ExpoInfo ei=ds.getLocationOfKit(Integer.parseInt(eId), d);
    	if(ei==null)
    		return "-1";
    	else
    		return ei.toString();
    
    }
    */
    @Path("/exhibit")
    @GET
    public String getExhibits() {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Exhibit> al=ds.getExhibits();
    	for(Exhibit e:al)
    	{
    		Kit kt=ds.getKit(e.getKitId());
    		Author a=ds.getAuthor(e.getAuthorId());
    		rs=rs.concat(e.toString().concat(kt.toString()).concat(a.toString()));
    	}
    	return rs;
    	
    }
    @Path("/author")
    @GET
    public String getAuthors() {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Author> al=ds.getAuthors();
    	for(Author e:al)
    	{
    		rs=rs.concat(e.toString());
    	}
    	return rs;
    	
    }
    @Path("/kit")
    @GET
    public String getKits() {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Kit> al=ds.getKits();
    	for(Kit e:al)
    	{
    		Fund f=ds.getFund(e.getFundId());
    		rs=rs.concat(e.toString().concat(f.toString()));
    	}
    	return rs;
    	
    }
    @Path("/fund")
    @GET
    public String getFunds() {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Fund> al=ds.getFunds();
    	for(Fund e:al)
    	{
    		rs=rs.concat(e.toString());
    	}
    	return rs;
    	
    }
    @Path("/fund/{id}/kits")
    @GET
    public String getKitsFromFunds(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Kit> al=ds.getKitsFromFund(Integer.parseInt(id));
    	for(Kit e:al)
    	{
    		Fund f=ds.getFund(e.getFundId());
    		rs=rs.concat(e.toString().concat(f.toString()));
    	}
    	return rs;
    	
    }
    @Path("/kit/{id}/exhibits")
    @GET
    public String getExhibitsFromKits(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Exhibit> al=ds.getExhibitsFromKit(Integer.parseInt(id));
    	for(Exhibit e:al)
    	{
    		Kit kt=ds.getKit(e.getKitId());
    		Author a=ds.getAuthor(e.getAuthorId());
    		rs=rs.concat(e.toString().concat(kt.toString()).concat(a.toString()));
    	}
    	return rs;
    	
    }
    @Path("/author/{id}/exhibits")
    @GET
    public String getExhibitsByAuthor(@PathParam("id") String id) {
    	DataService ds=new DataServiceImpl();
    	String rs=new String("");
    	ArrayList<Exhibit> al=ds.getExhibitsByAut(Integer.parseInt(id));
    	for(Exhibit e:al)
    	{
    		Kit kt=ds.getKit(e.getKitId());
    		Author a=ds.getAuthor(e.getAuthorId());
    		rs=rs.concat(e.toString().concat(kt.toString()).concat(a.toString()));
    	}
    	return rs;
    	
    }
    

}