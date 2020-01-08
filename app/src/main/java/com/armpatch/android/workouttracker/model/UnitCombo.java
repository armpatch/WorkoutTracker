package com.armpatch.android.workouttracker.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "unit_combo_table")
public class UnitCombo {

    @PrimaryKey
    @NonNull
    private String name;

    private String unit1;
    private String unit2;
    private String unit3;

    public UnitCombo(String name, String unit1, String unit2, String unit3) {
        this.name = name;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.unit3 = unit3;
    }

    public UnitCombo(String name, String unit1, String unit2) {
        this(name, unit1, unit2, null);
    }

    public UnitCombo(String name, String unit1) {
        this(name, unit1, null, null);
    }

    public List<String> getUnits() {
        List<String> units = new ArrayList<>();

        units.add(unit1);
        if (unit2 != null) units.add(unit2);
        if (unit3 != null) units.add(unit3);

        return units;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
