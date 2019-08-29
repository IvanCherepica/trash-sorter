package com.trash_sorter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tanks_and_cats")
public class TanksAndCategories {
    @Id
    @Column(name = "tank_id")
    private long tank_id;

    public long getTank_id() {
        return tank_id;
    }
}
