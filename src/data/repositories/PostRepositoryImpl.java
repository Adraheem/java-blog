package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    private List<Post> postDb = new ArrayList<>();
    private static int postCounter = 0;

    public PostRepositoryImpl(){
        postCounter = 0;
    }

    @Override
    public Post save(Post post) {
        if(post.getId() != 0){
            update(post);
        }
        else {
            post.setId(++postCounter);
            postDb.add(post);
        }
        return post;
    }

    private void update(Post post) {
        Post savedPost = findById(post.getId());
        savedPost.setTitle(post.getTitle());
        savedPost.setBody(post.getBody());
    }

    @Override
    public Post findById(int id) {
        for (Post post : postDb) if (post.getId() == id) return post;
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {
        delete(post.getId());
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < postDb.size(); i++) {
            if(postDb.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if (index != -1) postDb.remove(index);
    }
}
