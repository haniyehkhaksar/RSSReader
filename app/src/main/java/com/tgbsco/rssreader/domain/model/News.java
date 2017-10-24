package com.tgbsco.rssreader.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by h.khaksar on 10/24/2017.
 */

@Root(name = "item", strict = false)
public class News {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;


    @Element(name = "description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
