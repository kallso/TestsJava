public class FunctionToExecuteContainer {
    private int entier = 0;

    // Fonction qui serra multi threadée
    public void testFunctionMultiThread() {
        entier++;
        System.out.println("Thread : " + Thread.currentThread().getName() + " : entier = " + entier);
    }
}
