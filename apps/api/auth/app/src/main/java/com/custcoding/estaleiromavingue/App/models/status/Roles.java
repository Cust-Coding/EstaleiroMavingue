package com.custcoding.estaleiromavingue.App.models.status;

public enum Roles {
    CUSTOMER("customer"),
    OWNER("owner"),
    STUFF("stuff"),
    ADMIN("admin"),
    CUSTOMER_WATER("customer_water");

    private String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
    


}
