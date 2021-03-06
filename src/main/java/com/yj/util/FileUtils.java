package com.yj.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.yj.domain.FileVO;
import com.yj.exception.FileStorageException;

@Component
public class FileUtils {
	
	@Value("${com.gaon.upload.path}")
    private String uploadPath;
	
	public List<FileVO> uploadFile(MultipartFile[] files, Long bno){
		
		
		
		List<FileVO> resultList = new ArrayList<>();
		
		/*
		File uploadPathFolder = new File(uploadPath);

        if (uploadPathFolder.exists() == false) {
            uploadPathFolder.mkdirs();
        }
		*/
		
		for (MultipartFile file: files) {
			/* 파일이 비어있으면 비어있는 리스트 반환 */
			if (file.getSize() < 1) {
				continue;
			}
			String originalName = file.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
        	
            String uuid = UUID.randomUUID().toString();
            
          
            String saveName = uploadPath + File.separator + uuid +"_" + fileName;
            Path savePath = Paths.get(saveName);
            
            try {
                //원본 파일 저장
            	file.transferTo(savePath);

                FileVO fileVO = new FileVO();
                fileVO.setBno(bno);
                fileVO.setOriginalName(fileName);
                fileVO.setSaveName(saveName);
                fileVO.setSize(file.getSize());
               
                resultList.add(fileVO);

            } catch (IOException e) {
            	throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
            }
        }
		return resultList;
	}
	
	

}
