package com.bitmascot.controller
import com.bitmascot.services.UserService

class UserController {

    UserService userService;
    def index() {
        def response = userService.GetAll(params);
        [userList:response.list,total:response.count]
    }

    def details(Integer id){
        def response = userService.GetById(id);
        if(!response){
            redirect(controller:"user",action:"index");
        }
        else{
            [user:response]
        }
    }

    def create(){
        [user:flash.redirectParams]
    }

    def save(){
        def response = userService.Save(params);
        if(!response.isSuccess){
            flash.redirectParams = response.model;
            redirect(controller:"user",action:"create");
        }
        else{
            redirect(controller:"user",action:"index");
        }
    }

    def edit(Integer id){
        if(flash.redirectParams){
            [user: flash.redirectParams]
        }
        else{
            def response = userService.GetById(id);
            if(!response){
                redirect(controller:"user",action:"index");
            }
            else{
                [user:response]
            }
        }
    }

    def update(){
        def response = userService.GetById(params.id);
        if(!response){
            redirect(controller: "user",action:"index")
        }
        else{
            response = userService.Update(response,params);
            if(!response.isSuccess){
                flash.redirecParams = response.model;
                redirect(controller:"user",action:"edit");
            }
            else{
                redirect(controller:"user",action:"index");
            }
        }
    }

    def delete(Integer id){
        def response = userService.GetById(id);
        if(!response){
            redirect(controller: "user",action:"index");
        }
        else{
            response = userService.Delete(response);
            redirect(controller: "user",action:"index");
        }
    }
}
