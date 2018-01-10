package com.hm.peopledata.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hm.peopledata.Entity.Error;

@Repository("postgress")
public class PostgressErrorDaoImpl implements ErrorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class ErrorRowMapper implements RowMapper<Error>{
		@Override
		public Error mapRow(ResultSet resultSet, int i) throws SQLException {
			// TODO Auto-generated method stub
			Error error = new Error();
			error.setMessageid(resultSet.getString("messageid"));
			error.setGcid(resultSet.getString("gcid"));
			error.setCountry(resultSet.getString("country"));
			error.setXmlMess(resultSet.getString("xmlmess"));
			error.setErrortext(resultSet.getString("errortext"));
			return error;
		}
	}

	@Override
	public Collection<Error> getAllErrors() {
		// TODO Auto-generated method stub
		// SELECT column1, column2, FROM table_name; 
	
		final String sql = "SELECT messageid, gcid, country, xmlmess, errortext from pderrors";
		List<Error> errors = jdbcTemplate.query(sql, new ErrorRowMapper());
		return errors;
	}

	@Override
	public Error getErrorByMessageId(String messageid) {
		// TODO Auto-generated method stub
		final String sql = "SELECT messageid, gcid, country, xmlmess, errortext from pderrors where messageid = ?";
		Error error = jdbcTemplate.queryForObject(sql, new ErrorRowMapper(), messageid);
		return error;
	}
	
	@Override
	public Collection<Error> getErrorByCountry(String country) {
		// TODO Auto-generated method stub
		final String sql = "SELECT messageid, gcid, country, xmlmess, errortext from pderrors where country = ?";
		List<Error> errors = jdbcTemplate.query(sql, new ErrorRowMapper(), country);
		return errors;
	}

	@Override
	public void removeErrorByMessageId(String messageid) {
		// TODO Auto-generated method stub
		//DELETE FROM table_name
		//WHERE some_column = some_value
		final String sql = "DELETE FROM pderrors where messageid = ?";
		jdbcTemplate.update(sql, messageid);
	}

	@Override
	public void updateError(Error error) {
		// TODO Auto-generated method stub
		//UPDATE table_name
		//SET column1=value, column2=value2,...
		//WHERE some_column=some_value
		final String sql = "UPDATE pderrors SET country = ?, xmlmess = ?, gcid = ?, errortext = ? WHERE messageid = ?";
		final String messageid = error.getMessageid();
		final String country = error.getCountry();
		final String xmlmess = error.getXmlMess();
		final String gcid = error.getGcid();
		final String errortext = error.getErrortext();
		jdbcTemplate.update(sql, new Object[]{country, xmlmess, gcid, errortext, messageid});
		
	}

	@Override
	public void insertErrorToDb(Error error) {
		// TODO Auto-generated method stub
		// INSERT INTO table_name (column1, column2, column3, ...)
		// VALUES (value1, value2, value3,...)
		final String sql = "INSERT into pderrors (country, messageid, xmlmess, gcid, errortext) VALUES (?, ?, ?, ? ,?)";
		final String country = error.getCountry();
		final String messageid = error.getMessageid();
		final String gcid = error.getGcid();
		final String xmlmess = error.getXmlMess();
		final String errortext = error.getErrortext();
		jdbcTemplate.update(sql, new Object[]{country, messageid, xmlmess, gcid, errortext});
		
	}



}
