// PrehistoricAnimalFactory.java
// Enums for era and animal type
enum AnimalEra {
    MESOZOIC, CENOZOIC
}

enum AnimalType {
    LAND, SKY
}

// Abstract product class: Animal
abstract class Animal {
    AnimalType type;
    AnimalEra era;
    String name;

    Animal(AnimalType type, AnimalEra era, String name) {
        this.type = type;
        this.era = era;
        this.name = name;
    }

    abstract void create();
}

// Concrete product classes: LandAnimal and SkyAnimal
class LandAnimal extends Animal {
    LandAnimal(AnimalType type, AnimalEra era, String name) {
        super(type, era, name);
    }

    @Override
    void create() {
        System.out.println("Creating land animal: " + name);
        // Implementation for creating land animals
    }
}

class SkyAnimal extends Animal {
    SkyAnimal(AnimalType type, AnimalEra era, String name) {
        super(type, era, name);
    }

    @Override
    void create() {
        System.out.println("Creating sky animal: " + name);
        // Implementation for creating sky animals
    }
}

// Era-specific animal factory interface
interface EraAnimalFactory {
    LandAnimal makeLandAnimal();
    SkyAnimal makeSkyAnimal();
}

// Concrete factory classes: CenozoicAnimalFactory and MesozoicAnimalFactory
class CenozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal() {
        return new LandAnimal(AnimalType.LAND, AnimalEra.CENOZOIC, "Cenozoic Land Animal");
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
        return new SkyAnimal(AnimalType.SKY, AnimalEra.CENOZOIC, "Cenozoic Sky Animal");
    }
}

class MesozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal() {
        return new LandAnimal(AnimalType.LAND, AnimalEra.MESOZOIC, "Mesozoic Land Animal");
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
        return new SkyAnimal(AnimalType.SKY, AnimalEra.MESOZOIC, "Mesozoic Sky Animal");
    }
}

public class AbstractFactory{
    public static void main(String[] args) {
        EraAnimalFactory cenozoicFactory = new CenozoicAnimalFactory();
        LandAnimal cenozoicLandAnimal = cenozoicFactory.makeLandAnimal();
        SkyAnimal cenozoicSkyAnimal = cenozoicFactory.makeSkyAnimal();

        EraAnimalFactory mesozoicFactory = new MesozoicAnimalFactory();
        LandAnimal mesozoicLandAnimal = mesozoicFactory.makeLandAnimal();
        SkyAnimal mesozoicSkyAnimal = mesozoicFactory.makeSkyAnimal();

        // Create and use prehistoric animals
        cenozoicLandAnimal.create();
        cenozoicSkyAnimal.create();
        mesozoicLandAnimal.create();
        mesozoicSkyAnimal.create();
    }
}
