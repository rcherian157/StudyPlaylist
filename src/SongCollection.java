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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An instance of this class represents a doubly linked list of Song objects that implement the
 * Iterable iterface.
 * 
 * @author rheacherian
 *
 */

public class SongCollection implements Iterable<Song> {
  private DoublyLinkedNode<Song> head; // head of the song collection doubly linked list
  private DoublyLinkedNode<Song> tail; // tail of the song collection doubly linked list
  private boolean playDirectionForward; // boolean that is true if songs are played from start of
                                        // collection, false if songs are played from end of
                                        // collection

  public static void main(String[] args) {
  }

  /**
   * A no-argument constructor that sets head, tail as null and sets the play direction forward to
   * be true
   */
  public SongCollection() {
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  /**
   * adds song to the end/tail of this doubly linked list
   * 
   * @param song - song to be added to the song collection
   * @throws when song is null, throws a NullPointerException
   */
  public void add(Song song) {
    if (song == null) {
      throw new NullPointerException();
    }
    DoublyLinkedNode<Song> n = new DoublyLinkedNode<Song>(song);

    // if the list is empty, set both the head and tail to the doubly linked node that the song
    // represents
    if (head == null) {
      head = n;
      head.setNext(n);
      tail = n;
      tail.setPrevious(n);
    } else {
      // otherwise, set the tail to the doubly linked node that the song
      // represents
      tail.setNext(n);
      tail.setPrevious(tail);
      tail = n;
    }
  }

  /**
   * removes song from the front/head of this list
   * 
   * @return song that was just removed from the front/head of this list
   * @throws when list is empty, throws a NoSuchElementException
   * 
   */
  public Song remove() {
    if (head == null) {
      throw new NoSuchElementException();
    }

    Song s = head.getData();
    DoublyLinkedNode<Song> nextToHead = head.getNext();

    // if there is a node next to the head, then
    if (nextToHead != null) {
      DoublyLinkedNode<Song> nextToNextToHead = head.getNext().getNext();
      // if there isn't a node next to the next node , then set the head and tail of the list as the
      // next node
      if (nextToNextToHead == null) {
        head = nextToHead;
        tail = nextToHead;
      } else {
        // if there is a node next to the next node, then set's the head to the next node, and the
        // next node's next to the nextToNextToHead node
        head.setNext(nextToNextToHead);
        head.setPrevious(null);
        head = nextToHead;
      }
    } else {
      // if the node next to the head is null, then set head and tail as null, the list is empty
      if (nextToHead == null) {
        head = null;
        tail = null;
      }
    }
    // return the song that was removed from the head of the list
    return s;
  }

  @Override
  /**
   * When playDirectionForward is true, this method should return a Playlist object, otherwise a
   * ReversePlaylist object should be returned.
   * 
   * @returns Iterator<Song> Playlist if the playDirectionForward is true, ReversePlaylist if false
   */
  public Iterator<Song> iterator() {
    if (playDirectionForward == true) {
      Playlist p = new Playlist(head);
      return p;
    } else {
      ReversePlaylist r = new ReversePlaylist(tail);
      return r;
    }
  }

  /**
   * Sets the playDirectionForward boolean to true/false depending on the input
   * 
   * @param isForward - indicates whether the play direction is forward or reverse
   */
  public void setPlayDirection(boolean isForward) {
    playDirectionForward = isForward;
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // For each of the following big-O time complexity analyses, consider the problem
  // size to be the number of Songs that are stored within the argument songs, when
  // the method is first called.
  //
  // For analysisMethodA, the big-O time complexity is O(1).
  //
  // For analysisMethodB, the big-O time complexity is O(n).
  //
  // For analysisMethodC, the big-O time complexity is O(1).
  //
  ///////////////////////////////////////////////////////////////////////////////////

}
