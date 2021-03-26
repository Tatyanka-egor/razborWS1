package com.example.razborws1.common.entity;

public class User {
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String FIRST_NAME="firstName";
    public static final String LAST_NAME="lastName";//заменяем private на public

    public static User getCurrentUser() {
        if(CurrentUser!=null)
            CurrentUser=new User();
        return CurrentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }

    private static User CurrentUser;

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }

    private long token;
}
