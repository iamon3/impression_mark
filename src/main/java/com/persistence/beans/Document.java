package com.persistence.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlRootElement(name = "Document")
@XmlType(propOrder = {"documentId", "content", "title", "author", "topic", "isMarked"})// Output order
        public class Document {

    private final static String COMMA = ",";

    private String documentId;
    private String content;   // Book or Journal
    private String title;
    private String author;
    private String topic;  // Only for Book
    private String isMarked;

    @XmlElement
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

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

    @XmlElement
    public String getIsMarked() {
        return isMarked;
    }

    public void setIsMarked(String marked) {
        isMarked = marked;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("documentId : " + this.documentId + COMMA);
        sb.append("Content : " + this.content + COMMA);
        sb.append("Title : " + this.title + COMMA);
        sb.append("Author : " + this.author + COMMA);
        sb.append("Topic : " + this.topic + COMMA);
        sb.append("isMarked : " + this.isMarked);
        return sb.toString();
    }
}
