package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor //기본생성자 추가 어노테이션
@ToString
@Entity //1. 엔티티 선언
@Getter
public class Article {
    @Id //엔티티의 대푯값 지정 Id, jakarta.persistence를 클릭한다.
    @GeneratedValue
    private Long id;
    @Column // 열추가, title필드 선언, DB테이블의 title열과 연결됨
    private String title;
    @Column
    private String content;


//    public Long getId() { //주의! LONG
//    }
}
