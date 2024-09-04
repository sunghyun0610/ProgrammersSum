package com.grepp.day0904.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

//이 자바파일이 그대로 데이터베이스 테이블인거임! 즉 jpa에서는 디비 테이블 안말들고 자바 클래스만 생성해도 자동으로 테이블이 만들어짐.
@Entity(name = "board_tb")//얘랑 매칭되는 테이블 이름 적어주기
public class BoardEntity {
    @Id//primary ket로 설정할 칼럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    @CreationTimestamp
    private String regDate;

    public long getNo() {
        return no;
    }

//    public void setNo(int no) {
//        this.no = no;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "no=" + no +
                ", titler='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", readCount=" + readCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
