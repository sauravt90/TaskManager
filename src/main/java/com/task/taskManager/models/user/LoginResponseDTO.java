package com.task.taskManager.models.user;

public class LoginResponseDTO {

    private ApplicationUser applicationUser;
    private String jwt;

    public  LoginResponseDTO(){
    }


    public LoginResponseDTO(ApplicationUser applicationUser,String jwt){
        this.applicationUser = applicationUser;
        this.jwt = jwt;
    }


    public ApplicationUser getApplicationUser(){
        return  this.applicationUser;
    }


    public void setApplicationUser(ApplicationUser applicationUser){
        this.applicationUser = applicationUser;
    }



    public String getJwt(){
         return  jwt;
    }
    public void  setJwt(String jwt){
        this.jwt = jwt;
    }





}
