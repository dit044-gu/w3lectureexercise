
interface MeatProvider {
    void buyMeat();
}

// this class should probably be split up, but that might be hard
class CharcuterieDataAndBicycleStore implements MeatProvider {
    public void buyMeat() {}
    void refillData() {}
    void fixBike() {}
    // ...
}

// depend only on the things I need
// by abstracting the implementation class with an interface

class Cafe { // breaks the ISP
    // to break the usage dependency, two main techniques:
    // 1. factory method pattern (later in the course)
    // 2. dependency injection
    MeatProvider c;

    public Cafe(MeatProvider c) {
        this.c = c;
    }
    // new Cafe(new CharcuterieDataAndBicycleStore());

    void receiveSandwichOrder() {
        c.buyMeat();
        // do other stuff
    }
}

public class Example {
}
