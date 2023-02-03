package DAR.postcoreapi.controller;


import DAR.postcoreapi.model.PostModel;
import DAR.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")

public class PostController {

    @Autowired
    private PostService postServiсe;

    @GetMapping("/check")
    public ResponseEntity<String> checkPost() {
        return new ResponseEntity<>("post-core-api is working", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel){
    postServiсe.createPost(postModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPost(){
    return postServiсe.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById (@PathVariable String postId){
    return postServiсe.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById (@PathVariable String postId, @Valid @RequestBody PostModel postModel){
    postServiсe.updatePostById(postId, postModel);
    return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId){
    postServiсe.deletePostById(postId);
    return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }





}
