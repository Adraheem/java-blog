package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {
    private PostService postService;
    private CreatePostRequestDTO createPostRequestDTO;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        createPostRequestDTO = new CreatePostRequestDTO();
    }

    @Test
    void createPostTest(){
        createPostRequestDTO.setBody("Egusi is my best soup");
        createPostRequestDTO.setTitle("New Post");

        postService.createPost(createPostRequestDTO);
        assertEquals(1, postService.viewAllPosts().size());
    }

    @Test
    void viewPostTest(){
        createPostRequestDTO.setTitle("New Post");
        createPostRequestDTO.setBody("Egusi is my best soup");
        postService.createPost(createPostRequestDTO);
        assertEquals(1, postService.viewAllPosts().size());

        Post post = postService.viewPost("1");
        assertEquals("New Post", post.getTitle());
        assertEquals("Egusi is my best soup", post.getBody());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void updatePostTest(){
        createPostRequestDTO.setTitle("New Post");
        createPostRequestDTO.setBody("Egusi is my best soup");
        postService.createPost(createPostRequestDTO);
        assertEquals(1, postService.viewAllPosts().size());

        Post post = postService.viewPost("1");

        UpdatePostRequestDTO updatePostRequestDTO = new UpdatePostRequestDTO();
        updatePostRequestDTO.setId(post.getId());
        updatePostRequestDTO.setTitle("Updated Post");
        updatePostRequestDTO.setBody(post.getBody());

        postService.updatedPost(updatePostRequestDTO);

        Post updatedPost = postService.viewPost("1");
        assertEquals("Updated Post", updatedPost.getTitle());
        assertEquals("Egusi is my best soup", updatedPost.getBody());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void deletePostTest(){
        CreatePostRequestDTO cp1 = new CreatePostRequestDTO();
        cp1.setTitle("New Post");
        cp1.setBody("Egusi is my best soup");
        postService.createPost(cp1);

        CreatePostRequestDTO cp2 = new CreatePostRequestDTO();
        cp2.setTitle("New Post 2");
        cp2.setBody("Vegetable is my best soup");
        postService.createPost(cp2);

        assertEquals(2, postService.viewAllPosts().size());

        postService.deletePost("1");

        assertEquals(1, postService.viewAllPosts().size());

        postService.deletePost("1");

        assertEquals(0, postService.viewAllPosts().size());
    }

    @Test
    void addCommentTest(){
        CreatePostRequestDTO cp1 = new CreatePostRequestDTO();
        cp1.setTitle("New Post");
        cp1.setBody("Egusi is my best soup");
        postService.createPost(cp1);

        assertEquals(1, postService.viewAllPosts().size());

        Comment comment = new Comment();
        comment.setComment("I love your post");
        postService.addComment("1", comment);

        Post savedPost = postService.viewPost("1");
        assertEquals(1, savedPost.getComments().size());
        assertEquals("I love your post", savedPost.getComments().get(0).getComment());
    }
}
