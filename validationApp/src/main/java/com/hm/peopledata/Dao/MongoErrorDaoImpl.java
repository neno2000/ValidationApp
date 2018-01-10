package com.hm.peopledata.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hm.peopledata.Entity.Error;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoErrorDaoImpl implements ErrorDao {


    @Override
    public Collection<Error> getAllErrors() {
        return new ArrayList<Error>(){
            {
                add(new Error("4", "36","FR", "<note><to>Error 05</to></note>", "another fail"));
            }
        };
    }

    @Override
    public Error getErrorByMessageId(String messageid) {
        return null;
    }

    @Override
    public void removeErrorByMessageId(String messageid) {

    }

    @Override
    public void updateError(Error student) {

    }

    @Override
    public void insertErrorToDb(Error student) {

    }

	@Override
	public Collection<Error> getErrorByCountry(String country) {
		// TODO Auto-generated method stub
		return null;
	}
}
