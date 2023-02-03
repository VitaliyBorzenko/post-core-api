package DAR.postcoreapi.service;

import DAR.postcoreapi.model.PostModel;
import java.util.List;
public interface PostService {

    void createPost(PostModel postModel); //для создания заказа посылки
    List<PostModel> getAllPosts(); // для вывода списка посылок
    PostModel getPostById(String postId); //для вывода данных о посылке по ID
    void updatePostById(String postId, PostModel postModel); // для обновления данных о посылке по ID
    void deletePostById(String postId); //для удаления данных о посылке по ID
}
