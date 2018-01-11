package com.wangle.happysing.db.greendao

import android.content.Context
import android.database.sqlite.SQLiteDatabase

/**
 * Created by wangle on 17-12-10.
 */
class GreenDaoManager private constructor(mContext : Context){

    private val DB_NAME = "happies_song"
    private var mDevOpenHelp : DaoMaster.DevOpenHelper? = null
    private var mDaoMaster: DaoMaster? = null
    private var mDaoSession: DaoSession? = null

    init {
        mDevOpenHelp = DaoMaster.DevOpenHelper(mContext, DB_NAME)
        getDaoMaster(mContext)
        getDaoSession(mContext)
    }

    companion object {
        @Volatile
        var instance: GreenDaoManager? = null

        fun getInstance(mContext: Context) : GreenDaoManager? {
            if(instance == null){
                synchronized(GreenDaoManager::class) {
                    if (instance == null){
                        instance = GreenDaoManager(mContext)
                    }
                }
            }

            return instance
        }
    }

    fun getWriteableDatabase(mContext: Context) : SQLiteDatabase?{
        if(mDevOpenHelp == null){
            getInstance(mContext)
        }

        return mDevOpenHelp?.writableDatabase
    }

    fun getReadableDatabase(mContext: Context) : SQLiteDatabase?{
        if(mDevOpenHelp == null){
            getInstance(mContext)
        }

        return mDevOpenHelp?.readableDatabase
    }

    fun getDaoMaster(mContext: Context) : DaoMaster?{
        if(mDaoMaster == null){
            synchronized(DaoMaster :: class.java){
                mDaoMaster = DaoMaster(getWriteableDatabase(mContext))
            }
        }

        return mDaoMaster
    }

    fun getDaoSession(mContext: Context) : DaoSession?{
        if(mDaoSession == null) {
            synchronized(DaoSession :: class.java){
                mDaoSession = getDaoMaster(mContext)?.newSession()
            }
        }

        return mDaoSession
    }
}
