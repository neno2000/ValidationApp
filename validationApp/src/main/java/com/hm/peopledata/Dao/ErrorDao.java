package com.hm.peopledata.Dao;

import java.util.Collection;

import com.hm.peopledata.Entity.Error;

public interface ErrorDao {
    Collection<Error> getAllErrors();

    Error getErrorByMessageId(String messageid);
    
    Collection<Error> getErrorByCountry(String country);

    void removeErrorByMessageId(String messageid);

    void updateError(Error error);

    void insertErrorToDb(Error error);
    
}
