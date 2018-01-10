package com.hm.peopledata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hm.peopledata.Dao.ErrorDao;
import com.hm.peopledata.Entity.Error;

import java.util.Collection;

@Service
public class ErrorService {

    @Autowired
    @Qualifier("postgress")
    private ErrorDao errorDao;

    public Collection<Error> getAllErrors(){
        return this.errorDao.getAllErrors();
    }

    public Collection<Error> getErrorByCountry(String country){
    	return this.errorDao.getErrorByCountry(country);
    }
    
    public Error getErrorByMessageId(String messageid){
        return this.errorDao.getErrorByMessageId(messageid);
    }


    public void removeErrorByMessageId(String messageid) {
        this.errorDao.removeErrorByMessageId(messageid);
    }

    public void updateError(Error error){
        this.errorDao.updateError(error);
    }

    public void insertError(Error error) {
        this.errorDao.insertErrorToDb(error);
    }
}
