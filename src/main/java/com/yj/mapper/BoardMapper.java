package com.yj.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yj.domain.BoardVO;


@Mapper
public interface BoardMapper {
	
	public int registerBoard(BoardVO boardVO) throws SQLException;
	
	public BoardVO selectBoardDetail(Long bno) throws SQLException;
	
	public int updateBoard(BoardVO boardVO) throws SQLException;
	
	public int deleteBoard(Long bno) throws SQLException;
	
	public List<BoardVO> selectBoardList() throws SQLException; 
	
	public int selectBoardTotalCount();
	
	
}
