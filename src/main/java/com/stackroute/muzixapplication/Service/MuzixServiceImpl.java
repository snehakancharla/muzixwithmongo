package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.respository.MuzixRepository;
import com.stackroute.muzixapplication.domain.Album;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements MuzixService {
     MuzixRepository muzixRepository;
    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){

        this.muzixRepository=muzixRepository;
    }
    @Override
    public Album saveAlbum(Album album) throws TrackAlreadyExistsException {

        if(muzixRepository.existsById(album.getTrackid()))
        {
            throw new TrackAlreadyExistsException("album Already Exists");
        }
        Album savedAlbum=muzixRepository.save(album);
        if(savedAlbum ==null)
        {
            throw new TrackAlreadyExistsException("track already exist exception");
        }
        return savedAlbum;
    }
    @Override
    public List<Album> getAllAlbums() {
        return muzixRepository.findAll();
    }

    /*@Override
    public List<Album> getByName(String trackname) throws TrackNotFoundException {
        List<Album> albums=muzixRepository.getByName(trackname);
        if(albums.isEmpty())
        {
            throw new TrackNotFoundException("Track id not found");
        }
        return albums;
    }*/
    @Override
    public Album updateTrack(Album album) throws IdNotFoundException {
        if(muzixRepository.existsById(album.getTrackid()))
        {
            Album savedAlbum=muzixRepository.save(album);
        }

        Album updateTrack=muzixRepository.save(album);
        return updateTrack;
    }

    @Override
    public Album putUpdateTrack(Album album) throws IdNotFoundException {
        Album savedAlbum;
        if(muzixRepository.existsById(album.getTrackid()))
        {
             savedAlbum=muzixRepository.save(album);
             return savedAlbum;
        }
        else{
            throw new IdNotFoundException("Track id not found");
        }

    }
    @Override
    public boolean deleteTrack(int trackid) throws TrackNotFoundException {
    boolean status=false;
      if(muzixRepository.existsById(trackid))
    {
        muzixRepository.deleteById(trackid);
        status=true;
        return status;
    }
      else {
        throw new TrackNotFoundException("Track id not found");
    }


}
}
