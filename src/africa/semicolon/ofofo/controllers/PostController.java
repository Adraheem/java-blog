package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import africa.semicolon.ofofo.services.PostService;
import africa.semicolon.ofofo.services.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService = new PostServiceImpl();

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequestDTO createPostRequestDTO){
        postService.createPost(createPostRequestDTO);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId){
        return postService.viewPost(postId);
    }

    @GetMapping("/posts")
    public List<Post> viewAllPosts(){
        return postService.viewAllPosts();
    }
}
