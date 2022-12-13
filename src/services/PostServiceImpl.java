package services;

import data.models.Post;
import data.repositories.PostRepository;
import data.repositories.PostRepositoryImpl;
import dtos.requests.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setBody(createPostRequest.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatedPost(int id, String title, String body) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setBody(body);
        postRepository.save(post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.delete(id);
    }

    @Override
    public Post viewPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAllPosts() {
        return postRepository.findAll();
    }
}
