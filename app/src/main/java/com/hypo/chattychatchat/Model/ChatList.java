package com.hypo.chattychatchat.Model;

public class ChatList {
    private String userName;
    private int imageResource;

    public ChatList(String userName, int imageResource) {
        this.userName = userName;
        this.imageResource = imageResource;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
