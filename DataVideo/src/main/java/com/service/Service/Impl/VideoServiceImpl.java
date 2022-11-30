package com.service.Service.Impl;

import com.service.Model.Video;
import com.service.Repository.VideoRepository;
import com.service.Response.BaseResponse;
import com.service.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public BaseResponse getAll() {
        return new BaseResponse("1", "Find success data", videoRepository.findAll());
    }

    @Override
    public BaseResponse create(Video video) {
        videoRepository.save(video);
        return new BaseResponse("1", "Create Success");
    }

    @Override
    public BaseResponse update(Video video) {
        if (videoRepository.getReferenceById(video.getId()) != null) {
            videoRepository.save(video);
            return new BaseResponse("1", "Update Success");
        }
        return new BaseResponse("-1", "Update failed");
    }

    @Override
    public BaseResponse delete(UUID id) {
        if (videoRepository.getReferenceById(id) != null) {
            videoRepository.deleteById(id);
            return new BaseResponse("1", "Delete Success");
        }
        return new BaseResponse("-1", "Delete Failed");
    }
}
