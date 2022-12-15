package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(CreatePostRequestDTO createPostRequestDTO) {
        Post post = new Post();
        post.setTitle(createPostRequestDTO.getTitle());
        post.setBody(createPostRequestDTO.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatedPost(UpdatePostRequestDTO updatePostRequestDTO) {
        Post post = new Post();
        post.setId(updatePostRequestDTO.getId());
        post.setTitle(updatePostRequestDTO.getTitle());
        post.setBody(updatePostRequestDTO.getBody());
        postRepository.save(post);
    }

    @Override
    public void deletePost(String id) {
        Post post = viewPost(id);
        postRepository.delete(post);
    }

    @Override
    public Post viewPost(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void addComment(String postId, Comment comment) {
        Post savedPost = viewPost(postId);
        savedPost.getComments().add(comment);
        postRepository.save(savedPost);
    }
}
