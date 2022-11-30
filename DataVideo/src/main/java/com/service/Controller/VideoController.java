package com.service.Controller;

import com.service.Model.Video;
import com.service.Response.BaseResponse;
import com.service.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse> getAll() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            return ResponseEntity.ok().body(videoService.getAll());
        } catch (Exception ex) {
            baseResponse.setCode("-1");
            baseResponse.setMessage("Failed to find data");
            return ResponseEntity.badRequest().body(baseResponse);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody Video video, BindingResult result) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            if (result.hasErrors()) {
                baseResponse.setCode("-1");
                baseResponse.setMessage("Error Valid");
                return ResponseEntity.badRequest().body(baseResponse);
            }
            return ResponseEntity.ok().body(videoService.create(video));
        } catch (Exception ex) {
            baseResponse.setCode("-1");
            baseResponse.setMessage("Create Failed");
            return ResponseEntity.badRequest().body(baseResponse);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody Video video, BindingResult result) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            if (result.hasErrors()) {
                baseResponse.setCode("-1");
                baseResponse.setMessage("Error Valid");
                return ResponseEntity.badRequest().body(baseResponse);
            }
            return ResponseEntity.ok().body(videoService.update(video));
        } catch (Exception ex) {
            baseResponse.setCode("-1");
            baseResponse.setMessage("Update Failed");
            return ResponseEntity.badRequest().body(baseResponse);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam("id")Optional<String> id) {
        BaseResponse baseResponse = new BaseResponse();
        String vid = id.orElse(null);
        try {
            if (vid == null) {
                baseResponse.setCode("-1");
                baseResponse.setMessage("Error Valid");
                return ResponseEntity.badRequest().body(baseResponse);
            }
            return ResponseEntity.ok().body(videoService.delete(UUID.fromString(vid)));
        } catch (Exception ex) {
            baseResponse.setCode("-1");
            baseResponse.setMessage("Delete Failed");
            return ResponseEntity.badRequest().body(baseResponse);
        }
    }
}
