package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.dtos.requests.UpdatePostRequest;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatedPost(UpdatePostRequest updatePostRequest);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPosts();
}
