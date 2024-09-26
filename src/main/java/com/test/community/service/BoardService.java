package com.test.community.service;

import java.util.List;

import com.test.community.vo.BoardVO;

public interface BoardService {
	
	// 게시글 등록
    int insert(BoardVO boardVO);
    
	// 게시글 목록
    List<BoardVO> selectAll(BoardVO boardVO);

    // 게시글 조회
    BoardVO select(int seq);

    // 게시글 수정
    int update(BoardVO boardVO);

    // 게시글 삭제
    void delete(int seq);

}
