package com.metacuberest.restdemo;
import javax.xml.bind.annotation.*;
@XmlRootElement
public class BookObject {
	private String title;
	private String writer;
	private String publisher;
	private int publishedYear;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	@Override
	public String toString() {
		return "BookObject [title=" + title + ", writer=" + writer
				+ ", publisher=" + publisher + ", publishedYear="
				+ publishedYear + "]";
	}

}
