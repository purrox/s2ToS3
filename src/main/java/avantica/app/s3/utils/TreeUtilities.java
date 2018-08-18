package avantica.app.s3.utils;

import avantica.app.s3.entities.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeUtilities
{


    /**
     * Method in charge of return the list of nodes
     * @param root
     */
    public Set<String> print(BinaryTree root){

        Set<String> list = new HashSet<>();

        return this.printHelper(root, list);
    }
    /**
     * Method in charge of create the list nodes
     * @param root
     */
    private Set<String> printHelper( BinaryTree root, Set<String> list ){
        System.out.println( root.getName() );
        list.add( root.getName() );

        if(root.isLeaf()){
            return list;
        }
        else{
            for(BinaryTree tree: root.getChildren()){
                printHelper( tree, list );
            }
        }
        return list;
    }


    public void delete(BinaryTree root, Long id){
        if(root.isLeaf()){
            return;
        }
        else{
            BinaryTree aux = null;
            List<BinaryTree> auxChildrens = null;
            for(BinaryTree tree: root.getChildren()){
                if(tree.getId() == id){
                    if(tree.isLeaf()){
                        aux = tree;
                    }
                    else{
                        aux = tree;
                        BinaryTree firstChild = tree.getChildren().get( 0 );
                        tree.getChildren().remove( 0);
                        auxChildrens = tree.getChildren();
                        BinaryTree c6 = new BinaryTree();
                        c6.setName( "PURRO" );
                        auxChildrens.add( c6 );
                        firstChild.setChildren(auxChildrens);
                        root.getChildren().add( firstChild );
                    }
                    break;
                }
                delete(tree, id);
            }
            root.getChildren().remove( aux );
        }
    }


}
