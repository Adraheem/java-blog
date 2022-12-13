package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
    }

    @Test
    void saveNewPost_countShouldBeOne_Test(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");

        postRepository.save(post);

        assertEquals(1L, postRepository.count());
    }

    @Test
    void saveNewPost_findById_shouldReturnSavedPostTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
    }

    @Test
    void saveNewPost_updatePost_countIsOneTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("Updated body");
        updatedPost.setTitle("Updated title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("Updated body", post.getBody());
        assertEquals("Updated title", post.getTitle());
    }

    @Test
    void deleteItem_countIsZeroTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);

        postRepository.delete(1);
        assertEquals(0L, postRepository.count());
    }

    @Test
    void deleteItem_newPostHasADifferentIdTest(){
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        Post post4 = new Post();

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);

        assertEquals(4, postRepository.count());
        postRepository.delete(2);
        postRepository.delete(post3);

        Post post5 = new Post();
        postRepository.save(post5);

        assertEquals(post5, postRepository.findById(5));
        assertEquals(3, postRepository.count());
    }
}
