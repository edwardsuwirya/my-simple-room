package com.enigmacamp.mysimpleroom

class CustomerRepository(private val customerDao: CustomerDao) {
    suspend fun getCustomers() = customerDao.getAll()
    suspend fun registerNewCustomer(customer: Customer) = customerDao.insert(customer)
    suspend fun getCustomer(id: Int) = customerDao.getCustomerById(id)
    suspend fun unregisterCustomer(customer: Customer) = customerDao.delete(customer)
}