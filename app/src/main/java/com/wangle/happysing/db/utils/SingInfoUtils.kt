package com.wangle.happysing.db.utils

import android.content.Context
import com.wangle.happysing.db.SingInfoBean
import com.wangle.happysing.db.greendao.GreenDaoManager
import com.wangle.happysing.db.greendao.SingInfoBeanDao

/**
 * Created by wangle on 17-12-10.
 */
class SingInfoUtils private constructor(mContext: Context){
    var singInfoDao : SingInfoBeanDao? = null

    init {
        singInfoDao = getDataDao(mContext)
    }

    companion object {
        @Volatile
        var instance: SingInfoUtils? = null

        fun newInstance(mContext: Context) : SingInfoUtils? {
            if(instance == null){
                synchronized(SingInfoUtils::class){
                    instance = SingInfoUtils(mContext)
                }
            }

            return instance
        }
    }

    fun getDataDao(mContext: Context) : SingInfoBeanDao?{
        return GreenDaoManager.getInstance(mContext)?.getDaoSession(mContext)?.singInfoBeanDao
    }

    fun insert(data : SingInfoBean) : Boolean?{
        var count : Long? = singInfoDao?.insert(data)
        return count!! > 0
    }

    fun query() : List<SingInfoBean>? {
        return singInfoDao?.loadAll()
    }
}