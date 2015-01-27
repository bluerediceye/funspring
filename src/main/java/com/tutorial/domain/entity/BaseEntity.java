package com.tutorial.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tutorial.persistence.EntityLifecycleListener;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mli on 25/01/15.
 */
@EntityListeners(value = EntityLifecycleListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "CREATION_DATE", nullable = false)
    private DateTime creationDate;

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
}
