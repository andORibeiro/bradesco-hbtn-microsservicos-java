package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class SongRepository {
   private List<Song> list = new ArrayList<Song>();

   public SongRepository() {
      // seed with two songs as requested
      list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
      list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
   }

   public List<Song> getAllSongs() {
      return list;
   }

   public Song getSongById(Integer id) {
      if (id == null) return null;
      return list.stream()
            .filter(s -> Objects.equals(s.getId(), id))
            .findFirst()
            .orElse(null);
   }

   public void addSong(Song s) {
      if (s == null) return;
      list.add(s);
   }

   public void updateSong(Song s) {
      if (s == null || s.getId() == null) return;
      for (int i = 0; i < list.size(); i++) {
         Song cur = list.get(i);
         if (Objects.equals(cur.getId(), s.getId())) {
            list.set(i, s);
            return;
         }
      }
      // if not found, add as new
      list.add(s);
   }

   public void removeSong(Song s) {
      if (s == null || s.getId() == null) return;
      list.removeIf(cur -> Objects.equals(cur.getId(), s.getId()));
   }
}
