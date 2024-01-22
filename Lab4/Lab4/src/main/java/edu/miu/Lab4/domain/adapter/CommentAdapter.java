package edu.miu.Lab4.domain.adapter;

import edu.miu.Lab4.domain.Comment;
import edu.miu.Lab4.domain.dto.CommentDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CommentAdapter {
    public static Comment getComment(CommentDTO commentDTO){
        return new Comment(
                commentDTO.getId(),
                commentDTO.getName()
                );
    }

    public static CommentDTO getCommentDTO(Comment comment){
        return new CommentDTO(
                comment.getId(),
                comment.getName()
        );
    }

    public static List<Comment> getComments(List<CommentDTO> commentDTOS){
        return commentDTOS.stream()
                .map(CommentAdapter::getComment)
                .collect(Collectors.toList());
    }

    public static List<CommentDTO> getCommentDTOs(List<Comment> comments){
        return comments.stream()
                .map(CommentAdapter::getCommentDTO)
                .collect(Collectors.toList());
    }
}
