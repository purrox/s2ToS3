package avantica.app.s3.utils;

import avantica.app.s3.entities.BinaryTree;

import java.util.*;

public class TreeUtilities
{

    public void insert( BinaryTree root, BinaryTree node )
    {
        if ( root == null )
        {
            return;
        }
        if ( root.getWeight() < node.getWeight() )
        {
            insert( root.getOldestChild(), node );
            if ( !node.isInserted() )
            {
                root.getChildren().add( node );
                root.getChildren().sort( Comparator.comparing( BinaryTree::getWeight ) );
                node.setInserted( true );
            }
        }
        else
        {
            insert( root.getYoungestChild(), node );
            if ( !node.isInserted() )
            {
                root.getChildren().add( node );
                root.getChildren().sort( Comparator.comparing( BinaryTree::getWeight ) );
                node.setInserted( true );
            }

        }
    }

    /**
     * Method in charge of return the list of nodes
     *
     * @param root
     */
    public Set<String> print( BinaryTree root )
    {

        Set<String> list = new HashSet<>();

        return this.printHelper( root, list );
    }

    /**
     * Method in charge of create the list nodes
     *
     * @param root
     */
    private Set<String> printHelper( BinaryTree root, Set<String> list )
    {
        System.out.println( root.getName() );
        list.add( root.getName() );

        if ( root.isLeaf() )
        {
            return list;
        }
        else
        {
            for ( BinaryTree tree : root.getChildren() )
            {
                printHelper( tree, list );
            }
        }
        return list;
    }

    public BinaryTree delete( BinaryTree root, int id )
    {
        if ( root.getWeight() == id )
        {
            if ( root.getChildren().isEmpty() )
            {
                return new BinaryTree();
            }
            else
            {
                BinaryTree firstChild = root.getChildren().get( 0 );
                root.getChildren().remove( 0 );
                List<BinaryTree> auxChildren = root.getChildren();
                firstChild.setChildren( auxChildren );
                return firstChild;
            }
        }
        else
        {
            return deleteHelper( root, id );
        }
    }

    public BinaryTree deleteHelper( BinaryTree root, int id )
    {
        if ( root.isLeaf() )
        {
            return root;
        }
        else
        {
            BinaryTree aux = null;
            List<BinaryTree> auxChildren;
            for ( BinaryTree tree : root.getChildren() )
            {
                if ( tree.getWeight() == id )
                {
                    if ( tree.isLeaf() )
                    {
                        aux = tree;
                    }
                    else
                    {
                        aux = tree;
                        BinaryTree firstChild = tree.getChildren().get( 0 );
                        tree.getChildren().remove( 0 );
                        auxChildren = tree.getChildren();
                        firstChild.setChildren( auxChildren );
                        root.getChildren().add( firstChild );
                        root.getChildren().sort( Comparator.comparing( BinaryTree::getWeight ) );
                    }
                    break;
                }
                deleteHelper( tree, id );
            }
            root.getChildren().remove( aux );
        }
        return root;
    }

}
