package com.enigmacamp.mysimpleroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var customerRepository: CustomerRepository
    lateinit var customerDao: CustomerDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customerDao = AppDatabase.getDatabase(this).customerDao()
        customerRepository = CustomerRepository(customerDao)

        CoroutineScope(Dispatchers.IO).launch {
            customerRepository.registerNewCustomer(Customer(name = "Egi", address1 = "Kandang Gorila", address2 = "Ragunan"))
            val customerList = customerRepository.getCustomers()
            Log.d("Room", customerList.toString())
            val customer = customerRepository.getCustomer(1)
            Log.d("Room", customer.toString())
        }
    }
}