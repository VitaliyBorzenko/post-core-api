package DAR.postcoreapi.service;

import DAR.postcoreapi.controller.PostController;
import DAR.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    private static HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel postModel1 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "IPhone",   "in progress");
        PostModel postModel2 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Samsung",   "in progress");
        PostModel postModel3 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "PlayStation 5",   "in progress");
        postMap.put(postModel1.getPostId(), postModel1);
        postMap.put(postModel2.getPostId(), postModel2);
        postMap.put(postModel3.getPostId(), postModel3);

    }

    @Override
    public void createPost(PostModel postModel) {
    postModel.setPostId(UUID.randomUUID().toString());
    postModel.setClientId(UUID.randomUUID().toString());
    postModel.setPostRecipientId(UUID.randomUUID().toString());
    postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        PostModel oldPostModel = postMap.get(postId);
        String clientId = oldPostModel.getClientId();
        postModel.setClientId(clientId);
        String recepientId = oldPostModel.getPostRecipientId();
        postModel.setPostRecipientId(recepientId);
        postMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
    postMap.remove(postId);
    }
}
