package com.example.contractmanagementsystem.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname MaxFileUploadService
 * @Date 2020/11/2 14:21
 * @Author pengdz
 */
public interface MaxFileUploadService {
    JSONObject verifyFileExists(String fileMD5, String fileExt) throws Exception;
    JSONObject getChunkUploadCount(String fileMD5) throws Exception;
    JSONObject getChunkUploadIndex(String fileMD5, String chunkSize) throws Exception;
    JSONObject verifyChunk(String fileMD5, String chunk, String chunkSize) throws Exception;
    JSONObject upload(MultipartFile file, String fileMD5, String chunk, String chunkSize) throws Exception;
    JSONObject marginFile(String fileMD5, String fileExt, String chunkCount,String fileName) throws Exception;
    JSONObject cancel(String fileMD5) throws Exception;
}
