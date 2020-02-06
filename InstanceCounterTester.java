public class InstanceCounterTester extends InstanceCounter {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new InstanceCounter();
        }

        System.out.println(InstanceCounter.instanceCount());
    }

    /**
     * When the final modifier is applied to a class, it means that the class 
     * cannot be subclassed
     * When the final modifier is applied to a variable, it means that the variable 
     * is constant
     * When the final modifier is applied to a method, it means that the method
     * cannot be overridden by subclassed
     * 
     * When an element is declared final, that means it is constant,
     * But when the static modifier is applied to that element,
     * It means that element become class element
     */
    public final void aFinalMethod() {

    }
}

class ACorrectFinalClass {
    private     String aUsefulString;

    public final String aUsefulString() {   // now faster to use
        return aUsefulString;
    }

    protected final void aUsefulString(String s) {  // also faster
        aUsefulString = s;
    }
}