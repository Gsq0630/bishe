package com.qingda.lr.service;

import java.util.List;
import java.util.Map;

public interface ChatService {

    Map<String, List> getAllChats(Integer userId);
}
