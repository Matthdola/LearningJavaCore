public class Parent {
    // Everyone can see it
    public static final String CONSTANT = "CONSTANT";

    // No one can access it
    private String privateField;

    // Only subclass can access it
    protected String protectedField;

    // No one can see it
    private class PrivateClass {

    }

    // Only visible to subclass
    protected interface ProtectedInterface {

    }

    // Everyone can call it
    public void publicAction() {

    }

    // Only subclass can call it
    protected void protectedAction() {

    }

    // No one can call it
    private void privateAction() {

    }

    // Onlye subl class in the same package
    void packageAction() {

    }
}

class Child extends Parent {
    @Override
    protected void protectedAction() {
        // Calls parent's method implementation
        super.protectedAction();
    }

    @Override
    void packageAction() {
        // Do nothing, no call to parent's method implementation
    }

    public void childAction() {
        this.protectedField = "value";
    }
}