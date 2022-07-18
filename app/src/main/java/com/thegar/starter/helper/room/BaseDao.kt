package com.thegar.starter.helper.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<Entity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(entity: Entity): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertOrAbort(entity: Entity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(entity: Entity, vararg entities: List<Entity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertOrAbort(entity: Entity, vararg entities: List<Entity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplaceBulk(entities: List<Entity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertOrAbortBulk(entities: List<Entity>): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrReplace(entity: Entity)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateOrAbort(entity: Entity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrReplaceBulk(entities: List<Entity>)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateOrAbortBulk(entities: List<Entity>)

    @Delete
    fun delete(vararg entities: Entity)

    @Delete
    fun deleteBulk(entities: List<Entity>)
}