package trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerDao {

	static Connection con=null;
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver register");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/DATABASENAME","USERNAME", "PASSWORD");
			System.out.println("connected succesfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void saveTrainer(Trainer t) {
		String query="insert into trainer values(?,?,?)";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1,t.getId());
			preparedStatement.setString(2, t.getName());
			preparedStatement.setString(3, t.getSub());
			
			preparedStatement.executeUpdate();
			System.out.println("data entered succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Trainer findTrainerById(int id) {
		String query="select * from trainer where id=?";
		Trainer t=null;
		
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet res=preparedStatement.executeQuery();
			boolean n= res.next();
			if(n)
			{
				int tid=res.getInt(1);
				String tname=res.getString(2);
				String tsub=res.getString(3);
				t=new Trainer(tid, tname, tsub);
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	public static int updateName(int id,String name)
	{
		String query="update trainer set name=? where id=?";
		int rowsmodified=0;
		
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			rowsmodified=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsmodified;
		
		
	}
	public static void allData() {
		String query="select * from trainer";
		
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				System.out.println("+-----------------------------+");
				System.out.print("|"+rs.getInt(1) +"|\t");
				System.out.print("|"+rs.getString(2)+"|\t");
				System.out.println("|"+rs.getString(3)+"\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void delete(int id) {
		String query="delete from trainer where id=?";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void findTrainerByNmae(String name) {
		String query="select * from trainer where name=?";
		try {
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				System.out.println("+-----------------------------+");
				System.out.print("|"+rs.getInt(1) +"|\t");
				System.out.print("|"+rs.getString(2)+"|\t");
				System.out.println("|"+rs.getString(3)+"\t");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
