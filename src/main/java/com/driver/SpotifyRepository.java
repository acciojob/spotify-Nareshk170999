package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class SpotifyRepository {
    public HashMap<Artist, List<Album>> artistAlbumMap;
    public HashMap<Album, List<Song>> albumSongMap;
    public HashMap<Playlist, List<Song>> playlistSongMap;
    public HashMap<Playlist, List<User>> playlistListenerMap;
    public HashMap<User, Playlist> creatorPlaylistMap;
    public HashMap<User, List<Playlist>> userPlaylistMap;
    public HashMap<Song, List<User>> songLikeMap;

    public List<User> users;
    public List<Song> songs;
    public List<Playlist> playlists;
    public List<Album> albums;
    public List<Artist> artists;

    public SpotifyRepository(){
        //To avoid hitting apis multiple times, initialize all the hashmaps here with some dummy data
        artistAlbumMap = new HashMap<>();
        albumSongMap = new HashMap<>();
        playlistSongMap = new HashMap<>();
        playlistListenerMap = new HashMap<>();
        creatorPlaylistMap = new HashMap<>();
        userPlaylistMap = new HashMap<>();
        songLikeMap = new HashMap<>();

        users = new ArrayList<>();
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
        albums = new ArrayList<>();
        artists = new ArrayList<>();
    }

    public User createUser(String name, String mobile) {
        User user = new User(name,mobile);
        users.add(user);
        return user;
    }

    public Artist createArtist(String name) {
        Artist artist = new Artist(name);
        artists.add(artist);
        return artist;
    }

    public Album createAlbum(String title, String artistName) {
        Artist artist1 = null;
        for (Artist artist : artists){
            if(artist.getName() == artistName){
                artist1 = artist;
                break;
            }
        }
        if(artist1 ==  null){
            artist1 = createArtist(artistName);
            Album album = new Album(title);
            albums.add(album);
            List<Album>list = new ArrayList<>();
            list.add(album);
            artistAlbumMap.put(artist1,list);
            return album;
        }else{
            Album album = new Album(title);
            albums.add(album);
            if (albumSongMap.containsKey(artist1)== true){
                List<Album> albumList = artistAlbumMap.get(artist1);
                albumList.add(album);
                artistAlbumMap.put(artist1,albumList);
            }else{
                List<Album>albumList = new ArrayList<>();
                albumList.add(album);
                artistAlbumMap.put(artist1,albumList);
            }
            return album;
        }

    }

    public Song createSong(String title, String albumName, int length) throws Exception{
        Album album = null;
        for(Album album1 : albums){
            if(album1.getTitle() == albumName){
                album = album1;
                break;
            }
        }
        if (album == null){
            throw new Exception("Album does not exist");
        }else{
            Song song = new Song(title,length);
            songs.add(song);
            if (albumSongMap.containsKey(album)){
                List<Song> l = albumSongMap.get(album);
                l.add(song);
                albumSongMap.put(album,l);
            }else {
                List<Song> songList = new ArrayList<>();
                songList.add(song);
                albumSongMap.put(album,songList);
            }
            return song;
        }
    }

    public Playlist createPlaylistOnLength(String mobile, String title, int length) throws Exception {
        Playlist playlist = new Playlist(title);
        int totalDuration =0 ;
        for (Song song : user.g)
    }

    public Playlist createPlaylistOnName(String mobile, String title, List<String> songTitles) throws Exception {
        Playlist playlist = new Playlist(mobile,title,songTitles);
        playlists.add(playlist);
    }

    public Playlist findPlaylist(String mobile, String playlistTitle) throws Exception {

    }

    public Song likeSong(String mobile, String songTitle) throws Exception {

    }

    public String mostPopularArtist() {
    }

    public String mostPopularSong() {

    }
}
