//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
// Title: This programs aims to create different types of iterators to play through a collection of
// songs in different orders. So, one type of iterator i.e Playlist plays the songs from the first
// song to the last song and the other type of iterator i.e ReversePlaylist plays the songs from the
// last song to the first song. For this assignment, doubly linked lists, iterable, and the
// iterator interfaces were the tools primarily used.
//
// Files: Song.java, DoublyLinkedNode.java, SongCollection.java, Playlist.java, ReversePlaylist.java
// Course: CS 300, Fall 2019
//
// Author: Rhea Cherian
// Email: rcherian@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * An instance of this class represents a single node within a doubly linked list.
 * 
 * @author rheacherian
 *
 * @param <T> generic type
 */
public class DoublyLinkedNode<T> {
  DoublyLinkedNode<T> previous; // node, which comes before the current node in a doubly linked list
  DoublyLinkedNode<T> next; // node, which comes after the current node in a doubly linked list
  T data; // data stored within current node

  /**
   * Initializes a new node with the specified information.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   * @param data     - to be stored within this node
   * @param next     - node, which comes after this node in a doubly linked list
   * @throws java.lang.IllegalArgumentException - when data is a null reference
   */
  public DoublyLinkedNode(DoublyLinkedNode<T> previous, T data, DoublyLinkedNode<T> next) {
    // if data is null, throws an IllegalArgumentException
    if (data == null) {
      throw new IllegalArgumentException("Data is a null reference.");
    }
    this.previous = previous; // sets the value of the node previous to the current node
    this.data = data; // sets the data of the current node
    this.next = next; // sets the value of the node next/after to the current node

    // if the previous node inputted isn't null, then set its previous value's next to next
    if (previous != null) {
      this.getPrevious().setNext(this.next);
    }

    // if the next node inputted isn't null, then set the next value's previous to previous
    if (next != null) {
      this.getNext().setPrevious(this.previous);
    }
  }

  /**
   * Initialize a new node with the specified data, and null next and previous reference.
   * 
   * @param data - to be stored within this node
   */
  public DoublyLinkedNode(T data) {
    // if data is null, throws an IllegalArgumentException
    if (data == null) {
      throw new IllegalArgumentException("Data is a null reference.");
    }
    this.data = data; // sets the data of the current node
    previous = null; // sets the value of the node previous to the current node to null
    next = null; // sets the value of the node next to the current node to null
  }

  /**
   * Accessor method for this node's data.
   * 
   * @return data - the data stored within this node.
   */
  public T getData() {
    return data;
  }

  /**
   * Accessor method for this node's next node reference.
   * 
   * @return reference to the node that comes after this one in the list, or null when this is the
   *         last node in that list
   */
  public DoublyLinkedNode<T> getNext() {
    return next;
  }

  /**
   * Mutator method for this node's next node reference.
   * 
   * @param next - node, which comes after this node in a doubly linked list
   */
  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for this node's previous node reference.
   * 
   * @return reference to the node that comes before this one in the list or null when this is the
   *         first node in that list
   */
  public DoublyLinkedNode<T> getPrevious() {
    return previous;
  }

  /**
   * Mutator method for this node's previous node reference.
   * 
   * @param previous - node, which comes before this node in a doubly linked list
   */
  public void setPrevious(DoublyLinkedNode<T> previous) {
    this.previous = previous;
  }
}
