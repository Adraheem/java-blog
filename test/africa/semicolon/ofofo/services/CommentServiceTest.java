package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.dtos.requests.CreateCommentRequestDTO;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceTest {
    private CommentService commentService;
    private PostService postService;

    @BeforeEach
    void setUp(){
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
    }

    @Test
    void createCommentTest(){
        CreatePostRequestDTO createPostRequest = new CreatePostRequestDTO("Title", "Body");
        postService.createPost(createPostRequest);

        CreateCommentRequestDTO createCommentRequestDTO = new CreateCommentRequestDTO();
        createCommentRequestDTO.setPostId(1);
        createCommentRequestDTO.setCommenterName("Ojo");
        createCommentRequestDTO.setComment("I love your useless post!");
        commentService.createComment(createCommentRequestDTO);

        assertEquals(1, commentService.viewAllComments().size());
    }
}
