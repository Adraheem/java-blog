package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    private PostService postService;
    private CreatePostRequest createPostRequest;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }

    @Test
    void createPostTest(){
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");

        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPosts().size());
    }

    @Test
    void viewPostTest(){
        createPostRequest.setTitle("New Post");
        createPostRequest.setBody("Egusi is my best soup");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPosts().size());

        Post post = postService.viewPost(1);
        assertEquals("New Post", post.getTitle());
        assertEquals("Egusi is my best soup", post.getBody());
        assertNotNull(post.getCreationTime());
    }
}
