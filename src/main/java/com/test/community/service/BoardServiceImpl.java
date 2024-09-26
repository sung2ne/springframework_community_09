package com.test.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.community.mapper.BoardMapper;
import com.test.community.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardgMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardgMapper) {
		this.boardgMapper = boardgMapper;
	}

	// 게시글 등록
	@Override
	@Transactional
	public int insert(BoardVO boardVO) {
		return this.boardgMapper.insert(boardVO);
	}

	// 게시글 목록
	@Override
	@Transactional
	public List<BoardVO> selectAll(BoardVO boardVO) {
		return this.boardgMapper.selectAll(boardVO);
	}

	// 게시글 조회
	@Override
	@Transactional
	public BoardVO select(int seq) {
		return this.boardgMapper.select(seq);
	}

	// 게시글 수정
	@Override
	@Transactional
	public int update(BoardVO boardVO) {
		return this.boardgMapper.update(boardVO);
	}

	// 게시글 삭제
	@Override
	@Transactional
	public void delete(int seq) {
		this.boardgMapper.delete(seq);
	}

}
