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
 * Song iterator that goes through the songs from front to end
 * 
 * @author rheacherian
 *
 */
public class Playlist implements Iterator<Song> {
  private DoublyLinkedNode<Song> currentSong; // represents the node of the current song

  /**
   * Constructor that initializes the head node of a doubly linked playlist
   * 
   * @param head - head node of a doubly linked list
   */
  public Playlist(DoublyLinkedNode<Song> head) {
    currentSong = head;
  }

  @Override
  /**
   * Returns true if the song collection's iterator has more elements. (In other words, returns true
   * if next() would return an element rather than throwing an exception.)
   * 
   * @returns boolean true if the song collection's iterator has more elements
   */
  public boolean hasNext() {
    if (currentSong != null) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Returns the next element in the song collection's iteration.
   * 
   * @returns Song - the next element in the song collection's iteration.
   * @throws NoSuchElementException - if the iteration has no more elements
   */
  public Song next() {
    DoublyLinkedNode<Song> temp = currentSong;

    // if the iteration has no more elements i.e current song is null, throw an exception
    if (currentSong == null) {
      throw new NoSuchElementException();
    }

    // update current song to the next song
    currentSong = currentSong.getNext();

    // return the current song stored previously
    return temp.getData();
  }

}
