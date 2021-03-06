package com.yj.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yj.domain.BoardVO;
import com.yj.domain.FileVO;



public interface BoardService {

	public List<BoardVO> getBoardList() throws Exception;
	
	public BoardVO getBoard(Long bno) throws Exception;
	
	public void registerBoard(BoardVO boardVO) throws Exception;
	
	public void registerBoard(BoardVO boardVO, MultipartFile[] files) throws Exception;
	
	//public void updateBoard(BoardVO boardVO) throws Exception;
	
	public void deleteBoard(Long bno) throws Exception;
	
	public List<FileVO> getFileList(Long bno) throws Exception;
	
	public FileVO getFile(Long fno) throws Exception;

	public void deleteFile(Long bno) throws Exception;
}