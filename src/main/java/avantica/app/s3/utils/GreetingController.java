package avantica.app.s3.utils;

import avantica.app.s3.entities.BinaryTree;
import avantica.app.s3.repository.BinaryTreeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    private CustomerRepository repository;

    @Autowired
    private BinaryTreeJpaRepository binaryTreeJpaRepository;

    @RequestMapping("/greeting")
    public BinaryTree greeting(@RequestParam(value="name", defaultValue="World") String name) {

        BinaryTree e = binaryTreeJpaRepository.getOne( 6L );

        List<BinaryTree> d = e.getChildren();

        return e;
    }
}
