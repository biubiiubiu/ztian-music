package com.example.ztianmusic.service.impl;

import com.example.ztianmusic.dto.FileUploadDto;
import com.example.ztianmusic.service.StorageService;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author: zhangtian
 * @since: 2022-03-28 16:37
 */
@Service("COS")
public class CosStorageServiceImpl implements StorageService {
    @Override
    public FileUploadDto initFileUpload() {
        return null;
    }
}
