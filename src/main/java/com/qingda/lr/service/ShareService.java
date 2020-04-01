package com.qingda.lr.service;

import com.qingda.lr.entity.Share;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ShareService {
    int insertShare(Share share, MultipartFile file);

    List<Share> getAllShares(Integer pageNum);
}
