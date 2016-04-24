package com.ramakhutla.ethon.chapter61.repository;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;
import com.ramakhutla.ethon.chapter61.repository.impl.CustomerTypeRepositoryImpl;

import junit.framework.Assert;
import android.test.AndroidTestCase;


import java.util.Set;

/**
 * Created by Ethon on 4/24/2016.
 */
public class CustomerRepoTest extends AndroidTestCase{

    private static final String TAG="CUSTOMER TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CustomerTypeRepository repo = new CustomerTypeRepositoryImpl(this.getContext());
        // CREATE
        CustomerType createEntity = new CustomerType.Builder()
                .firstName("ethan")
                .firstName("ramakhutla")
                .phoneNumber("0813817755")
                //.addressEmbeddabletype(AddressFactory.getAddressEmbeddableType(Address, City, postalCode))
                //.loginEmbeddabletype(LoginFactory.getLogin(username, password))
                //.rentals("bakkie")
                .build();
        CustomerType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<CustomerType> customerTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",customerTypes.size()>0);

        //READ ENTITY
        CustomerType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        CustomerType updateEntity = new CustomerType.Builder()
                .copy(entity)
                .firstName("ethan")
                .firstName("ramakhutla")
                .phoneNumber("081381885")
                .build();
        repo.update(updateEntity);
        CustomerType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","081381885",newEntity.getPhoneNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CustomerType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
