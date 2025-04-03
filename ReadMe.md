##Apollos_Tech

1.	Develop an Object-Oriented design for the Lusaka Zoo animal tracking system. Your program should be able to identify the primary classes, objects and methods as well as define the essential attributes for each class.
Primary Class

1.	Animal Class
Attributes
•	name: String 
•	species: String 
•	age: int 
•	healthStatus: String
•	feedingSchedule: String .
•	enclosure: Enclosure 
Methods
•	constructorAnimal
•	setHealthStatus(String newStatus)
•	setEnclosure(Enclosure newEnclosure) 
•	getEnclosure(): Enclosure 
•	getSpecies(): String
•	toString(): String 

2.	Enclosure Class
Attributes
•	name: String 
•	capacity: int 
•	animals: List<Animal> 
Methods
•	Enclosure
•	addAnimal(l) 
•	removeAnimal(l) 
•	getAnimals(): List<Animal> 
•	toString(): String 
3.	Zookeeper Class

Attributes
•	name: String 
•	employeeID: String
•	enclosures: List<Enclosure> 

Methods
•	Zookeeper()
•	assignEnclosure()
•	removeEnclosure()
•	getEnclosures(): List<Enclosure> 
•	getAnimalsUnderCare(): List<Animal> 
•	toString(): String 
4.	Zoo Class (Main Management Class)

Attributes
•	animals
•	enclosures
•	zookeepers
Methods
•	Zoo() 
•	addAnimal()
•	updateAnimalHealth()
•	findAnimalsBySpecies()
•	assignZookeeperToEnclosure()
•	enclosureName()
•	generateZookeeperReport()
5.	Main Class (Entry Point)
Methods
•	main(String[] args)
2. Imagine you need to also implement a method to find all the animals of a specific species within the zoo. 
i. Which class would this method logically belong to? 
•	The zoo class because it is the class that contains all the animals and can be filtered according to preference.

ii. How to Use Control Structures to Identify Animals of a Specific Species
•	To Identify Animals of a Specific Species we have to iterate through the list using a loop and check each animal’s specie
ii.Describe how you would use control structures to go through a collection of Animal objects and identify those belonging to the specified species
•	A for loop might be used to iterate through the animal list; there after a conditional statement such as an if stamen is used to check if the species of the animal matches the specie that we want to find. Second lastly we have to check to compare the specie name in lower case and lastly retrieve from the array that stores the matching names and returns them.

