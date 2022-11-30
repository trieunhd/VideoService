package com.service.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id @GeneratedValue
    private UUID id;

    @NotBlank @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String video_code;
    @NotEmpty
    private String image;
    @NotEmpty
    private String user_id;

    private Date created_date;
    private String creator;
    private Date updated_date;
    private String updater;
}
