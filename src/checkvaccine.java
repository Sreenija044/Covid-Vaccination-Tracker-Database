import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class checkvaccine {
	public static boolean checklogin(String id){
		boolean allow=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from vaccine_type where aadhar_no =?");
			ps.setString(1,id);
		    ResultSet rs=ps.executeQuery();
			allow=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return allow;
	}
	public static boolean NumSlots(String id){
		boolean state=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from vaccine_type where aadhar_no = ?");
			ps.setString(1,id);
		    ResultSet rs=ps.executeQuery();
			state=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return state;
	}
	
}