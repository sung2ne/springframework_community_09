package com.test.community.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;        // 순번
	private String title;   // 제목
	private String content; // 내용
	private String passwd;	// 비밀번호
	private Date createdAt; // 등록일시
	private String keyword;	// 검색어
}