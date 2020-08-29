package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID, result);
    }
	
	@Test
    public void validateRegistryResultINVALID_AGE() {

        Person person = new Person("Yarit",1073254905,-20,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	@Test
    public void validateRegistryResultUnderage() {

        Person person = new Person("Miguel",1073254904,15,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
	
	
	@Test
    public void validateRegistryResultDead() {

        Person person = new Person("Fuquene",1073254902,50,Gender.MALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
	
	@Test
    public void validateRegistryResultGender() {

        Person person = new Person("Yajanny",1073254902,50,Gender.UNIDENTIFIED,true);

        RegisterResult result = registry.registerVoter(person);


        Assert.assertEquals(RegisterResult.INVALID_GENDER, result);
    }
	
	@Test
    public void validateRegistryResultDuplicate() {

        Person person = new Person("Fuquene",1073254902,50,Gender.MALE,true);
        registry.registerVoter(person);
		person = new Person("Fuquene",1073254902,50,Gender.MALE,true);
		RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

}