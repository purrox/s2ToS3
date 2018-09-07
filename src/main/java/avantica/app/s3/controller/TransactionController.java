package avantica.app.s3.controller;

import avantica.app.s3.entities.*;
import avantica.app.s3.repository.*;
import avantica.app.s3.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "transaction" )
public class TransactionController
{

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private StructureRepository structureRepository;

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @RequestMapping( value = "/create-configuration", method = RequestMethod.POST )
    public ResponseEntity createUserConfiguration( @RequestBody Configuration config )
    {
        try
        {
            config.getStructures().stream().forEach( s -> structureRepository.save( s ) );

            configurationRepository.save( config );

            return ResponseEntity.ok( config );
        }
        catch ( Exception e )
        {
            return ResponseEntity.badRequest().body( null );
        }

    }

    @RequestMapping( value = "/add_transaction", method = RequestMethod.POST )
    public ResponseEntity addTransaction( @RequestBody Transaction transaction, HttpRequest request )
    {
        transactionServices.save( transaction );

        return ResponseEntity.ok( transaction );
    }

    @RequestMapping( value = "/add_transaction_type", method = RequestMethod.POST )
    public ResponseEntity createTransactionTypes( @RequestBody TransactionType type )
    {

        transactionTypeRepository.save( type );

        return ResponseEntity.ok( type );
    }

    @RequestMapping( value = "/get_transaction/{id}", method = RequestMethod.GET )
    public ResponseEntity getTransaction( @PathVariable( name = "id" ) Long id )
    {

        Transaction t = transactionServices.getTransaction(id);

        return ResponseEntity.ok( t );

    }

    @RequestMapping( value = "/get_tree/{id}", method = RequestMethod.GET )
    public ResponseEntity getBinaryTree( @PathVariable( name = "id" ) Long id )
    {

        Transaction t = transactionServices.getBinaryTree(id);

        return ResponseEntity.ok( t );

    }
}
