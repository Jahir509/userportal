package com.bitmascot.model

import com.bitmascot.userportal.GlobalConfig

class User {

    Integer id
    String name
    String email
    String password
    String userType = GlobalConfig.USER_TYPE.REGULAR_USER
    Boolean isActive = true


    static constraints = {
        email(email:true,nullable:false,blank:false)
        password(blank: false)
        name(nullable: false)
    }
    def beforeInsert(){
        this.password = this.password.encodeAsMD5()
    }
    def beforeUpdate(){
        this.password = this.password.encodeAsMD5()
    }
}
