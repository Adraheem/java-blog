package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;

    @Override
    public void createComment(CreateCommentRequestDTO createCommentRequestDTO) {
        Comment comment = new Comment();
        comment.setComment(createCommentRequestDTO.getComment());
        comment.setCommenterName(createCommentRequestDTO.getCommenterName());
        Comment savedComment = commentRepository.save(comment);
        postService.addComment(createCommentRequestDTO.getPostId(), savedComment);
    }

    @Override
    public List<Comment> viewAllComments() {
        return commentRepository.findAll();
    }
}
