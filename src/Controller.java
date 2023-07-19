import java.io.Serializable;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Controller {
    public static void main(String[] args) {
        /*Class<A> a = A.class;

        int[] ints = new int[4];

        System.out.println(ints);
        System.out.println(int.class.isPrimitive());

        //a.  a("test");
        System.out.println(A.a("test"));
        System.out.println(B.a("test"));

        A refa = null;
        refa.a("test ref");

        int test = A.aStaticField;*/

        // Class<A> a2 = new A();
        Day dayEnum;
        System.out.println(Day.FRIDAY.getClass());

        // Enum
        Enum<Day> anEnum;
        TaskType[] taskTypes = TaskType.values();

        // EnumSet
        EnumSet<Day> days;

        // Tests recursiv generic definition
        // Manipulator<Manipulator> manipulator; // ==> Cant use the abstract class reference because generic type upper bound cant be satisfied
        SpellCheckingManipulator spellCheckingManipulator = new SpellCheckingManipulator();
        SpellCheckingManipulator spellCheckingManipulatorChild = spellCheckingManipulator.createChild();

        // differents thread qui run une fonction externe ont chacun une instance differente de la fonction ?
        Thread firstThread = new TestThread();
        Thread secondThread = new TestThread();

        // Test which equals is used when casting on Object
        Sim sim1 = new Sim(1L);
        Sim sim2 = new Sim(1L);

        System.out.println(sim1.equals(sim2));
        System.out.println(((Object) sim1).equals((Object) sim2));


        // Test merge entre HashMap et TreeMap
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        // treeMap.merge()

        HashMap<Object, Object> hashMap = new HashMap<>();
        //hashMap.merge()
        // Error
        // HashSet
        TreeSet<Day> treeset = new TreeSet<>();
        // treeset.ceiling()
        HashSet<Day> hashSet = new HashSet<>();
        // SortedSet<Day> sortedSet = new TreeSet<>();

        // Test if headSet() is better than iterate over all set (its probably a binary search) :
        // SortedSet<ComparableDummy> sortedSet = new TreeSet<>();
        SortedSet<ComparableDummy> sortedSet = new TreeSet<>();

        for (int i = 1; i < 10000000; i++) {
            sortedSet.add(new ComparableDummy(i, "theData" + i % 2));
        }

        sortedSet.remove(new ComparableDummy(50000));

        // retreive an element with an element that is compareTo equivalent :
        ComparableDummy comparableDummy50000 = new ComparableDummy(50000);

        // tailset seems to be a binary search so (log(n)) complexity:
        // if we match first() will return the element
        // if we dont match :
        // the element is smaller than the whole sortedset in this case the subset is the whole set and first() return the first element of the original sortedset
        // the elemment is bigger than the whole sortedset in this case first() throw a NoSuchElementException
        // the element is a hole in the sortedSet : first() returns the just greater element in the sortedSet
        long start = System.currentTimeMillis();
        try {
            ComparableDummy comparableDummyComparableEquivalent = new ComparableDummy(600000);
            ComparableDummy comparableDummyMatch = sortedSet.tailSet(comparableDummyComparableEquivalent).first();
            if (comparableDummyMatch.compareTo(comparableDummyComparableEquivalent) == 0) {
                System.out.println("element = " + comparableDummyMatch + "   element id  = " + comparableDummyMatch.getId());
                comparableDummyMatch.setaData("newData");
            }
        } catch (NoSuchElementException e) {
            System.out.println("A SIM result in resultDTO doesnt match any SIM in the changeSet of the Task. This SIM seems to not belong to this Task");
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for tailSet() = " + (end - start));

        start = System.currentTimeMillis();
        sortedSet.forEach(comparableDummy -> {
            if (comparableDummy.getId() == 50000) {
                System.out.println("match in forEach, comparableDummy = " + comparableDummy + " id = " + comparableDummy.getId());
            }
        });
        end = System.currentTimeMillis();
        System.out.println("Time for forEach() = " + (end - start));

        // Reducing the visibility of a static method
        C c = new C();

        // Auto new String[] on list literal
        String[] stringArray = {"User::getLogin", "User::getNomAffiche"};
        String[] stringArray2 = new String[]{"adzad", "adzad"};

        // TEST multiple casts in once : & is a cast operator : https://stackoverflow.com/questions/51070344/strange-java-cast-syntax-using
        Supplier<Thread> supplier = (Supplier<Thread> & Serializable & Cloneable) () -> new Thread() {};

        // Concurrency problem, variable final or effectively final outside of lambda
        // Pourquoi IntelliJ me propose une AtomicReference en dehors d'une lambda et ca marche ?
        //List<String> stringList = List.of("lambda", "is", "mysterious");
        List<String> stringList = Arrays.asList("lambda", "is", "mysterious");
        String[] strings = {"lambda", "is", "mysterious"};

        String aText = "un string";
        if (stringList.get(2).equals("comp")) {
            aText = "another string";
        }

        String finalAText = aText;
        stringList.forEach(s -> System.out.println(s + finalAText));

        // allmatch
        final String[] updatedAliasesLogins = {"", ""};
        Arrays.stream(updatedAliasesLogins).allMatch("A"::equals);


        // Streams
        IntStream streamOfChars = "adzad".chars();

        System.out.println("adzad");

        new Thread();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < 10; ++j) {
            System.out.println(j);
        }

    }

    private static Object testReturnInTryCatch() throws Exception {
        try {
            return new Object();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        // Pourquoi un return est necessaire la ?
    }

    public synchronized void capture() {

//        int localVariable = 100;
//
//        Interf i = (text) -> System.out.println(text + localVariable);
//
//        i.m1("This local variable is: ");
//
//        localVariable = 1000;
    }

    @FunctionalInterface
    interface Interf {

        void m1(String text);
    }
}
