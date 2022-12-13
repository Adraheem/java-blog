package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequest;
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

    @Test
    void updatePostTest(){
        createPostRequest.setTitle("New Post");
        createPostRequest.setBody("Egusi is my best soup");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPosts().size());

        Post post = postService.viewPost(1);

        UpdatePostRequest updatePostRequest = new UpdatePostRequest();
        updatePostRequest.setId(post.getId());
        updatePostRequest.setTitle("Updated Post");
        updatePostRequest.setBody(post.getBody());

        postService.updatedPost(updatePostRequest);

        Post updatedPost = postService.viewPost(1);
        assertEquals("Updated Post", updatedPost.getTitle());
        assertEquals("Egusi is my best soup", updatedPost.getBody());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void deletePostTest(){
        CreatePostRequest cp1 = new CreatePostRequest();
        cp1.setTitle("New Post");
        cp1.setBody("Egusi is my best soup");
        postService.createPost(cp1);

        CreatePostRequest cp2 = new CreatePostRequest();
        cp2.setTitle("New Post 2");
        cp2.setBody("Vegetable is my best soup");
        postService.createPost(cp2);

        assertEquals(2, postService.viewAllPosts().size());

        postService.deletePost(2);

        assertEquals(1, postService.viewAllPosts().size());

        postService.deletePost(1);

        assertEquals(0, postService.viewAllPosts().size());
    }
}
