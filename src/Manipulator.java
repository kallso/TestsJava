public abstract class Manipulator<T extends Manipulator<T>>
{
    /**
     * This method actually does the work, whatever that is
     */
    public abstract void manipulate(DomainObject o);

    /**
     * This creates a child that can be used for divide and conquer-y stuff
     */
    public T createChild()
    {
        // Some really useful implementation here based on
        // state contained in this class
        return null;
    }
}

class DomainObject {

}

class SpellCheckingManipulator extends Manipulator<SpellCheckingManipulator> {

    @Override
    public void manipulate(DomainObject o) {

    }
}

class Test<T extends Number>
{
    /**
     * This creates a child that can be used for divide and conquer-y stuff
     */
    public T createChildInteger()
    {
        // Some really useful implementation here based on
        // state contained in this class
        return null;
    }
}

class TestExtension extends Test<Number> {

}
