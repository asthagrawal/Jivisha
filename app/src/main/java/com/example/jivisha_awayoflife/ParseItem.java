package com.example.jivisha_awayoflife;
public class ParseItem {


    private String title;
    private String title2;
    private String imgUrl;




    public ParseItem(String imgUrl,String title, String title2) {

        this.title = title;
        this.title2=title2;
        this.imgUrl=imgUrl;

    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }




}
