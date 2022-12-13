package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.data.repositories.PostRepositoryImpl;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequest;

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
    public void updatedPost(UpdatePostRequest updatePostRequest) {
        Post post = new Post();
        post.setId(updatePostRequest.getId());
        post.setTitle(updatePostRequest.getTitle());
        post.setBody(updatePostRequest.getBody());
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
