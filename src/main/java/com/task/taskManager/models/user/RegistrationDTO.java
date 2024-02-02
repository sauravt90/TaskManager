package com.task.taskManager.models.user;


public class RegistrationDTO {
    private String userName;
    private String password;


    public RegistrationDTO(){
        super();
    }



    public RegistrationDTO(String userName, String password){
        this.password = password;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

