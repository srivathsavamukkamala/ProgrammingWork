import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void testAppend(){
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        assertNull(albums.head); //Checks to see if the empty constructor works
        ArrayList<String> names = new ArrayList<>();

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        Node<Album> node = albums.append(album);

        assertEquals(5,node.data.getNumOfSongs()); // Checks if the right node is being returned
        assertEquals(node,albums.head); // Checks if the first node added is the head

        names.add("Carl");
        names.add("Chris");
        Album album2 = new Album(names,9 );
        Node<Album> node2 = albums.append(album2);

        assertEquals(9,node2.data.getNumOfSongs()); // Checks if the right node is being returned
        assertEquals(node2,albums.head.next); // Checks if the second node added is "Next Node" of head

        Album album3 = new Album(names,20 );
        Node<Album> node3 = albums.append(album3);

        assertEquals(20,node3.data.getNumOfSongs()); // Checks if the right node is being returned
        assertEquals(node3,albums.head.next.next); // Checks if the third node added is "Next Node of Next Node" of head
    }//end TestAppend

    @Test
    public void testInsert(){
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);
        names.add("Carl");
        names.add("Chris");
        Album album2 = new Album(names,9 );
        albums.append(album2);
        Album album3 = new Album(names,20 );
        albums.append(album3);

        Album album4 = new Album(names, 11);
        Node<Album> node = albums.insert(0,album4);
        assertEquals(node,albums.head); //Checks if Album becomes head of the doubly linked list

        Album album5 = new Album(names, 14);
        Node<Album> node1 = albums.insert(4,album5);
        assertEquals(node1,albums.head.next.next.next.next); //Checks if Album is added at the end of the list

        Album album6 = new Album(names, 14);
        Node<Album> node2 = albums.insert(4,album6);
        assertEquals(node2,albums.head.next.next.next.next); //Checks if Album is added into the middle of the list

        Album album7 = new Album(names, 14);
        assertThrows(IllegalArgumentException.class,() -> albums.insert(-1,album7)); //Checks if exception is thrown for negative location

        Album album8 = new Album(names, 21);
        assertThrows(IllegalArgumentException.class,() -> albums.insert(9,album7)); //Checks if exception is thrown for large location number
    }//end testInsert

    @Test
    public void testDelete(){
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);

        Node<Album> head1 = albums.delete(0);//Deleting first and only node
        assertEquals(head1.data,album); //Check if the data/album are the same
        assertNull(albums.head); //Check if head is null

        albums.append(album);

        names.add("Carl");
        names.add("Chris");
        Album album2 = new Album(names,9 );
        albums.append(album2);
        Album album3 = new Album(names,20 );
        albums.append(album3);

        assertThrows(IllegalArgumentException.class,() -> albums.delete(-1)); //Checks if exception is thrown for negative location

        assertThrows(IllegalArgumentException.class,() -> albums.delete(9)); //Checks if exception is thrown for larger location

        Node<Album> head = albums.delete(0);

        assertEquals(5,head.data.getNumOfSongs()); //Checks if next node after deletion becomes head
        albums.append(new Album(names, 21)); //Add a node to the end

        Node<Album> deletedNode = albums.delete(1);

        assertEquals(album3.getNumOfSongs(),deletedNode.data.getNumOfSongs()); //Checks if album3 is deleted node

        Node<Album> tail = albums.delete(1);
        assertEquals(21,tail.data.getNumOfSongs());

        albums.delete(0);
        assertNull(albums.head);//checks if deleting last

        assertThrows(IllegalArgumentException.class,() -> albums.delete(0)); //Checks if exception thrown when head is null

    }

    @Test
    public void testGetIndex(){
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);
        names.add("Carl");
        names.add("Chris");
        Album album2 = new Album(names,9 );
        albums.append(album2);
        Album album3 = new Album(names,20 );
        albums.append(album3);

        Album album4 = new Album(names,25 );

        assertEquals(0,albums.getIndex(album));//Check head
        assertEquals(1,albums.getIndex(album2));//Check Middle
        assertEquals(2,albums.getIndex(album3));//Check Tail
        assertEquals(-1,albums.getIndex(album4));
    }

    @Test
    public void testToString() {
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        assertEquals("NULL",albums.toString()); //Checks for empty head
        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);
        assertEquals("1: 5 -- [Sri, Jake] -> NULL",albums.toString()); //Checks for length 1 doublylinkedlist

        ArrayList<String> names1 = new ArrayList<>();

        names1.add("Sri");
        names1.add("Jake");
        names1.add("Carl");
        names1.add("Chris");
        Album album2 = new Album(names1,9 );
        albums.append(album2);

        assertEquals("1: 5 -- [Sri, Jake] -> 2: 9 -- [Sri, Jake, Carl, Chris] -> NULL",albums.toString());//Checks for length 2 doublylinkedlist

        Album album3 = new Album(names1,20 );
        albums.append(album3);

        assertEquals("1: 5 -- [Sri, Jake] -> 2: 9 -- [Sri, Jake, Carl, Chris] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> NULL",albums.toString()); //Checks for length 3 doublylinkedlist
    }

    @Test
    public void testPartition(){
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        assertEquals("NULL",albums.toString()); //Checks for empty head
        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);

        ArrayList<String> names1 = new ArrayList<>();

        names1.add("Sri");
        names1.add("Jake");
        names1.add("Carl");
        names1.add("Chris");
        Album album2 = new Album(names1,9 );
        albums.append(album2);

        Album album3 = new Album(names1,20 );
        albums.append(album3);

        Album album4 = new Album(names1,1 );
        albums.append(album4);

        DoublyLinkedList<Album> albumsPartition1 = albums.partition(album);

        assertEquals("1: 5 -- [Sri, Jake] -> 2: 9 -- [Sri, Jake, Carl, Chris] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> NULL",albumsPartition1.toString()); //Paritioning album1 should return album1, 2, and 3. No Alumb 4

        DoublyLinkedList<Album> albumsPartition2 = albums.partition(album2);

        assertEquals("2: 9 -- [Sri, Jake, Carl, Chris] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> NULL",albumsPartition2.toString()); //Paritioning album2 should return album2, and 3. No album 1 or 4

        DoublyLinkedList<Album> albumsPartition3 = albums.partition(new Album(names,10));

        assertEquals("3: 20 -- [Sri, Jake, Carl, Chris] -> NULL",albumsPartition3.toString()); //Checking if returns only Album 3.

        DoublyLinkedList<Album> albumsPartition4 = albums.partition(new Album(names,25));

        assertEquals("NULL",albumsPartition4.toString()); //Checking if returns only NULL

    }

    @Test
    public void testShuffle() {
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        assertNull(albums.shuffle()); //Should return null since there is no Head Node

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);

        Node<Album> head = new Node<>(album);

        assertEquals(albums.head,albums.shuffle());

        ArrayList<String> names1 = new ArrayList<>();

        names1.add("Sri");
        names1.add("Jake");
        names1.add("Carl");
        names1.add("Chris");
        Album album2 = new Album(names1,9 );
        albums.append(album2);

        albums.shuffle();
        assertEquals("2: 9 -- [Sri, Jake, Carl, Chris] -> 1: 5 -- [Sri, Jake] -> NULL", albums.toString());

        albums.shuffle();//Re-order it back to the original
        Album album3 = new Album(names1,20 );
        albums.append(album3);

        albums.shuffle();
        assertEquals("2: 9 -- [Sri, Jake, Carl, Chris] -> 1: 5 -- [Sri, Jake] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> NULL", albums.toString());

        albums.shuffle();//Re-Order it back to the original
        Album album4 = new Album(names1,1 );
        albums.append(album4);

        albums.shuffle();
        assertEquals("2: 9 -- [Sri, Jake, Carl, Chris] -> 1: 5 -- [Sri, Jake] -> 4: 1 -- [Sri, Jake, Carl, Chris] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> NULL", albums.toString());
        albums.shuffle();//Re-Order it back to the Original

        Album album5 = new Album(names1,100);
        albums.append(album5);

        Album album6 = new Album(names, 55);
        albums.append(album6);

        albums.shuffle();
        assertEquals("2: 9 -- [Sri, Jake, Carl, Chris] -> 1: 5 -- [Sri, Jake] -> 4: 1 -- [Sri, Jake, Carl, Chris] -> 3: 20 -- [Sri, Jake, Carl, Chris] -> 6: 55 -- [Sri, Jake] -> 5: 100 -- [Sri, Jake, Carl, Chris] -> NULL",albums.toString());
    }


    /**
     * Tests the previous attribute of the nodes
     */
    @Test
    public void testPrevious() {
        DoublyLinkedList<Album> albums = new DoublyLinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        Album.resetId(); // Sets the ID back to zero so that tests do not interfere with each other.

        names.add("Sri");
        names.add("Jake");
        Album album = new Album(names,5 );
        albums.append(album);

        ArrayList<String> names1 = new ArrayList<>();

        names1.add("Sri");
        names1.add("Jake");
        names1.add("Carl");
        names1.add("Chris");
        Album album2 = new Album(names1,9 );
        albums.append(album2);

        Album album3 = new Album(names1,20 );
        albums.append(album3);

        Album album4 = new Album(names1,1 );
        albums.append(album4);

        Node<Album> head = albums.head;
        Node<Album> node2 = albums.head.next;
        Node<Album> node3 = albums.head.next.next;
        Node<Album> node4 = albums.head.next.next.next;
        assertEquals(node2.previous,head);
        assertEquals(node3.previous,node2);
        assertEquals(node4.previous,node3);

        albums.delete(2);
        assertEquals(node4.previous, node2);

        albums.insert(2,album3);
        assertEquals(albums.head.next.next,node4.previous);

        albums.shuffle();
        head = albums.head;
        node2 = albums.head.next;
        node3 = albums.head.next.next;
        node4 = albums.head.next.next.next;
        assertEquals(head,node2.previous);
        assertEquals(node2,node3.previous);
        assertEquals(node3,node4.previous);

        albums.delete(0);
        assertNull(node2.previous);
        albums.delete(2);
        assertNull(node3.next);

        albums.insert(0,album);
        assertNull(albums.head.previous);
        assertEquals(albums.head,node2.previous);
    }
}
