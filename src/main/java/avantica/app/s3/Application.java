package avantica.app.s3;

import avantica.app.s3.entities.BinaryTree;
import avantica.app.s3.entities.IgnoreHibernatePropertiesInJackson;
import avantica.app.s3.repository.BinaryTreeJpaRepository;
import avantica.app.s3.repository.BinaryTreeMongoRepository;
import avantica.app.s3.utils.TreeUtilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
	private BinaryTreeJpaRepository binaryTreeJpaRepository;

    @Autowired
    private BinaryTreeMongoRepository binaryTreeMongoRepository;

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.addMixIn( Object.class, IgnoreHibernatePropertiesInJackson.class );
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }

    TreeUtilities util = new TreeUtilities();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


        BinaryTree tree = new BinaryTree();

        BinaryTree c1 = new BinaryTree();
        BinaryTree c2 = new BinaryTree();

        BinaryTree c3 = new BinaryTree();
        BinaryTree c4 = new BinaryTree();

        BinaryTree c5 = new BinaryTree();
        BinaryTree c6 = new BinaryTree();

        tree.setName("root");

        c1.setName("c1");
        c2.setName("c2");
        c3.setName("c3");
        c4.setName("c4");
        c5.setName("c5");
        c6.setName("c6");


        List<BinaryTree> children = new ArrayList<>(  );

        List<BinaryTree> children2 = new ArrayList<>(  );


        children2.add( c5 );

        children2.add( c6 );

        c3.setChildren( children2 );
        children.add( c1 );
        children.add( c2 );
        children.add( c3 );

        tree.setChildren( children );


        binaryTreeJpaRepository.save(  c1 );
        binaryTreeJpaRepository.save(  c2 );

        //binaryTreeJpaRepository.save(  c4 );
        binaryTreeJpaRepository.save(  c5 );
        binaryTreeJpaRepository.save(  c6 );
        binaryTreeJpaRepository.save(  c3 );
        binaryTreeJpaRepository.save(  tree );


        BinaryTree tree2 = binaryTreeJpaRepository.getOne( tree.getId() );


        binaryTreeMongoRepository.save( tree );

        Optional<BinaryTree> tree3 = binaryTreeMongoRepository.findById( tree.getId() );

        util.print( tree);

        util.delete( tree, 5L );
        System.out.println( "_______________________________" );
        util.print( tree);
        binaryTreeJpaRepository.save(  tree );
        //children.add( c4 );


	}

}
