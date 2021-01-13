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
 * An instances of this class represents a single song.
 * 
 * @author rheacherian
 */
public class Song {
  String title; // title of the song
  String artist; // artist of the song

  /**
   * Initializes a new song with the specified information.
   * 
   * @param title  - or name of this new song
   * @param artist - or musician who performs this song
   */
  public Song(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }

  @Override
  /**
   * Returns a string representation of this song. This string should be formatted as follows:
   * "TITLE by ARTIST", where this song's title and artist are used in place of the TITLE and ARTIST
   * place holders.
   * 
   * @return string representation of this song
   * 
   */
  public String toString() {
    String song = title.toUpperCase() + " by " + artist.toUpperCase();
    return song;
  }

  @Override
  /**
   * Returns true when this song's title and artist strings contain the same contents as the other
   * song's title and artist strings, and false otherwise. Note that this method takes an Object
   * rather than a Song argument, so that it Overrides Object.equals(Object). If an object that is
   * not an instance of Song is ever passed to this method, it should return false.
   * 
   * @param other - Song object to compare this object to
   * @return true when the two songs have matching title and artist
   */
  public boolean equals(Object other) {
    // if the object isn't a song, then return false
    if (other.getClass() != Song.class) {
      return false;
    }
    // if the songs are the same, then return true
    if (other.toString().equals(this.toString())) {
      return true;
    }
    // otherwise, return false
    return false;

  }
}
