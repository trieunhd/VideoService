package com.service.Service;

import com.service.Model.Video;
import com.service.Response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface VideoService {

    BaseResponse getAll();
    BaseResponse create(Video video);
    BaseResponse update(Video video);
    BaseResponse delete(UUID id);
}
