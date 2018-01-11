package com.wangle.happysing.db.utils

/**
 * Created by wangle on 17-12-10.
 */
interface BaseDbUtils<T> {
    fun insert(clazz: Class<T>) : Boolean

    fun delete(clazz: Class<T>) : Boolean

    fun query()
}