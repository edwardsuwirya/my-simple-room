package com.enigmacamp.mysimpleroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customer")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM customer where uid=:id")
    fun getCustomerById(id: Int): Customer

    @Insert
    fun insert(customer: Customer)

    @Delete
    fun delete(customer: Customer)
}