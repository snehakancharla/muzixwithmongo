package com.stackroute.muzixapplication.repository;

import com.stackroute.muzixapplication.respository.MuzixRepository;
import com.stackroute.muzixapplication.domain.Album;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //to slice a particular data

public class MuzixRepositoryTest {

    @Autowired
    private MuzixRepository muzixRepository;
    private Album album;

    @Before
    public void setUp()
    {
        album = new Album();
        album.setTrackid(99);
        album.setTrackname("Shape of you");
        album.setTrackartist("Ed Sheeran");
        album.setGenre("rock");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        muzixRepository.save(album);
        Album fetchUser = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertEquals(99,fetchUser.getTrackid());

    }

    @Test
    public void testSaveFailure(){
        Album testUser = new Album(99,"Shape of you","Ed Sheeran","rock");
        muzixRepository.save(album);
        Album fetchUser = muzixRepository.findById(album.getTrackid()).get();
        Assert.assertNotSame(testUser,album);
    }

    @Test
    public void testGetAllUser(){
        Album u = new Album(11,"Baby","Justin Bieber","pop");
        Album u1 = new Album(12,"Cheap thrills","Sean pual","pop");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Album> list = muzixRepository.findAll();
        Assert.assertEquals("Cheap thrills",list.get(0).getTrackname());




    }


}

