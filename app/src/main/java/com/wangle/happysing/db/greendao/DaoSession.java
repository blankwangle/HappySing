package com.wangle.happysing.db.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wangle.happysing.db.SingInfoBean;
import com.wangle.happysing.db.ChineseFont;

import com.wangle.happysing.db.greendao.SingInfoBeanDao;
import com.wangle.happysing.db.greendao.ChineseFontDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig singInfoBeanDaoConfig;
    private final DaoConfig chineseFontDaoConfig;

    private final SingInfoBeanDao singInfoBeanDao;
    private final ChineseFontDao chineseFontDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        singInfoBeanDaoConfig = daoConfigMap.get(SingInfoBeanDao.class).clone();
        singInfoBeanDaoConfig.initIdentityScope(type);

        chineseFontDaoConfig = daoConfigMap.get(ChineseFontDao.class).clone();
        chineseFontDaoConfig.initIdentityScope(type);

        singInfoBeanDao = new SingInfoBeanDao(singInfoBeanDaoConfig, this);
        chineseFontDao = new ChineseFontDao(chineseFontDaoConfig, this);

        registerDao(SingInfoBean.class, singInfoBeanDao);
        registerDao(ChineseFont.class, chineseFontDao);
    }
    
    public void clear() {
        singInfoBeanDaoConfig.clearIdentityScope();
        chineseFontDaoConfig.clearIdentityScope();
    }

    public SingInfoBeanDao getSingInfoBeanDao() {
        return singInfoBeanDao;
    }

    public ChineseFontDao getChineseFontDao() {
        return chineseFontDao;
    }

}
