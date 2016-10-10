package com.mallstore.persistence.manager.hibernate.action;

/**
 * Created by DeKi on 1/16/2016.
 */
public class SaveOperation extends Operation {


    @Override
    public void executeAction(Object object) {
        session.save(object);
    }
}
