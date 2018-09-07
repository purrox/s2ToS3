package avantica.app.s3;

import avantica.app.s3.entities.BinaryTree;
import avantica.app.s3.entities.IgnoreHibernatePropertiesInJackson;
import avantica.app.s3.entities.Queue;
import avantica.app.s3.entities.TransactionType;
import avantica.app.s3.repository.BinaryTreeJpaRepository;
import avantica.app.s3.repository.QueueRepository;
import avantica.app.s3.repository.TransactionTypeRepository;
import avantica.app.s3.utils.TreeUtilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
	private BinaryTreeJpaRepository binaryTreeJpaRepository;

    @Autowired
    private QueueRepository queueRepository;


    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

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

        tree.setWeight( 11 );
        tree.setName("11");
        binaryTreeJpaRepository.save(  tree );

        BinaryTree test = new BinaryTree();
        test.setName( "6" );
        test.setWeight( 6 );
        util.insert( tree, test );

        BinaryTree test1 = new BinaryTree();
        test1.setName( "8" );
        test1.setWeight( 8 );
        util.insert( tree, test1 );


        BinaryTree test4 = new BinaryTree();
        test4.setName( "19" );
        test4.setWeight( 19 );
        util.insert( tree, test4 );

        BinaryTree test5 = new BinaryTree();
        test5.setName( "4" );
        test5.setWeight( 4 );
        util.insert( tree, test5 );

        BinaryTree test6 = new BinaryTree();
        test6.setName( "10" );
        test6.setWeight( 10 );
        util.insert( tree, test6 );

        BinaryTree test7 = new BinaryTree();
        test7.setName( "5" );
        test7.setWeight( 5 );
        util.insert( tree, test7);

        BinaryTree test8 = new BinaryTree();
        test8.setName( "17" );
        test8.setWeight( 17 );
        util.insert( tree, test8);

        BinaryTree test9 = new BinaryTree();
        test9.setName( "43" );
        test9.setWeight( 43 );
        util.insert( tree, test9);

        BinaryTree test10 = new BinaryTree();
        test10.setName( "49" );
        test10.setWeight( 49 );
        util.insert( tree, test10);


        BinaryTree test11 = new BinaryTree();
        test11.setName( "31" );
        test11.setWeight( 31 );
        util.insert( tree, test11);

        BinaryTree test12 = new BinaryTree();
        test12.setName( "3" );
        test12.setWeight( 3 );
        util.insert( tree, test12);


        binaryTreeJpaRepository.save(  tree );

        tree = util.delete( tree, 6 );

        Queue head = new Queue();

        queueRepository.save( head );

        Queue element1 = new Queue();

        Queue element2 = new Queue();

        Queue element3 = new Queue();

        head.getQueue().add( element1 );
        head.getQueue().add( element2 );
        head.getQueue().add( element3 );

        queueRepository.save( head );

        binaryTreeJpaRepository.save(  tree );

    }

}
