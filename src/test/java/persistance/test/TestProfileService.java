package persistance.test;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TestProfileService {
	/*//@Autowired
    private ProfileService profileService;
	
    //@Test
    public void shouldBeSaveNEvent() {
    	Profile profile = new ProfileBuilder().build();
    	Profile profile2 = new ProfileBuilder().build();
    	profileService.save(profile);
    	profileService.save(profile2);
    	Assert.assertEquals(2, profileService.retriveAll().size());
    }
    
    //@Test
    public void shouldBeDeleteAEvent(){
    	Profile profile = new ProfileBuilder().build();
    	Profile profile2 = new ProfileBuilder().build();
    	profileService.save(profile);
    	profileService.save(profile2);
    	profileService.delete(profile2);
    	Assert.assertEquals(1, profileService.retriveAll().size());
    }
    
    //@Test
    public void shouldBeGetAEventByID(){
    	Profile profile = new ProfileBuilder().build();
    	Profile profile2 = new ProfileBuilder().build();
    	profileService.save(profile);
    	profileService.save(profile2);
    	Assert.assertEquals(profile.id, profileService.getById(profile.id).id);
    } 
	
    //@After
    public void drop(){
    	profileService.deleteAll();
    }
    */
}
