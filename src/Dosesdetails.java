
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dosesdetails {

	public static boolean checkbook(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from doses_taken where aadhar_no=?");
			
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertbook(String aadhar_no,String first_dose,String second_dose,String booster_dose, String type){
		int status=0;
		int status1=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into doses_taken(aadhar_no,first_dose,second_dose,booster_dose) values(?,?,?,?)");
			PreparedStatement ps1=con.prepareStatement("insert into vaccine_type(aadhar_no,type) values(?,?)");
			//String s1 = Integer.toString(first_dose);
			//String s2 = Integer.toString(second_dose);
			//String s3 = Integer.toString(booster_dose);
			ps.setString(1,aadhar_no);
			ps.setString(2,first_dose);
			ps.setString(3,second_dose);
			ps.setString(4,booster_dose);
			ps1.setString(1,aadhar_no);
			ps1.setString(2,type);
			status=ps.executeUpdate();
			status1 = ps1.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status & status1;
	}
	public static int deletebook(String id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from book where bookid=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
