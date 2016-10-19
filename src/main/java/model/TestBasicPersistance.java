package model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kind.Kind;
import model.Profile;
import persistance.services.ProfileService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestBasicPersistance {
	
    @Autowired
    private ProfileService profileService;

    @Test
    public void testSave() {
    	profileService.save(new Profile(Kind.ACTION, Kind.ELECTRONIC, Kind.FAST_FOOD, 1000));
        Assert.assertEquals(1, profileService.retriveAll().size());
    }
}
