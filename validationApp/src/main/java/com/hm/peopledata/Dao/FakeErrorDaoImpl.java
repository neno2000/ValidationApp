package com.hm.peopledata.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hm.peopledata.Entity.Error;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeErrorDaoImpl implements ErrorDao {

    private static Map<String, Error> errors;

    static {

        errors = new HashMap<String, Error>(){

            {
                put("1", new Error("1", "33", "FR", "<note><to>Error 01</to></note>", "not working 01"));
                put("2", new Error("2", "34", "UK", "<note><to>Error 02</to></note>", "not working 02"));
                put("3", new Error("3", "35", "FR", "<note><to>Error 03</to></note>", "not working 03"));
            }
        };
    }

    @Override
    public Collection<Error> getAllErrors(){
        return this.errors.values();
    }

    @Override
    public Error getErrorByMessageId(String messageid){
        return this.errors.get(messageid);
    }

    @Override
    public void removeErrorByMessageId(String messageid) {
        this.errors.remove(messageid);
    }

    @Override
    public void updateError(Error error){
        Error s = errors.get(error.getMessageid());
        s.setCountry(error.getCountry());
        s.setGcid(error.getGcid());
        s.setXmlMess(error.getXmlMess());
        s.setErrortext(error.getErrortext());
        errors.put(error.getMessageid(), error);
    }

    @Override
    public void insertErrorToDb(Error error) {
        this.errors.put(error.getMessageid(), error);
    }

	@Override
	public Collection<Error> getErrorByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}
}
