package com.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 */
@XmlRootElement(name = "Document")
public class Document {

    private final static String COMMA = ",";

    private String content;
    private String title;
    private String author;
    private String topic;

    @XmlElement
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Content : " + this.content + COMMA);
        sb.append("Title : " + this.title + COMMA);
        sb.append("Author : " + this.author);
        sb.append("Topic : " + this.topic);
        return sb.toString();
    }
}
