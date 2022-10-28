package com.example.demo.Controllers

import com.example.demo.Models.User
import com.example.demo.Repositories.UserRepository
import com.example.demo.Service.UserService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(
        private val userService: UserService
) {

    @GetMapping
    fun test():String{
        val palabra:String="Hola"
        return palabra
    }

    @GetMapping("/all")
    fun getUsers():List<User>{
        try {
            return userService.getUsers()
        }catch(e:Exception){
            throw e
        }
    }


    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id:String): User?{
        try {
            return userService.getUser(id)
        }catch(e:Exception){
            throw e
        }
    }

    @GetMapping("/byCi/{ci}")
    fun getByCi(@PathVariable("ci") ci: String):User?{
        try {
            println(ci)
            return userService.findByCi(ci)
        }catch(e:Exception){
            throw e
        }
    }

    @GetMapping("/club/{clubId}")
    fun getUsersByClub(@PathVariable("clubId") clubId:String):List<User>{
        try {
            return userService.findByClub(clubId)
        }catch (e:Exception){
            throw e
        }
    }

    @PostMapping
    fun addUser(@RequestBody user: User): User?{
        try {
            return userService.createUser(user)
        }catch(e:Exception){
            throw e
        }
    }



    @DeleteMapping("/delete/{userId}")
    fun deleteUser(@PathVariable("userId") userId:String):Boolean?{
        try {
           return userService.deleteUser(userId)
        }catch (e:Exception){
            throw e
        }
    }

    @PutMapping("/update")
    fun updateUser(@RequestBody user:User):User?{
        try {
            return userService.updateUser(user)
        }catch(e:Exception){
            throw e
        }
    }


}