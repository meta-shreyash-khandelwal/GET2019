package varunk;
import java.util.*;
public class Zoo {
//static List<Zone> z;
static List<Animal> a1;
	public static void main(String args[])
	{
     	 //Creating Cages
		List<Cage> cagezone1=new ArrayList<Cage>();
		List<Cage> cagezone2=new ArrayList<Cage>();
		List<Cage> cagezone3=new ArrayList<Cage>();
		
		
		//Adding zones
		List<Zone> zoneList=new ArrayList<Zone>();
		zoneList.add(new Zone(5,true,true,"Mammal"));// 5 cages , Park Present ,Canteen Present,Mammal category  
		zoneList.add(new Zone(6,false,true,"Reptile"));// 5 cages , Park Absent ,Canteen Present,Reptile category  
		zoneList.add(new Zone(3,true,false,"Bird"));// 5 cages , Park Present ,Canteen Absent,Bird category  
		
		
		//Adding animals with (uniqueName,Age,Weight,Category,Type)
		a1=new ArrayList<Animal>();
		a1.add(new Lion("L-11",15,80.45,"Mammal","Lion"));
		a1.add(new Lion("L-12",10,40.67,"Mammal","Lion"));
		a1.add(new Peacock("B-10",15,50.45,"Bird","Peacock"));
		a1.add(new Peacock("B-11",15,50.45,"Bird","Peacock"));
		a1.add(new Crocodile("C-10",15,280.45,"Reptile","Crocodile"));
		a1.add(new Crocodile("C-12",1,180.45,"Reptile","Crocodile"));
		a1.add(new Crocodile("C-12",15,280.45,"Reptile","Crocodile"));
	
		
		//Adding cages to the zoneListones with capacity 2	 of Type "Lion"
		cagezone1=zoneList.get(0).addCages("Lion", 2);
		//cagezone1=z.get(0).addCages("Tiger", 3);
		
		//Adding cages to the zones with capacity 6	 of Type "Peacock"	
		cagezone2=zoneList.get(2).addCages("Peacock", 6);
	
		//Adding cages to the zones with capacity 2	 of Type "Lion"
		cagezone3=zoneList.get(1).addCages("Crocodile", 1);
	
		
		
	
		for(int i=0;i<a1.size();i++) {
		if("Mammal".equals(a1.get(i).getCategory()))
		{
		zoneList.get(0).addAnimalToCage(cagezone1);//Adding animal related to Mammal
		System.out.println("Added Successfully")	;
		}
		else if("Bird".equals(a1.get(i).getCategory()))
		{
			zoneList.get(2).addAnimalToCage(cagezone2);//Adding animal related to Bird	
			System.out.println("Added Successfully")	;
		}
		else if("Reptile".equals(a1.get(i).getCategory()))//Adding animal related to Reptile
		{
			zoneList.get(1).addAnimalToCage(cagezone3);
			System.out.println("Added Successfully croc")	;
		}
		}
		int previous=a1.size();
	
		/*For the deletion
		 * Entering name in String name*/
String name="C-12";//To delete entering name
String animalCategory="";
		for(int k=0;k<a1.size();k++){
			//System.out.println("Animal "+a1.get(k).getName());
			if(name.equals(a1.get(k).getName()))
			{
				animalCategory=a1.get(k).getCategory();
			
			}
		}
		try
		{
		if(animalCategory.length()==0)
		{
			throw new Exception("Animal with given name not present");
			}	
		}
		catch(Exception e)
		{
			System.out.println("Animal with given name not present");
		}

		
		
		
		for(int i=0;i<a1.size();i++) {
			if("Mammal".equals(animalCategory))
			{
			zoneList.get(0).deathOfAnimal(cagezone1);
			System.out.println("Successfully deleted")	;
			break;
			}
			else if("Bird".equals(animalCategory))
			{
				zoneList.get(2).deathOfAnimal(cagezone2);	
				System.out.println("Successfully deleted")	;
				break;
			}
			else if("Reptile".equals(animalCategory))
			{
				zoneList.get(1).deathOfAnimal(cagezone3);
				System.out.println("Successfully deleted")	;
				break;
			}
			}
		
		
		
	
		
		
		
		
		
		
		
		a1.add(new Lion("L-13",8,140.67,"Mammal","Lion"));
		a1.add(new Crocodile("C-13",5,380.45,"Reptile","Crocodile"));
		
		for(int i=previous;i<a1.size();i++) {
			if("Mammal".equals(a1.get(i).getCategory()))
			{
			zoneList.get(0).addAnimalToCage(cagezone1);
			System.out.println("Added Successfully")	;
			}
			else if("Bird".equals(a1.get(i).getCategory()))
			{
				zoneList.get(2).addAnimalToCage(cagezone2);	
				System.out.println("Added Successfully")	;
			}
			else if("Reptile".equals(a1.get(i).getCategory()))
			{
				zoneList.get(1).addAnimalToCage(cagezone3);
				System.out.println("Added Successfully croc")	;
			}
			}
		
		
		


	//List of zone with cages
	System.out.println("ZONES FOR MAMMAL")	;
	System.out.println("Current  Capacity")	;
	for(int k=0;k<cagezone1.size();k++)
	{
		System.out.println(cagezone1.get(k).current+"\t "+cagezone1.get(k).capacity);
	}


	System.out.println("ZONES FOR BIRD");	
	System.out.println("Current  Capacity")	;
	for(int k=0;k<cagezone2.size();k++)
	{
		System.out.println(cagezone2.get(k).current+"\t "+cagezone2.get(k).capacity);
	}
	
	System.out.println("ZONES FOR REPTILES")	;
	System.out.println("Cuurent  Capacity")	;
	for(int k=0;k<cagezone3.size();k++)
	{
		System.out.println(cagezone3.get(k).current+"\t "+cagezone3.get(k).capacity);
	}
	//List of animal
	}
	
	
	
}






