import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import com.mysql.cj.xdevapi.Statement;
public class checkdoses {
	public static boolean checklogin(String id){
		boolean allow=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from doses_taken where aadhar_no =?");
			ps.setString(1,id);
		    ResultSet rs=ps.executeQuery();
			allow=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return allow;
	}
	/*public static boolean checkpassword(String id,String pass){
		boolean state=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Slots where center_code =? and Area=?");
			ps.setString(1,id);
			ps.setString(2,pass);
		    ResultSet rs=ps.executeQuery();
			state=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return state;
	}*/
	public static int NumSlots(String id){
		//boolean state=false;
		int sum = 0;
		try{
			//Connection con=DB.getConnection();
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","srinija");
			//PreparedStatement ps=con.prepareStatement("select first_dose+second_dose+booster_dose from doses_taken where aadhar_no = ?");
			Statement s1= con.createStatement();
			//ps.setString(1,id);
			//ps.setString(2,pass);
			//String str = rs
		    ResultSet s=s1.executeQuery("select first_dose,booster_dose,second_dose from doses_taken where aadhar_no = ?");
		    //String str = rs.getString("time");
		    //num = Integer.parseInt("time");
		    //int sum=0;
		    //while(s.next()) {
		    	sum=s.getInt("first_dose")+s.getInt("second_dose")+s.getInt("booster_dose");
		    //}
			//state=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return sum;
	}
	
}