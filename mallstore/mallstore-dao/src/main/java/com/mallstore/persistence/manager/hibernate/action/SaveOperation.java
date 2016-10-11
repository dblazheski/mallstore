package com.mallstore.persistence.manager.hibernate.action;

import org.hibernate.Session;

/**
 * Created by DeKi on 1/16/2016.
 */
public class SaveOperation extends Operation {


    public SaveOperation(Session session) {
        super(session);
    }

    @Override
    public void executeAction(Object object) {
        session.save(object);
    }
}
