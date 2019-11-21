package com.app.repository;

import com.app.model.Certificate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CertificatesRepositoryTest {
    @Autowired
    CertificatesRepository repository;
    private  Certificate entry;

    @Before
    public void init(){
        entry = repository.findOne(1L);
    }


    @Test
    public void numberOfEntryFromDataSQL(){
        List<Certificate> entries = repository.findAll();
        Assert.assertEquals(10, entries.size());
    }

    @Test
    public void idNotNull(){
        Assert.assertNotNull(entry.getId());

    }

    @Test
    public void isinNotNull(){
        Assert.assertNotNull(entry.getIsin());

    }

    @Test
    public void certTypeNotNull(){
        Assert.assertNotNull(entry.getCertType());

    }

    @Test
    public void marketNotNull(){
        Assert.assertNotNull(entry.getMarket());

    }

    @Test
    public void issuerNotNull(){
        Assert.assertNotNull(entry.getMarket());
    }

    @After
    public void cleanup(){
        entry = null;
    }
}
