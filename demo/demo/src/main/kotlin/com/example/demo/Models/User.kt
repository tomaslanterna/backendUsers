package com.example.demo.Models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
        @Id
        val id:ObjectId=ObjectId.get(),
        val name:String,
        val yearsOld:Int,
        val ci:String,
        var countMontly:Int,
        val clubId:String) {

        fun validate():Boolean{
                return this.name!=null
                        &&  this.yearsOld>0
                        && this.ci!=null
                        && this.countMontly>=0
                        && clubId!=null
        }

        fun setMontly(cant:Int){
                this.countMontly=cant;
        }

}