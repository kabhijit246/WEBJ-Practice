package com.assignment.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import com.assignment.beans.Student;  

public class StudentDao {  

	JdbcTemplate template;  

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	}  

	public int save(Student p){  
		String sql="insert into student(name) values('"+p.getName()+"')";
		template.update(sql);
		String s1 ="insert into address(address) values('"+p.getAddress()+"')";
		template.update(s1);
		String s2 ="insert into Pincode(pincode) values('"+p.getPincode()+"')";
		return template.update(s2);  
	} 

	public int update(Student p){  
		String sql="update student set name='"+p.getName()+"' where id="+p.getId()+"";
		template.update(sql);
		String s3 = "update address set address='"+p.getAddress()+"' where id="+p.getId()+"";
		template.update(s3);
		String s4 = "update pincode set pincode='"+p.getPincode()+"' where id="+p.getId()+"";  
		return template.update(s4);  
	} 

	public int delete(int id){  
		String sql="delete from pincode where id="+id+"";
		template.update(sql);
		String s5 ="delete from address where id="+id+"";
		template.update(s5);
		String s6 ="delete from student where id="+id+"";  
		return template.update(s6);  
	} 

	public Student getStudentById(int id){  
		String sql="SELECT s.id, s.name, a.address, p.pincode from student s INNER JOIN address a on s.id = a.id INNER JOIN pincode p on s.id = p.id where s.id = ?";  
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
	}  

	public List<Student> getStudents(){  
		return template.query("SELECT s.id, s.name, a.address, p.pincode from student s INNER JOIN address a on s.id = a.id INNER JOIN pincode p on s.id = p.id",new RowMapper<Student>(){  
			public Student mapRow(ResultSet rs, int row) throws SQLException {  
				Student s=new Student();  
				s.setId(rs.getInt(1));  
				s.setName(rs.getString(2));  
				s.setAddress(rs.getString(3));
				s.setPincode(rs.getString(4));
				return s;  
			}  
		});  
	}  
}  