package com.example.demo.Repositories

import com.example.demo.Models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.lang.Nullable
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface UserRepository: MongoRepository<User,String> {


    @Nullable
    fun findOneById(id:ObjectId): User
    override fun deleteAll()
}