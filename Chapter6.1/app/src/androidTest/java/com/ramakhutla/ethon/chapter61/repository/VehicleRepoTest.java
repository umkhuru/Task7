package com.ramakhutla.ethon.chapter61.repository;

import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.VehicleType;
import com.ramakhutla.ethon.chapter61.factory.EngineSizeFactory;
import com.ramakhutla.ethon.chapter61.factory.VehicleConditionEmbeddableFactory;
import com.ramakhutla.ethon.chapter61.repository.impl.VehicleTypeRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Ethon on 4/24/2016.
 */
public class VehicleRepoTest extends AndroidTestCase {

    private static final String TAG="SETTINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        VehicleTypeRepository repo = new VehicleTypeRepositoryImpl(this.getContext());
        // CREATE
        VehicleType createEntity = new VehicleType.Builder()
                .SerialNumber("123")
                .Make("bmw")
                .Model("3series")
                .year("2014")
                //.vehicleConditiontype(VehicleConditionEmbeddableFactory.getVehicleConditionEmbeddable(RefcounterReading, Gas, MotorCondition))
                //.engineSizeEmbeddabletype(EngineSizeFactory.getEngineSizeEmbeddable(EngineSerialNumber, EngineSize, FuelType))
                //.rentalstype(rentalstype)
                .build();
        VehicleType insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<VehicleType> vehicleTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",vehicleTypes.size()>0);

        //READ ENTITY
        VehicleType entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        VehicleType updateEntity = new VehicleType.Builder()
                .copy(entity)
                .Make("benz")
                .build();
        repo.update(updateEntity);
        VehicleType newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","benz",newEntity.getMake());

        // DELETE ENTITY
        repo.delete(updateEntity);
        VehicleType deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
