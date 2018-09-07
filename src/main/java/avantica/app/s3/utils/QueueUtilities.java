package avantica.app.s3.utils;

import avantica.app.s3.entities.Queue;

import java.util.List;

public class QueueUtilities
{

    public void enqueue( Queue queue, Queue element )
    {

        queue.getQueue().add( element );
    }

    public Queue dequeue( Queue queue )
    {
        if ( queue.getQueue().isEmpty() )
        {
            queue = null;
        }
        else
        {
            List<Queue> newQueueList = queue.getQueue();
            queue = queue.getQueue().get( 0 );
            newQueueList.remove( 0 );
            queue.setQueue( newQueueList );
        }
        return queue;
    }


    public Queue peek(Queue queue){
        return queue;
    }

}
