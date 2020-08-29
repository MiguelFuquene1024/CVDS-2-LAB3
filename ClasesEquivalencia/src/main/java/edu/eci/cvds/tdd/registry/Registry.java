package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;
public class Registry {
	private ArrayList<Person> personas = new ArrayList<Person>();
	
    public RegisterResult registerVoter(Person p) {
		try{
			if(p.getName()==null){
				return RegisterResult.INVALID;
			}
			else if(p.getAge()<0 || p.getAge() > 100){
				return RegisterResult.INVALID_AGE;
			}
			
			else if(p.getAge()<18){
				return RegisterResult.UNDERAGE;
			}
			
			
			else if(!p.isAlive()){
				return RegisterResult.DEAD;
			}
				
			else if(p.getGender() == Gender.UNIDENTIFIED){
				return RegisterResult.INVALID_GENDER;
			}
			
			for(int i=0;i<personas.size();i++){
				if(p.getId()==personas.get(i).getId()){
					return RegisterResult.DUPLICATED;
				}	
			}
			personas.add(p);
			return RegisterResult.VALID;
		}catch(Exception e){
			return RegisterResult.INVALID;
		}
    }
}