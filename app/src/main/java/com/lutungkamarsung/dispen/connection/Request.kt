package com.lutungkamarsung.dispen.connection

import android.content.Context
import android.util.Log
import com.lutungkamarsung.dispen.model.Classes
import com.lutungkamarsung.dispen.model.GenericModel
import com.lutungkamarsung.dispen.model.PermissionModel
import com.lutungkamarsung.dispen.model.SubClass
import okhttp3.MultipartBody

import java.lang.Exception

object Request{
    suspend fun submitPermission(context:Context, permission:PermissionModel): GenericModel {
        val api = RetroConfig.getApiServices(context)
        val request = api.permissionInsert(permission.title!!, permission.days!!, permission.description!!, 2)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            GenericModel()
        }
    }

    suspend fun submitSick(context:Context, permission:PermissionModel): GenericModel {
        val api = RetroConfig.getApiServices(context)
        val request = api.sickInsert(permission.title!!, permission.days!!, permission.description!!, permission.img!!, 1)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            GenericModel()
        }
    }

    suspend fun submitDispentation(context:Context, permission:PermissionModel): GenericModel {
        val api = RetroConfig.getApiServices(context)
        val request = api.dispenInsert(permission.title!!, permission.startHour!!, permission.endHour!!, permission.description!!, 3)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            GenericModel()
        }
    }

    suspend fun uploadImg(context:Context, multipartBody: MultipartBody.Part):GenericModel{
        val api = RetroConfig.getApiServices(context)
        val request = api.uploadImg(multipartBody)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            GenericModel()
        }
    }

    suspend fun getPermissionMine(context:Context):ArrayList<PermissionModel>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getPermissionMe()
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun getPermissionMyChild(context:Context):ArrayList<PermissionModel>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getPermissionMyChild()
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun getClasses(context:Context):ArrayList<Classes>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getClasses(1)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun getSubClasses(context:Context, id:Int):ArrayList<SubClass>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getSubClasses(id)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun getAbsentSubClass(context:Context, id:Int):ArrayList<PermissionModel>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getAbsentSubClass(id)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun getDispenSubClass(context:Context):ArrayList<PermissionModel>{
        val api = RetroConfig.getApiServices(context)
        val request = api.getDispenSubClass()
        return try {
            return request.await().body()!![0].permission
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            ArrayList()
        }
    }

    suspend fun acceptPermission(context:Context, id:Int):GenericModel{
        val api = RetroConfig.getApiServices(context)
        val request = api.acceptPermission(id)
        return try {
            return request.await().body()!!
        }catch (e: Exception){
            Log.e("TAG", "It doesnt work" + e.message)
            GenericModel()
        }
    }
}