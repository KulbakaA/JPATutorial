package com.getjavajob.entity.base;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected LocalDateTime insertTime;
    protected LocalDateTime updateTime;

    protected Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    @Column(name = "INSERT_TIME", nullable = false, updatable = false)
    protected LocalDateTime getInsertTime() {
        return insertTime;
    }

    protected void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Column(name = "UPDATE_TIME", insertable = false)
    protected LocalDateTime getUpdateTime() {
        return updateTime;
    }

    protected void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
