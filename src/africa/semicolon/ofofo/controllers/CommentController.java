package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.dtos.requests.CreateCommentRequestDTO;
import africa.semicolon.ofofo.services.CommentService;
import africa.semicolon.ofofo.services.CommentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService = new CommentServiceImpl();

    @PostMapping("/comment")
    public String addComment(CreateCommentRequestDTO createCommentRequestDTO){
        commentService.createComment(createCommentRequestDTO);
        return "Comment added";
    }
}
