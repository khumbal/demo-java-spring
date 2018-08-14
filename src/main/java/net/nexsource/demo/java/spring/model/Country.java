package net.nexsource.demo.java.spring.model;

import net.nexsource.demo.java.spring.model.base.BaseEntity;

public class Country extends BaseEntity {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
