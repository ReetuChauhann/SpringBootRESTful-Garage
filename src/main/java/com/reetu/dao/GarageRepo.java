package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Garage;

@Repository
public class GarageRepo {
	             @Autowired
	             JdbcTemplate jdbctemplate;
	             
	             //to add
	             public String add(Garage g, MultipartFile image) {
	            	 try {
						String query="insert into ginfo values(?,?,?,?)";
						int x=jdbctemplate.update(query, new Object[] {g.getGid(), g.getName(), g.getPlace(), image.getInputStream()});
						if(x!=0) {
							return "success";
						}else {
							return "failed";
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return "failed";
					}
	             }
	             
	             //to get all garage
	             public List<Garage> getall(){
	            	 class DataMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Garage g=new Garage();
							g.setGid(rs.getInt("gid"));
							g.setName(rs.getString("name"));
							g.setPlace(rs.getNString("place"));
							
							return g;
						}
	            		 
	            	 }
	            	 try {
						final String query="select * from ginfo";
						List<Garage> g=jdbctemplate.query(query, new DataMapper());
						return g;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
	             }
	             
	             //get garage by id

	             public Garage getbyid(int gid) {
	            	 class DataMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Garage g=new Garage();
							g.setGid(rs.getInt("gid"));
							g.setName(rs.getNString("name"));
							g.setPlace(rs.getString("place"));
							return g;
						}
	            		 
	            	 }
	            	 try {
						final String query="select * from ginfo where gid=?";
						Garage g=(Garage)jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {gid});
						return g;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
	             }
	             
	             //get image of garage
	             
	             public byte[] getphoto(int gid) {
	            	 class DataMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							return rs.getBytes("image");
						}
	            		 
	            	 }
	            	 try {
						final String query="select image from ginfo where gid=?";
						byte[] b=(byte[]) jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {gid});
						return b;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
	             }
	             
	             //delete on behalf of id
	             public String delete(int gid) {
	            	 try {
						String query="delete from ginfo where gid=?";
						int x=jdbctemplate.update(query, new Object[] {gid});
						if(x!=0) {
							return "success";
						}else {
							return "failed";
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return "failed";
					}
	             }
	             
	             //get add gid only
	             public List<Integer> getallids(){
	            	 class DataMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							return rs.getInt("gid");
						}
	            		 
	            	 }
	            	 try {
						String Query="select gid from ginfo";
						List<Integer> ids=jdbctemplate.query(Query, new DataMapper());
						return ids;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
	             }
	             
	             //update image by gid
	             public String updateimage(int gid, MultipartFile image) {
	            	 try {
						   String query="update ginfo set image=? where gid=?";
						   int x=jdbctemplate.update(query, new Object[] {gid});
						   if(x!=0) {
							   return "success";
						   }else {
							   return "failed";
						   }
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return "failed";
					}
	             }
	             
	             //update garage
	             public String updategarage(Garage g) {
	            	 try {
						String query="update ginfo set name=?, place=? where gid=?";
						int x=jdbctemplate.update(query, new Object[] {g.getName(),g.getPlace(), g.getGid()});
						if(x!=0) {
							return "success";
						}else {
							return "failed";
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return "failed";
					}
	            	 
	             }

}
