package com.wangle.happysing.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by wangle on 1/13/18.
 */

@Entity
public final class ChineseFont {
    @Id
    private long id;
    private String value;
    private String spell;

    @Generated(hash = 414291007)
    public ChineseFont(long id, String value, String spell) {
        this.id = id;
        this.value = value;
        this.spell = spell;
    }

    @Generated(hash = 388591294)
    public ChineseFont() {
    }

    public ChineseFont(String value, String spell) {
        this.value = value;
        this.spell = spell;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
}
