package com.mallstore.domain.model;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by DeKi on 3/28/2016.
 */
@Embeddable
public class EntityId implements Serializable {

    @Column(name = "id")
    private String id;

    public EntityId(String id) {
        Validate.notNull(id, "EntityId cannot be null");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EntityId entityId1 = (EntityId) o;

        return new EqualsBuilder()
                .append(id, entityId1.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EntityId{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }

    protected EntityId() {}
}
