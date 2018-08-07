package com.mosalah.simpleappworkjson;


public class model {
     private String title, description, time,image_url, website_url;




    public String getImage_url() {
        return image_url;
    }

     void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

     void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public model(String title, String time, String description, String image_url, String  website_url)
    {
    setDescription(description);
    setImage_url(image_url);
    setTime(time);
    setWebsite_url(website_url);
    setTitle(title);
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}