package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.SalesPersonType;
import com.ramakhutla.ethon.chapter61.repository.impl.SalesPersonTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/24/2016.
 */
public class SalesPersonRepoTest extends AndroidTestCase {

    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SalesPersonTypeRepository repo = new SalesPersonTypeRepositoryImpl(this.getContext());
        // CREATE
        SalesPersonType createEntity = new SalesPersonType.Builder()
                .firstName("ethan")
                .hours(5)
                .rate(7)
                .build();
        SalesPersonType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<SalesPersonType> settings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",settings.size()>0);

        //READ ENTITY
        SalesPersonType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        SalesPersonType updateEntity = new SalesPersonType.Builder()
                .copy(entity)
                .firstName("etha")
                .build();
        repo.update(updateEntity);
        SalesPersonType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","etha",newEntity.getFirstName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        SalesPersonType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
