package com.example.profiler.mock;

public class Post {
  private long id;
  private String title;
  private String content;

  public Post(long id, String title, String content) {
    this.setId(id);
    this.setTitle(title);
    this.setContent(content);
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
