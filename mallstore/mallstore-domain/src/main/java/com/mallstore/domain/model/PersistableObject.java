package com.mallstore.domain.model;

import java.io.Serializable;

/**
 * Created by DeKi on 5/2/2016.
 */
public interface PersistableObject extends Serializable {
    public EntityId getId();
}
