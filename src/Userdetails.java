
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userdetails {

	public static boolean checkbook(String sname){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user_details where sname=?");
			ps.setString(1,sname);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertbook(String sname,long phone_no,long aadhar_no,String address, int age){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user_details(sname,phone_no,aadhar_no,address,age) values(?,?,?,?,?)");
			ps.setString(1,sname);
			String s1= Long.toString(phone_no);
			ps.setString(2,s1);
			String s2= Long.toString(aadhar_no);
			ps.setString(3,s2);
			ps.setString(4, address);
			String s3= Integer.toString(age);
			ps.setString(5,s3);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletebook(long id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from user_details where aadhar_no=?");
			String s1=Long.toString(id);
			ps.setString(1,s1);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
