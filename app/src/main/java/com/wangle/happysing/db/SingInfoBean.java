package com.wangle.happysing.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wangle on 17-12-7.
 */
@Entity
public class SingInfoBean {
    @Id
    private long id;

    private String title;

    private String content;

    private String wordFilePath;

    @Generated(hash = 1771925656)
    public SingInfoBean(long id, String title, String content,
            String wordFilePath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.wordFilePath = wordFilePath;
    }

    @Generated(hash = 1163022187)
    public SingInfoBean() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWordFilePath() {
        return this.wordFilePath;
    }

    public void setWordFilePath(String wordFilePath) {
        this.wordFilePath = wordFilePath;
    }


}
