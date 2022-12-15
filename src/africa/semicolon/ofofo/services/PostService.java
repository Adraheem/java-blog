package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequestDTO;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequestDTO;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequestDTO createPostRequestDTO);
    void updatedPost(UpdatePostRequestDTO updatePostRequestDTO);
    void deletePost(String id);
    Post viewPost(String id);

    List<Post> viewAllPosts();
    void addComment(String postId, Comment comment);
}
