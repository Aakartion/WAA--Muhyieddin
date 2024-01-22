package edu.miu.Lab4.domain.dto;


import edu.miu.Lab4.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private List<Post> posts;
}
