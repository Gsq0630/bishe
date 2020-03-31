package com.qingda.lr.service;

import com.qingda.lr.entity.Share;
import com.qingda.lr.mapper.ShareMapper;
import com.qingda.lr.until.FileUploadGsq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    ShareMapper shareMapper;

    @Override
    public int insertShare(Share share, MultipartFile file) {
        int result = 0;
        try {
            if (!file.isEmpty()){
                share.setShareAnnexUrl(new FileUploadGsq().uploadToDisk(file));
            }
            result = shareMapper.insertSelective(share);
        }catch (Exception e){
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
}
