package com.example.demo.Service

import com.example.demo.Models.User
import com.example.demo.Repositories.UserRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun getUsers():List<User> =userRepository.findAll()

    fun getUser(id:String): User?{
        return userRepository.findOneById(ObjectId(id))
    }

    fun createUser(user: User): User?{
        var oneUser:User?=null
            if(user.validate()){
                oneUser=userRepository.save(user)
            }
            return oneUser
    }

    fun findByClub(clubId:String):List<User>{
        var users:List<User> = userRepository.findAll()
        return users.filter { u-> u.clubId.equals(clubId) }
    }

    fun deleteUser(userId:String): Boolean?{
        val user= userRepository.findOneById(ObjectId(userId))
        if(userRepository.delete(user)!=null) return true;

        return false;
    }

    fun findByCi(ci:String):User?{
        val users=userRepository.findAll()
        val user=users.find { u-> u.ci==ci }
        if(user!=null) return user;
        return null;
    }

    fun updateUser(user:User):User?{
        val userAux=findByCi(user.ci);
        userAux?.setMontly(user.countMontly);
        if(userAux!=null) return userRepository.save(userAux);
        return null;
    }

}