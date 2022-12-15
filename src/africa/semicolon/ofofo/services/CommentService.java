package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequestDTO;

import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequestDTO createCommentRequestDTO);

    List<Comment> viewAllComments();
}
